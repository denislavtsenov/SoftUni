package p03_GetMinionNames;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        PreparedStatement stmt = connection.prepareStatement("SELECT v.`name` AS 'villains_name', " +
                "m.`name` AS 'minion_name', " +
                "m.`age` AS 'minion_age' " +
                "FROM `minions_villains` AS mv " +
                "JOIN `villains` AS v ON v.`id` = mv.`villain_id` " +
                "JOIN `minions` AS m ON m.`id` = mv.`minion_id` " +
                "WHERE mv.`villain_id` = ?;");

        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        stmt.setInt(1, villainId);

        ResultSet villainResultSet = stmt.executeQuery();

        if (villainResultSet.next()) {

            String villainName = villainResultSet.getString("villains_name");

            System.out.println("Villain: " + villainName);

            System.out.printf("%d. %s %d%n", 1,
                    villainResultSet.getString("minion_name"),
                    villainResultSet.getInt("minion_age"));

            int count = 2;
            while (villainResultSet.next()) {
                String minionName = villainResultSet.getString("minion_name");
                int minionAge = villainResultSet.getInt("minion_age");

                System.out.printf("%d. %s %d%n", count, minionName, minionAge);
                count++;
            }
        } else {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
        }
    }
}
