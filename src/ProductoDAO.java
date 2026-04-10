import java.sql.*;

public class ProductoDAO {

    public ProductoDAO() {
        try (Connection conn = Database.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS productos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre TEXT," +
                    "cantidad INTEGER)");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertar(Producto p) {
        String sql = "INSERT INTO productos(nombre, cantidad) VALUES(?, ?)";

        try (Connection conn = Database.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.nombre);
            stmt.setInt(2, p.cantidad);
            stmt.executeUpdate();

            System.out.println("Producto agregado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM productos";

        try (Connection conn = Database.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                        rs.getString("nombre") + " - " +
                        rs.getInt("cantidad"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id=?";

        try (Connection conn = Database.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Producto eliminado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}