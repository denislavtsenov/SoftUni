package org.softuni;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("hospital_db")
                .createEntityManager();
    }
}