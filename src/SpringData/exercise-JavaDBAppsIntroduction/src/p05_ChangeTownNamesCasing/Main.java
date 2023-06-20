package p05_ChangeTownNamesCasing;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = utils.myConnector.getConnection();
//        Properties props = new Properties();
//        props.setProperty("user", "root");
//        props.setProperty("password", "1234");
//
//        Connection connection =
//                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        PreparedStatement updateStatement = connection.prepareStatement(
                "UPDATE `towns` AS t " +
                        "SET t.`name` = UPPER(t.`name`) " +
                        "WHERE t.`country` = ?;");
        updateStatement.setString(1, country);

        int countRowsUpdated = updateStatement.executeUpdate();

        if (countRowsUpdated > 0) {
            PreparedStatement selectAffectedRows = connection.prepareStatement(
                    "SELECT `name` " +
                            "FROM `towns` " +
                            "WHERE `country` = ?;"
            );

            selectAffectedRows.setString(1, country);
            ResultSet resultSet = selectAffectedRows.executeQuery();

            System.out.printf("%d town names were affected.%n", countRowsUpdated);
            ArrayList<String> towns = new ArrayList<>();

            while (resultSet.next()) {
                String town = resultSet.getString("name");
                towns.add(town);
            }

            System.out.println("[" + String.join(", ", towns) + "]");

        } else {
            System.out.println("No town names were affected.");
        }
    }
}
