import entities.Address;

import javax.persistence.EntityManager;

public class p07_AddressesWithEmployeeCount {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        entityManager.createQuery(
                        "SELECT a FROM Address AS a " +
                                "ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(a -> System.out.printf("%s, %s - %d employees%n",
                        a.getText(), a.getTown().getName(), a.getEmployees().size()));
    }
}
