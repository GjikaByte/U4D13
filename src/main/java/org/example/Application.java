package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory ef = Persistence.createEntityManagerFactory("u4d13pu");
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
