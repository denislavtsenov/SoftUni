package p04_AddMinion;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String SELECT_TOWN_BY_NAME =
            "SELECT `id` " +
                    "FROM `towns` " +
                    "WHERE `name` = ?";

    private static final String INSERT_TOWN =
            "INSERT INTO `towns`(`name`) " +
                    "VALUES(?);";

    private static final String PRINT_ADDED_TOWN_MESSAGE = "Town %s was added to the database.%n";

    private static final String SELECT_VILLAIN_BY_NAME =
            "SELECT `id` FROM `villains` " +
                    "WHERE `name` = ?;";

    private static final String INSERT_VILLAIN_QUERY =
            "INSERT INTO `villains`(`name`, `evilness_factor`) " +
                    "VALUES(?, 'evil');";

    private static final String PRINT_ADDED_VILLAIN_MESSAGE = "Villain %s was added to the database.%n";

    private static final String INSERT_MINION_QUERY =
            "INSERT INTO `minions`(`name`, `age`, `town_id`) " +
                    "VALUES (?, ?, ?);";

    private static final String SELECT_LAST_MINION_QUERY =
            "SELECT * FROM `minions` " +
                    "ORDER BY `id` DESC " +
                    "LIMIT 1;";

    private static final String INSERT_IN_MINIONS_VILLAINS =
            "INSERT INTO `minions_villains`(`minion_id`, `villain_id`) " +
                    "VALUES(?, ?);";

    private static final String PRINT_ADDED_MINION_TO_VILLAIN_MESSAGE = "Successfully added %s to be minion of %s.%n";

    public static void main(String[] args) throws SQLException {

        Connection connection = utils.myConnector.getConnection();

        Scanner scanner = new Scanner(System.in);
        String[] inputMinionInfo = scanner.nextLine().split(" ");
        String inputMinionName = inputMinionInfo[1];
        int inputMinionAge = Integer.parseInt(inputMinionInfo[2]);
        String inputMinionTown = inputMinionInfo[3];

        String[] inputVillainInfo = scanner.nextLine().split(" ");
        String inputVillainName = inputVillainInfo[1];

        PreparedStatement selectTown = connection.prepareStatement(SELECT_TOWN_BY_NAME);
        selectTown.setString(1, inputMinionTown);
        ResultSet townResultSet = selectTown.executeQuery();

        int townId = 0;
        if (!townResultSet.next()) {
            PreparedStatement insertTown = connection.prepareStatement(INSERT_TOWN);

            insertTown.setString(1, inputMinionTown);
            insertTown.executeUpdate();

            ResultSet newTownsSet = selectTown.executeQuery();
            newTownsSet.next();

            townId = newTownsSet.getInt("id");

            System.out.printf(PRINT_ADDED_TOWN_MESSAGE, inputMinionTown);
        } else {
            townId = townResultSet.getInt("id");
        }

        PreparedStatement selectVillain = connection.prepareStatement(SELECT_VILLAIN_BY_NAME);
        selectVillain.setString(1, inputVillainName);
        ResultSet villainResultSet = selectVillain.executeQuery();

        int villainId = 0;
        if (!villainResultSet.next()) {

            PreparedStatement insertVillain = connection.prepareStatement(INSERT_VILLAIN_QUERY);
            insertVillain.setString(1, inputVillainName);
            insertVillain.executeUpdate();

            ResultSet newVillainResultSet = selectVillain.executeQuery();
            newVillainResultSet.next();

            villainId = newVillainResultSet.getInt("id");
            System.out.printf(PRINT_ADDED_VILLAIN_MESSAGE, inputVillainName);
        } else {
            villainId = villainResultSet.getInt("id");
        }

        PreparedStatement insertMinion = connection.prepareStatement(INSERT_MINION_QUERY);

        insertMinion.setString(1, inputMinionName);
        insertMinion.setInt(2, inputMinionAge);
        insertMinion.setInt(3, townId);

        insertMinion.executeUpdate();

        int lastMinionId = 0;
        PreparedStatement getLastMinionId = connection.prepareStatement(SELECT_LAST_MINION_QUERY);

        ResultSet lastMinionSet = getLastMinionId.executeQuery();
        lastMinionSet.next();

        lastMinionId = lastMinionSet.getInt("id");


        PreparedStatement insertInMinionsVillains = connection.prepareStatement(INSERT_IN_MINIONS_VILLAINS);
        insertInMinionsVillains.setInt(1, lastMinionId);
        insertInMinionsVillains.setInt(2, villainId);
        insertInMinionsVillains.executeUpdate();

        System.out.printf(PRINT_ADDED_MINION_TO_VILLAIN_MESSAGE,
                inputMinionName, inputVillainName);

    }
}
