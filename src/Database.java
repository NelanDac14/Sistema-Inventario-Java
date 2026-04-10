import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection conectar() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (Exception e) {
            System.out.println("Error conexión: " + e.getMessage());
            return null;
        }
    }
}