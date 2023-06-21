package p09_IncreaseAgeStoredProcedure;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String SELECT_MINIONS_NAME_AGE_BY_ID =
            "SELECT `name`, `age` " +
                    "FROM `minions` " +
                    "WHERE id = ?;";

    private static final String PRINT_MINION_DOES_NOT_EXIST = "Minion with this ID doesn't exist!";

    public static void main(String[] args) throws SQLException {

        Connection connection = utils.myConnector.getConnection();

        Scanner scanner = new Scanner(System.in);
        int minionId = Integer.parseInt(scanner.nextLine());

        CallableStatement updateAgeOfMinionById = connection.prepareCall("CALL usp_get_older(?)");
        updateAgeOfMinionById.setInt(1, minionId);
        updateAgeOfMinionById.execute();

        PreparedStatement selectMinionById = connection.prepareStatement(SELECT_MINIONS_NAME_AGE_BY_ID);

        selectMinionById.setInt(1, minionId);
        ResultSet updatedMinion = selectMinionById.executeQuery();

        if (updatedMinion.next()) {

            String minionName = updatedMinion.getString("name");
            int minionAge = updatedMinion.getInt("age");

            System.out.printf("%s %d", minionName, minionAge);
        } else {
            System.out.println(PRINT_MINION_DOES_NOT_EXIST);
        }

        connection.close();
    }
}
