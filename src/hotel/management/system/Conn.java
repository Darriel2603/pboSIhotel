package hotel.management.system;

import java.sql.*;

public class Conn {
    public Connection connection = null;
    public String url = "jdbc:oracle:thin:@localhost:1521/xe";
    public String username = "SYSTEM";
    public String password = "1234";
    public Statement s;

    public Conn() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            s = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
