package p03_GetMinionNames;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String SELECT_ALL_MINIONS_FOR_VILLAIN =
            "SELECT v.`name` AS 'villains_name', " +
                    "m.`name` AS 'minion_name', " +
                    "m.`age` AS 'minion_age' " +
                    "FROM `minions_villains` AS mv " +
                    "JOIN `villains` AS v ON v.`id` = mv.`villain_id` " +
                    "JOIN `minions` AS m ON m.`id` = mv.`minion_id` " +
                    "WHERE mv.`villain_id` = ?;";

    private static final String SELECT_VILLAIN_BY_ID =
            "SELECT `name` " +
                    "FROM `villains` " +
                    "WHERE `id` = ?;";
    private static final String PRINT_NO_SUCH_VILLAIN_ID = "No villain with ID %d exists in the database.";
    private static final String PRINT_ID_MINION_NAME_AGE = "%d. %s %d%n";
    private static final String PRINT_VILLAIN_NAME = "Villain: %s%n";

    public static void main(String[] args) throws SQLException {

        Connection connection = utils.myConnector.getConnection();

        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement selectVillainById = connection.prepareStatement(SELECT_VILLAIN_BY_ID);
        selectVillainById.setInt(1, villainId);

        PreparedStatement selectAllMinionsForVillain = connection.prepareStatement(SELECT_ALL_MINIONS_FOR_VILLAIN);
        selectAllMinionsForVillain.setInt(1, villainId);

        ResultSet villainResultSet = selectVillainById.executeQuery();

        if (!villainResultSet.next()) {

            System.out.printf(PRINT_NO_SUCH_VILLAIN_ID, villainId);

        } else {

            ResultSet minionsResultSet = selectAllMinionsForVillain.executeQuery();

            printVillainName(villainResultSet);

            printAllMinionsForVillain(minionsResultSet);
        }
        connection.close();
    }

    private static void printVillainName(ResultSet villainResultSet) throws SQLException {
        String villainName = villainResultSet.getString("name");
        System.out.printf(PRINT_VILLAIN_NAME, villainName);
    }

    private static void printAllMinionsForVillain(ResultSet minionsResultSet) throws SQLException {
        int count = 1;
        while (minionsResultSet.next()) {

            String minionName = minionsResultSet.getString("minion_name");
            int minionAge = minionsResultSet.getInt("minion_age");

            System.out.printf(PRINT_ID_MINION_NAME_AGE, count, minionName, minionAge);
            count++;
        }
    }
}