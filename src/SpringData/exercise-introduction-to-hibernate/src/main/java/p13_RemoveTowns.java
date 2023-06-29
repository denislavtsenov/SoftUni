import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class p13_RemoveTowns {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        entityManager.getTransaction().begin();

        Town townToDelete = getTown(entityManager, townName);

        List<Address> addressesToDelete = getAddresses(entityManager, townName);

        addressesToDelete.forEach(a -> a.getEmployees()
                .forEach(e -> e.setAddress(null)));

        int countDeletedAddresses = addressesToDelete.size();

        addressesToDelete.forEach(entityManager::remove);

        entityManager.remove(townToDelete);

        printInfoForDeletedAddress(townName, countDeletedAddresses);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void printInfoForDeletedAddress(String townName, int countDeletedAddresses) {
        System.out.printf("%d address%s in %s deleted",
                countDeletedAddresses,
                countDeletedAddresses == 1 ? "" : "es",
                townName);
    }

    private static List<Address> getAddresses(EntityManager entityManager, String townName) {
        List<Address> addressesToDelete = entityManager.createQuery(
                        "SELECT a FROM Address As a " +
                                "WHERE town.name = :name", Address.class)
                .setParameter("name", townName)
                .getResultList();
        return addressesToDelete;
    }

    private static Town getTown(EntityManager entityManager, String townName) {
        Town townToDelete = entityManager.createQuery(
                        "SELECT t FROM Town AS t " +
                                "WHERE t.name = :name", Town.class)
                .setParameter("name", townName)
                .getSingleResult();
        return townToDelete;
    }
}
