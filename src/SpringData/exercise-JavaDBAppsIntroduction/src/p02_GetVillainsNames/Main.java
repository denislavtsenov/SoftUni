package p02_GetVillainsNames;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        PreparedStatement stmt = connection.prepareStatement("SELECT v.name, COUNT(distinct mv.`minion_id`) AS count " +
                "FROM `villains` AS v " +
                "JOIN `minions_villains` AS mv ON v.id = mv.villain_id " +
                "GROUP BY mv.`villain_id` " +
                "HAVING COUNT(distinct mv.`minion_id`) > 15;");

       ResultSet villainsResultSet = stmt.executeQuery();

       while (villainsResultSet.next()) {
           System.out.printf("%s %d",
                   villainsResultSet.getString("name"),
                   villainsResultSet.getInt("count"));
       }
    }
}
