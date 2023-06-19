package p04_AddMinion;

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

        Scanner scanner = new Scanner(System.in);
        String[] inputMinionInfo = scanner.nextLine().split(" ");
        String inputMinionName = inputMinionInfo[1];
        int inputMinionAge = Integer.parseInt(inputMinionInfo[2]);
        String inputMinionTown = inputMinionInfo[3];

        String[] inputVillainInfo = scanner.nextLine().split(" ");
        String inputVillainName = inputVillainInfo[1];

        PreparedStatement selectTown = connection.prepareStatement(
                "SELECT `id` " +
                        "FROM `towns` " +
                        "WHERE `name` = ?");

        selectTown.setString(1, inputMinionTown);
        ResultSet townResultSet = selectTown.executeQuery();

        int townId = 0;
        if (!townResultSet.next()) {
            PreparedStatement insertTown = connection.prepareStatement(
                    "INSERT INTO `towns`(`name`) " +
                            "VALUES(?);");

            insertTown.setString(1, inputMinionTown);
            insertTown.executeUpdate();

            ResultSet newTownsSet = selectTown.executeQuery();
            newTownsSet.next();

            townId = newTownsSet.getInt("id");

            System.out.printf("Town %s was added to the database.%n", inputMinionTown);
        } else {
            townId = townResultSet.getInt("id");
        }

        PreparedStatement selectVillain = connection.prepareStatement(
                "SELECT `id` FROM `villains` " +
                        "WHERE `name` = ?;");

        selectVillain.setString(1, inputVillainName);
        ResultSet villainResultSet = selectVillain.executeQuery();

        int villainId = 0;
        if (!villainResultSet.next()) {
            PreparedStatement insertVillain = connection.prepareStatement(
                    "INSERT INTO `villains`(`name`, `evilness_factor`) " +
                            "VALUES(?, 'evil');");

            insertVillain.setString(1, inputVillainName);
            insertVillain.executeUpdate();

           ResultSet newVillainResultSet = selectVillain.executeQuery();
           newVillainResultSet.next();

           villainId = newVillainResultSet.getInt("id");
            System.out.printf("Villain %s was added to the database.%n", inputVillainName);
        } else {
            villainId = villainResultSet.getInt("id");
        }

        PreparedStatement insertMinion = connection.prepareStatement(
                "INSERT INTO `minions`(`name`, `age`, `town_id`)\n" +
                        "VALUES (?, ?, ?);");

        insertMinion.setString(1, inputMinionName);
        insertMinion.setInt(2, inputMinionAge);
        insertMinion.setInt(3, townId);

        insertMinion.executeUpdate();

        int lastMinionId = 0;
        PreparedStatement getLastMinionId = connection.prepareStatement(
                "SELECT * FROM `minions` " +
                        "ORDER BY `id` DESC " +
                        "LIMIT 1;");

        ResultSet lastMinionSet = getLastMinionId.executeQuery();
        lastMinionSet.next();

        lastMinionId = lastMinionSet.getInt("id");


        PreparedStatement insertInMinionsVillains = connection.prepareStatement(
                "INSERT INTO `minions_villains`(`minion_id`, `villain_id`)\n" +
                        "VALUES(?, ?);");
        insertInMinionsVillains.setInt(1, lastMinionId);
        insertInMinionsVillains.setInt(2, villainId);
        insertInMinionsVillains.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.%n",
                inputMinionName, inputVillainName);

    }
}
