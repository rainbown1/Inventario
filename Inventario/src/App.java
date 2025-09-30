import java.util.Scanner;

import Clases.Producto;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        Producto p = new Producto();
        Producto[] productos = new Producto[5];

        productos[0] = new Producto("Laptop", 12500.50, 5);
        productos[1] = new Producto("Mouse", 250.75, 20);
        productos[2] = new Producto("Teclado", 450.00, 15);
        productos[3] = new Producto("audifonos", 300.0, 30);
        productos[4] = new Producto("Cargador", 3000.0, 28);

        
        p.getInventario(productos);

         for (Producto producto : productos) {
            System.out.println(producto);
        }

        System.err.println("Buscar un proucto: ");
        String nombre = s.nextLine();
        p.buscarProducto(productos, nombre);
    }
}
