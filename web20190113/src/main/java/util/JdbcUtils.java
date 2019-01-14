package util;

import java.sql.*;

public class JdbcUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kukuku", "root", "root");
        return conn;
    }
    public static int getind() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kukuku", "root","root");
        PreparedStatement psmt = conn.prepareStatement ( "select max(sid) from student;" );
        ResultSet resultSet = psmt.executeQuery ( );
        int id=-1;
        while (resultSet.next ()){
            id=resultSet.getInt ( "max(sid)" );
        }
        return id+1;
    }
}
