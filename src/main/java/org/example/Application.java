package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory ef = Persistence.createEntityManagerFactory("u4d13pu");
    public static void main(String[] args) {
        EntityManager em;
        em = ef.createEntityManager();


        System.out.println("Hello World!");
    }
}
