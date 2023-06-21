package p07_PrintAllMinionNames;

import java.sql.*;

public class Main {

    private static final String SELECT_NAMES_FROM_MINIONS = "SELECT `name` FROM `minions`;";

    public static void main(String[] args) throws SQLException {

        Connection connection = utils.myConnector.getConnection();

        PreparedStatement selectMinionsNames = connection.prepareStatement(SELECT_NAMES_FROM_MINIONS,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ResultSet minionsResultSet = selectMinionsNames.executeQuery();

        int minionsCount = getMinionsCount(minionsResultSet);

        int firstIndex = 1;
        int lastIndex = minionsCount;

        minionsResultSet.beforeFirst();

        printMinionsNames(minionsResultSet, minionsCount, firstIndex, lastIndex);
    }

    private static int getMinionsCount(ResultSet minionsResultSet) throws SQLException {
        int minionsCount = 0;

        while (minionsResultSet.next()) {
            minionsCount++;
        }
        return minionsCount;
    }

    private static void printMinionsNames(ResultSet minionsResultSet, int minionsCount, int firstIndex, int lastIndex) throws SQLException {
        for (int i = 1; i < minionsCount + 1; i++) {

            if (i % 2 != 0) {
                minionsResultSet.absolute(firstIndex);
                firstIndex++;
            } else {
                minionsResultSet.absolute(lastIndex);
                lastIndex--;
            }

            System.out.println(minionsResultSet.getString("name"));

            minionsResultSet.next();
        }
    }
}
