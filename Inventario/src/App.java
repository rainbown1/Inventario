import java.util.Scanner;
import Clases.Producto;
import Clases.claseventa;
import Clases.menuproductos;

public class App {
    
    private static int nextVentaID = 1;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Producto p = new Producto();
        int opcion;
        
        claseventa[] Guardar = new claseventa[5]; 
        Producto[] productos = new Producto[15];
        menuproductos menuProd = new menuproductos(productos);

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Productos");
            System.out.println("2. Ventas");
            System.out.println("3. Salir");
            System.out.print("Elige una opcion: ");
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
                        System.out.println("4-Regresar al menu");
                        
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
                                        
                                        double totalAcumulado = 0.0;
                                        StringBuilder detallesVenta = new StringBuilder();
                                        boolean agregarMas = true;
                                        boolean productoAgregado = false; 

                                        do {
                                            System.out.println("\n--- Agregando Producto a Venta #" + nextVentaID + " ---");
                                            System.out.print("Nombre del producto a vender (o 'FIN' para terminar): ");
                                            String nombreProducto = s.nextLine();

                                            if (nombreProducto.equalsIgnoreCase("FIN")) {
                                                agregarMas = false;
                                                break;
                                            }
                                            
                                            Producto productoAVender = p.obtenerProducto(productos, nombreProducto);
                                            
                                            if (productoAVender == null) {
                                                System.out.println("Producto no encontrado. Intenta con otro nombre.");
                                                continue;
                                            }
                                            
                                            int cantidad = 0;
                                            boolean cantidadValida = false;
                                            while (!cantidadValida) {
                                                System.out.print("Cantidad de " + productoAVender.getName() + " a comprar: ");
                                                try {
                                                    cantidad = Integer.parseInt(s.nextLine());
                                                    if (cantidad > productoAVender.getStock()) {
                                                        System.out.println("Error: Stock insuficiente. Solo quedan " + productoAVender.getStock() + " unidades.");
                                                    } else if (cantidad <= 0) {
                                                         System.out.println("Error: La cantidad debe ser mayor a cero.");
                                                    } else {
                                                        cantidadValida = true;
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Error: Ingresa solo un numero entero para la cantidad.");
                                                }
                                            }

                                            if (cantidadValida) {
                                                double subtotal = productoAVender.getPrecio() * cantidad;
                                                totalAcumulado += subtotal;

                                                detallesVenta.append(" - ").append(productoAVender.getName())
                                                        .append(" (x").append(cantidad)
                                                        .append(" @ $").append(String.format("%.2f", productoAVender.getPrecio()))
                                                        .append(") Subtotal: $").append(String.format("%.2f", subtotal))
                                                        .append("\n");
                                                
                                                productoAVender.reducirStock(cantidad);
                                                productoAgregado = true;
                                                System.out.println("Producto agregado. Stock restante: " + productoAVender.getStock());
                                            }

                                            System.out.print("Quieres agregar otro producto? (s/n): ");
                                            String respuesta = s.nextLine();
                                            if (!respuesta.equalsIgnoreCase("s")) {
                                                agregarMas = false;
                                            }
                                        } while (agregarMas);

                                        if (productoAgregado) {
                                            int totalVentaFinal = (int) Math.round(totalAcumulado); 
                                            
                                            Guardar[i].settotal(totalVentaFinal);
                                            
                                            Guardar[i].setNombreProducto(detallesVenta.toString()); 
                                            
                                            nextVentaID++;
                                            ventaRegistrada = true;

                                            System.out.println("\n==================================");
                                            System.out.println("     Venta #" + Guardar[i].getid() + " Registrada");
                                            System.out.println("==================================");
                                            System.out.println("Productos:\n" + detallesVenta.toString().trim());
                                            System.out.println("TOTAL: $" + String.format("%.2f", totalAcumulado) + " (Total guardado: $" + totalVentaFinal + ")");
                                            System.out.println("==================================");
                                            
                                        } else {
                                            Guardar[i] = null;
                                            ventaRegistrada = true; 
                                            System.out.println("Venta cancelada. Ningun producto agregado.");
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
                                        System.out.println("  Productos:\n" + Guardar[i].getNombreProducto().trim()); 
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
                                    System.out.println("Error: Ingresa solo un numero entero para el ID.");
                                    break;
                                }

                                boolean encontrado = false;
                                for (int i = 0; i < Guardar.length; i++) {
                                    if (Guardar[i] != null && Guardar[i].getid() == idbuscar) {
                                        System.out.println("\n--- Detalle de Venta #" + Guardar[i].getid() + " ---");
                                        System.out.println("Productos Vendidos:\n" + Guardar[i].getNombreProducto().trim()); 
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
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 3);

        s.close();
    }
}