package Level2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class DBtoJSONReport {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "your_password";

        String query = "SELECT id, name, email, age FROM users";

        JSONArray jsonArray = new JSONArray();

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                JSONObject row = new JSONObject();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                jsonArray.put(row);
            }

            System.out.println("Generated JSON Report:\n" + jsonArray.toString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
