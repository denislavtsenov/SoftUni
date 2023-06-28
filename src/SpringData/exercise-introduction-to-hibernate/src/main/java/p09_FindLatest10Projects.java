import entities.Project;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;

public class p09_FindLatest10Projects {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        List<Project> projectList = getProjectList(entityManager);

        projectList.sort(Comparator.comparing(Project::getName));

        printProjectsInfo(projectList);
    }

    private static List<Project> getProjectList(EntityManager entityManager) {
        List<Project> projectList = entityManager.createQuery(
                        "SELECT p FROM Project AS p " +
                                "ORDER BY p.startDate DESC ", Project.class)
                .setMaxResults(10)
                .getResultList();
        return projectList;
    }

    private static void printProjectsInfo(List<Project> projectList) {
        for (Project project : projectList) {
            System.out.printf("Project name: %s%n" +
                            "       Project Description: %s%n" +
                            "       Project Start Date: %s%n" +
                            "       Project End Date: %s%n",
                    project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate());
        }
    }
}
