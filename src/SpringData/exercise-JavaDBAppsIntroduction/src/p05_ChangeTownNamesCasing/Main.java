package p05_ChangeTownNamesCasing;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String UPDATE_TOWNS_NAME_TO_UPPERCASE =
            "UPDATE `towns` AS t " +
                    "SET t.`name` = UPPER(t.`name`) " +
                    "WHERE t.`country` = ?;";

    private static final String SELECT_TOWNS_BY_COUNTRY =
            "SELECT `name` " +
                    "FROM `towns` " +
                    "WHERE `country` = ?;";

    private static final String PRINT_COUNT_UPDATED_ROWS = "%d town names were affected.%n";
    private static final String PRINT_NO_TOWN_NAMES_AFFECTED = "No town names were affected.";

    public static void main(String[] args) throws SQLException {

        Connection connection = utils.myConnector.getConnection();

        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        int countRowsUpdated = updateTownsName(connection, country);

        if (countRowsUpdated > 0) {
            PreparedStatement selectAffectedRows = connection.prepareStatement(SELECT_TOWNS_BY_COUNTRY);

            selectAffectedRows.setString(1, country);
            ResultSet resultSet = selectAffectedRows.executeQuery();

            System.out.printf(PRINT_COUNT_UPDATED_ROWS, countRowsUpdated);
            ArrayList<String> towns = new ArrayList<>();

            while (resultSet.next()) {
                String town = resultSet.getString("name");
                towns.add(town);
            }

            System.out.println("[" + String.join(", ", towns) + "]");

        } else {
            System.out.println(PRINT_NO_TOWN_NAMES_AFFECTED);
        }
        connection.close();
    }

    private static int updateTownsName(Connection connection, String country) throws SQLException {
        PreparedStatement updateTownsName = connection.prepareStatement(UPDATE_TOWNS_NAME_TO_UPPERCASE);
        updateTownsName.setString(1, country);

        int countRowsUpdated = updateTownsName.executeUpdate();
        return countRowsUpdated;
    }
}
