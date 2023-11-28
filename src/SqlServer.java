import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServer {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/salon_frumusete";
        String username = "ralucx2";
        String password = "ralucx2";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to the SQL Server database");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}