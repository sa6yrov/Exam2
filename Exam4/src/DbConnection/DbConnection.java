package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final static String url = "jdbc:postgresql://localhost:5432/Exam";
    private final static String user = "postgres";
    private final static String password = "postgres";

    public static Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
