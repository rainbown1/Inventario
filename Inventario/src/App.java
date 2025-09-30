import java.util.Scanner;
import Clases.Producto;
import Clases.claseventa;
import Clases.menuproductos;

public class App {
    
    // Contador global para IDs de venta
    private static int nextVentaID = 1;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Producto p = new Producto();
        int opcion;
        
        claseventa[] Guardar = new claseventa[5]; 
        Producto[] productos = new Producto[15];
        productos[0] = new Producto("Laptop", 12500.50, 5);
        productos[1] = new Producto("Mouse", 250.75, 20);
        productos[2] = new Producto("Teclado", 450.00, 15);
        productos[3] = new Producto("Audífonos", 300.0, 30);
        productos[4] = new Producto("Cargador", 3000.0, 28);
        menuproductos menuProd = new menuproductos(productos);

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Productos");
            System.out.println("2. Ventas");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            try {
                 opcion = Integer.parseInt(s.nextLine()); 
            } catch (NumberFormatException e) {
                 opcion = 0; 
            }


            switch (opcion) {
                case 1:
                    menuProd.mostrarMenu(s);
                    break;

                case 2:
                    int opcionVentas;
                    do {
                        System.out.println("\n-|Ventas|-");
                        System.out.println("1-Registrar una venta");
                        System.out.println("2-Total ventas");
                        System.out.println("3-Buscar venta");
                        System.out.println("4-Regresar al menú");
                        
                        try {
                            opcionVentas = Integer.parseInt(s.nextLine());
                        } catch (NumberFormatException e) {
                            opcionVentas = 0; 
                        }

                        switch (opcionVentas) {
                            case 1:
                                boolean ventaRegistrada = false;
                                for (int i = 0; i < Guardar.length; i++) {
                                    if (Guardar[i] == null) {
                                        Guardar[i] = new claseventa();
                                        Guardar[i].setid(nextVentaID);
                                        
                                        System.out.print("Nombre del producto deseado: ");
                                        String nombreProducto = s.nextLine();
                                        
                                        Producto productoAVender = p.obtenerProducto(productos, nombreProducto);
                                        
                                        if (productoAVender == null) {
                                            System.out.println("No se puede registrar la venta. Producto no encontrado.");
                                            Guardar[i] = null;
                                            ventaRegistrada = true; 
                                            break;
                                        }
                                        int cantidad = 0;
                                        boolean cantidadValida = false;
                                        while (!cantidadValida) {
                                            System.out.print("Cantidad de productos a comprar: ");
                                            try {
                                                cantidad = Integer.parseInt(s.nextLine());
                                                if (cantidad > productoAVender.getStock()) {
                                                    System.out.println("Error: Stock insuficiente. Solo quedan " + productoAVender.getStock() + " unidades.");
                                                } else if (cantidad <= 0) {
                                                     System.out.println("Error: La cantidad debe ser mayor a cero.");
                                                } else {
                                                    Guardar[i].setcantidadProdu(cantidad);
                                                    cantidadValida = true;
                                                }
                                            } catch (NumberFormatException e) {
                                                System.out.println("Error: Ingresa solo un número entero para la cantidad.");
                                            }
                                        }
                                        if (cantidadValida) {
                                            double totalDouble = productoAVender.getPrecio() * cantidad;
                                            int totalVenta = (int) Math.round(totalDouble); 
                                            Guardar[i].setNombreProducto(productoAVender.getName());
                                            Guardar[i].setPrecioUnitario(productoAVender.getPrecio());
                                            Guardar[i].settotal(totalVenta);
                                            productoAVender.reducirStock(cantidad);
                                            nextVentaID++;

                                            System.out.println("\n--- Resumen de Venta ---");
                                            System.out.println("Producto: " + Guardar[i].getNombreProducto());
                                            System.out.println("Cantidad: " + Guardar[i].getcantidadProdu());
                                            System.out.println("Precio Unitario: " + String.format("$%.2f", Guardar[i].getPrecioUnitario()));
                                            System.out.println("Total calculado: " + String.format("$%.2f", totalDouble));
                                            System.out.println("Venta #" + Guardar[i].getid() + " registrada con éxito.");
                                            System.out.println("Stock restante de " + productoAVender.getName() + ": " + productoAVender.getStock());
                                            
                                            ventaRegistrada = true;
                                        } else {
                                            Guardar[i] = null;
                                            ventaRegistrada = true; 
                                        }
                                        
                                        break; 
                                    }
                                }
                                if (!ventaRegistrada) {
                                    System.out.println("No hay espacio libre en el registro de ventas.");
                                }
                                break;

                            case 2:
                                System.out.println("\n--- Ventas Registradas ---");
                                for (int i = 0; i < Guardar.length; i++) {
                                    if (Guardar[i] != null) {
                                        System.out.println("Venta #" + Guardar[i].getid());
                                        System.out.println("  Producto: " + Guardar[i].getNombreProducto());
                                        System.out.println("  Cantidad: " + Guardar[i].getcantidadProdu());
                                        System.out.println("  Total: $" + Guardar[i].gettotal()); 
                                    }
                                }
                                break;

                            case 3:
                                System.out.print("Ingresa ID de la venta a buscar: ");
                                int idbuscar;
                                try {
                                    idbuscar = Integer.parseInt(s.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Error: Ingresa solo un número entero para el ID.");
                                    break;
                                }

                                boolean encontrado = false;
                                for (int i = 0; i < Guardar.length; i++) {
                                    if (Guardar[i] != null && Guardar[i].getid() == idbuscar) {
                                        System.out.println("\n--- Detalle de Venta #" + Guardar[i].getid() + " ---");
                                        System.out.println("Producto: " + Guardar[i].getNombreProducto());
                                        System.out.println("Cantidad: " + Guardar[i].getcantidadProdu());
                                        System.out.println("Precio Unitario: " + String.format("$%.2f", Guardar[i].getPrecioUnitario()));
                                        System.out.println("Total de Venta: $" + Guardar[i].gettotal()); 
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("ID de venta no encontrado");
                                }
                                break;
                        }
                    } while (opcionVentas != 4);
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 3);

        s.close();
    }
}