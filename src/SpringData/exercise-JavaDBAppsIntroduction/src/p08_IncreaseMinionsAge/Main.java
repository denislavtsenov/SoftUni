package p08_IncreaseMinionsAge;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String UPDATE_MINIONS_NAME_AND_AGE_BY_ID =
            "UPDATE `minions` " +
                    "SET `name` = LOWER(`name`), " +
                    "`age` = `age` + 1 " +
                    "WHERE `id` IN (?);";

    private static final String SELECT_NAME_AGE_FROM_MINIONS =
            "SELECT `name`, `age` FROM `minions`;";

    public static void main(String[] args) throws SQLException {

        Connection connection = utils.myConnector.getConnection();

        Scanner scanner = new Scanner(System.in);
        int[] minionIds = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        updateMinionsByIds(connection, minionIds);

        PreparedStatement getAllMinions = connection.prepareStatement(SELECT_NAME_AGE_FROM_MINIONS);

        ResultSet minionsResultSet = getAllMinions.executeQuery();

        printMinionsNameAndAge(minionsResultSet);

        connection.close();
    }

    private static void updateMinionsByIds(Connection connection, int[] minionIds) throws SQLException {
        for (int i = 0; i < minionIds.length; i++) {

            int currentId = minionIds[i];

            PreparedStatement updateStatement = connection.prepareStatement(UPDATE_MINIONS_NAME_AND_AGE_BY_ID);
            updateStatement.setInt(1, currentId);

            updateStatement.executeUpdate();
        }
    }

    private static void printMinionsNameAndAge(ResultSet minionsResultSet) throws SQLException {
        while (minionsResultSet.next()) {
            String name = minionsResultSet.getString("name");
            int age = minionsResultSet.getInt("age");

            System.out.printf("%s %d%n", name, age);
        }
    }
}
