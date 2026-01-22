package dao;

import entities.persona;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class personaDAO {
    private final EntityManager em;

    public personaDAO(EntityManager em) {
        this.em = em;
    }
    public void save(persona nuovaPersona){
        // 1.nuova transazione
        EntityTransaction transaction = em.getTransaction();

        // 2. Inizializzare transazione
        transaction.begin();

        // 3. Aggiungiamo il nuovoEvento al PersistenceContext
        em.persist(nuovaPersona);

        // 4. Commit
        transaction.commit();

        // 5. SO
        System.out.println("Il Sig/La Sig.ra " + nuovaPersona.toString() + " è stato/a salvato/a correttamente nel DB!");

    }

    public persona getbyID(String personaId){
        persona found = em.find(persona.class, UUID.fromString(personaId));
        if (found == null) throw new NotFoundException(personaId);
        return found;
    }

    public void findByIdAndDelete(String eventID) {
        // 1. Cerco lo studente
        persona found = this.getbyID(eventID);

        // 2. Creo una nuova transazione
        EntityTransaction transaction = em.getTransaction();

        // 3. Faccio partire la transazione
        transaction.begin();

        // 4. Rimuovo dal Persistence Context l'oggetto in questione
        em.remove(found);

        // 5. commit
        transaction.commit();

        // 6. Log di avvenuta cancellazione
        System.out.println("La persona con id: " + eventID + " è stata eliminata correttamente!");
    }
}
