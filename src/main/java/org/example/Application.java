package org.example;

import dao.locationDAO;
import dao.partecipazioniDAO;
import entities.location;
import entities.partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory ef = Persistence.createEntityManagerFactory("u4d13pu");
    public static void main(String[] args) {
        EntityManager em;
        em = ef.createEntityManager();

        locationDAO ld = new locationDAO(em);
        location l1 = new location("Milano","Macarena");
        /*ld.save(l1);*/

        partecipazioniDAO pd = new partecipazioniDAO(em);
        partecipazione p1 = new partecipazione(partecipazione.Stato.CONFERMATA);
        /*pd.save(p1);*/

        location l1DB = ld.getbyID("1227b345-6ebc-4068-9fa9-74a75574ffdd");
        partecipazione p1DB = pd.getbyID("1aea1319-c4a3-4056-8eac-801c5ab1e592");


        System.out.println("Hello World!");

        ef.close();
        em.close();
    }
}
