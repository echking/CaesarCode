package DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/encryption?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "";
    static final String PASSWORD = "";
    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn) {
        if (conn != null)
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
