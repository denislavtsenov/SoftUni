import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

public class p02_ChangeCasing {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        List<Town> towns = entityManager.createQuery(
                        "SELECT t FROM Town AS t " +
                                "WHERE length(t.name) <= 5", Town.class)
                .getResultList();

        towns.forEach(entityManager::detach);

        for (Town town : towns) {
            town.setName(town.getName().toUpperCase());
        }

        entityManager.getTransaction().begin();

        towns.forEach(entityManager::merge);

        entityManager.flush();

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
