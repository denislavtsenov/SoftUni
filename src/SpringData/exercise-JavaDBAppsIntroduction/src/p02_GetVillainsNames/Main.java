package p02_GetVillainsNames;

import java.sql.*;


public class Main {
    private static final String SELECT_VILLAIN_WITH_OVER_15_MINIONS =
            "SELECT v.name, COUNT(distinct mv.`minion_id`) AS count " +
                    "FROM `villains` AS v " +
                    "JOIN `minions_villains` AS mv ON v.id = mv.villain_id " +
                    "GROUP BY mv.`villain_id` " +
                    "HAVING COUNT(distinct mv.`minion_id`) > 15;";

    private static final String PRINT_VILLAIN_NAME_MINIONS_COUNT = "%s %d";

    public static void main(String[] args) throws SQLException {

        Connection connection = utils.myConnector.getConnection();

        PreparedStatement selectVillains = connection.prepareStatement(SELECT_VILLAIN_WITH_OVER_15_MINIONS);

        ResultSet villainsResultSet = selectVillains.executeQuery();

        while (villainsResultSet.next()) {

            String villainName = villainsResultSet.getString("name");
            int minionsCount = villainsResultSet.getInt("count");

            System.out.printf(PRINT_VILLAIN_NAME_MINIONS_COUNT, villainName, minionsCount);
        }
    }
}
