package p08_IncreaseMinionsAge;

import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = utils.myConnector.getConnection();

        Scanner scanner = new Scanner(System.in);
        int[] minionIds = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < minionIds.length; i++) {

            int currentId = minionIds[i];

            PreparedStatement updateStatement = connection.prepareStatement(
                    "UPDATE `minions` " +
                            "SET `name` = LOWER(`name`), " +
                            "`age` = `age` + 1 " +
                            "WHERE `id` IN (?);");
            updateStatement.setInt(1, currentId);

            updateStatement.executeUpdate();
        }

        PreparedStatement getAllMinions = connection.prepareStatement(
                "SELECT `name`, `age` FROM `minions`;");

        ResultSet minionsResultSet = getAllMinions.executeQuery();

        while (minionsResultSet.next()) {
            String name = minionsResultSet.getString("name");
            int age = minionsResultSet.getInt("age");

            System.out.printf("%s %d%n", name, age);
        }
    }
}
