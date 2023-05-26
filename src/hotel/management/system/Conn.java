package hotel.management.system;

import java.sql.*;

public class Conn {
    Connection connection = null;
    String url = "jdbc:oracle:thin:@localhost:1521/xe";
    String username = "SYSTEM";
    String password = "1234";
    Statement s;

    Conn() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            s = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
