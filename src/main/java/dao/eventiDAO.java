package dao;

import entities.eventi;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class eventiDAO {
    private final EntityManager em;

    public eventiDAO(EntityManager em) {
        this.em = em;
    }
    public void save(eventi nuovoEvento){
        // 1.nuova transazione
        EntityTransaction transaction = em.getTransaction();

        // 2. Inizializzare transazione
        transaction.begin();

        // 3. Aggiungiamo il nuovoEvento al PersistenceContext
        em.persist(nuovoEvento);

        // 4. Commit
        transaction.commit();

        // 5. SO
        System.out.println("L'evento' " + nuovoEvento.getTitolo() + " è stato salvato correttamente nel DB!");

    }

    public eventi getbyID(String eventId){
        eventi found = em.find(eventi.class, eventId);
        if (found == null) throw new NotFoundException(eventId);
        return found;
    }

    public void findByIdAndDelete(String eventID) {
        // 1. Cerco lo studente
        eventi found = this.getbyID(eventID);

        // 2. Creo una nuova transazione
        EntityTransaction transaction = em.getTransaction();

        // 3. Faccio partire la transazione
        transaction.begin();

        // 4. Rimuovo dal Persistence Context l'oggetto in questione
        em.remove(found);

        // 5. commit
        transaction.commit();

        // 6. Log di avvenuta cancellazione
        System.out.println("L'evento con id: " + eventID + " è stato eliminato correttamente!");
    }
}
