package org.softuni;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("sales_db")
                .createEntityManager();
    }
}