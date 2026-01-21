package dao;

import entities.location;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class locationDAO {
    private final EntityManager em;

    public locationDAO(EntityManager em) {
        this.em = em;
    }
    public void save(location nuovalocation){
        // 1.nuova transazione
        EntityTransaction transaction = em.getTransaction();

        // 2. Inizializzare transazione
        transaction.begin();

        // 3. Aggiungiamo il nuovoEvento al PersistenceContext
        em.persist(nuovalocation);

        // 4. Commit
        transaction.commit();

        // 5. SO
        System.out.println("La location " + nuovalocation.toString() + " è stato/a salvato/a correttamente nel DB!");

    }

    public location getbyID(String locationID){
        location found = em.find(location.class, locationID);
        if (found == null) throw new NotFoundException(locationID);
        return found;
    }

    public void findByIdAndDelete(String locationID) {
        // 1. Cerco lo studente
        location found = this.getbyID(locationID);

        // 2. Creo una nuova transazione
        EntityTransaction transaction = em.getTransaction();

        // 3. Faccio partire la transazione
        transaction.begin();

        // 4. Rimuovo dal Persistence Context l'oggetto in questione
        em.remove(found);

        // 5. commit
        transaction.commit();

        // 6. Log di avvenuta cancellazione
        System.out.println("La location con id: " + locationID + " è stata eliminata correttamente!");
    }
}
