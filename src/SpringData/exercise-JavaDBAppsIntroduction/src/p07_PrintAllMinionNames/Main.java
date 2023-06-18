package p07_PrintAllMinionNames;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        PreparedStatement stmt = connection.prepareStatement("SELECT `name` FROM `minions`;",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ResultSet minionsResultSet = stmt.executeQuery();

int minionsCount = 0;

      while (minionsResultSet.next()) {
          minionsCount++;
      }

        int firstIndex = 1;
        int lastIndex = minionsCount;

      minionsResultSet.beforeFirst();

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
