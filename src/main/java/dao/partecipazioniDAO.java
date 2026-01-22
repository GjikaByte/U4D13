package dao;

import entities.eventi;
import entities.partecipazione;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class partecipazioniDAO {
    private final EntityManager em;

    public partecipazioniDAO(EntityManager em) {
        this.em = em;
    }
    public void save(partecipazione nuovoPartecipazione){
        // 1.nuova transazione
        EntityTransaction transaction = em.getTransaction();

        // 2. Inizializzare transazione
        transaction.begin();

        // 3. Aggiungiamo il nuovoEvento al PersistenceContext
        em.persist(nuovoPartecipazione);

        // 4. Commit
        transaction.commit();

        // 5. SO
        System.out.println("La partecipazione' " + nuovoPartecipazione + " è stato salvato correttamente nel DB!");

    }

    public partecipazione getbyID(String partecipazioneId){
        partecipazione found = em.find(partecipazione.class, UUID.fromString(partecipazioneId));
        if (found == null) throw new NotFoundException(partecipazioneId);
        return found;
    }

    public void findByIdAndDelete(String partecipazioneId) {
        // 1. Cerco lo studente
        partecipazione found = this.getbyID(partecipazioneId);

        // 2. Creo una nuova transazione
        EntityTransaction transaction = em.getTransaction();

        // 3. Faccio partire la transazione
        transaction.begin();

        // 4. Rimuovo dal Persistence Context l'oggetto in questione
        em.remove(found);

        // 5. commit
        transaction.commit();

        // 6. Log di avvenuta cancellazione
        System.out.println("L'evento con id: " + partecipazioneId + " è stato eliminato correttamente!");
    }
}
