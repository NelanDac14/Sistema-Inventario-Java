import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- SISTEMA DE INVENTARIO ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    dao.insertar(new Producto(nombre, cantidad));
                    break;

                case 2:
                    dao.listar();
                    break;

                case 3:
                    System.out.print("ID a eliminar: ");
                    int id = sc.nextInt();
                    dao.eliminar(id);
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}