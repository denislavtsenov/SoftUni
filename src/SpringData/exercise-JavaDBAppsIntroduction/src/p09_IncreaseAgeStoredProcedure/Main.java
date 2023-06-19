package p09_IncreaseAgeStoredProcedure;

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
        int minionId = Integer.parseInt(scanner.nextLine());

        CallableStatement updateAgeOfMinionById = connection.prepareCall("CALL usp_get_older(?)");
        updateAgeOfMinionById.setInt(1, minionId);
        updateAgeOfMinionById.execute();


        PreparedStatement selectMinionById = connection.prepareStatement(
                "SELECT `name`, `age` " +
                        "FROM `minions` " +
                        "WHERE id = ?;");

        selectMinionById.setInt(1, minionId);
        ResultSet updatedMinion = selectMinionById.executeQuery();

        if (updatedMinion.next()) {

            String minionName = updatedMinion.getString("name");
            int minionAge = updatedMinion.getInt("age");

            System.out.printf("%s %d", minionName, minionAge);
        } else {
            System.out.println("Minion with this ID doesn't exist!");
        }
    }
}
