package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB = "registry";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "abrwbz0919";
    public static final String TABLE = "animals";

    static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection conn = null;
        return conn;
    }

        public static void con () {
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }



    }

