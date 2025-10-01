package Clases;

import java.util.Scanner;

public class menuproductos {

    private Producto[] productos;
    private Producto p = new Producto();
    String[] categorias = {"Abarrotes","Aseo Personal","Bebidas","Lacteos","Mascotas"};

    public menuproductos(Producto[] productos) {
        this.productos = productos;
    }

    public void mostrarMenu(Scanner s) {
        char opcionProd;
        do {
            System.out.println("\n--- Menu de Productos ---");
            System.out.println("a. Registrar producto");
            System.out.println("b. Ver inventario (ordenado por precio)");
            System.out.println("c. Ver productos a reabastecer"); 
            System.out.println("d. Buscar producto por precio");
            System.out.println("e. Regresar al menu principal");
            System.out.println("f. Reabastecer producto"); 
            System.out.print("Elige una opcion: ");

            String input = s.nextLine(); 
            if (input.isEmpty()) {
                opcionProd = ' '; 
            } else {
                opcionProd = input.toLowerCase().charAt(0);
            }

            switch (opcionProd) {
                case 'a':
                    System.out.print("Nombre: ");
                    String nuevoNombre = s.nextLine();
                    
                    if (p.obtenerProducto(productos, nuevoNombre) != null) {
                        System.out.println("Error: El producto ya existe. Usa la opcion 'f' para reabastecer.");
                        break;
                    }
                    
                    System.out.print("Precio: ");
                    double nuevoPrecio;
                    try {
                        nuevoPrecio = s.nextDouble();
                        s.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Error: Ingresa un precio valido (numero).");
                        s.nextLine();
                        break;
                    }
                    System.out.println("--- Elige una categoria ---");
                    System.out.println("1. Abarrotes ");
                    System.out.println("2. Aseo Personal ");
                    System.out.println("3. Bebidas ");
                    System.out.println("4. Lacteos ");
                    System.out.println("5. Mascotas ");
                    int opCat = s.nextInt();
                    String categoria = " ";
                    switch (opCat) {
                        case 1:
                            categoria = categorias[0];
                            break;
                        case 2:
                            categoria = categorias[1];
                            break;
                        case 3:
                            categoria = categorias[2];
                            break;
                        case 4:
                            categoria = categorias[3];
                            break;
                        case 5:
                            categoria = categorias[4];
                            break;
                    
                        default:
                            categoria = "Sin Categoria";
                            break;
                    }
                    

                    System.out.print("Stock: ");
                    int nuevoStock = s.nextInt();
                    s.nextLine();
                    
                    boolean registrado = false;
                    for (int i = 0; i < productos.length; i++) {
                        if (productos[i] == null) {
                            productos[i] = new Producto(nuevoNombre, nuevoPrecio, categoria, nuevoStock);
                            registrado = true;
                            System.out.println("Producto registrado con exito.");
                            break;
                        }
                    }
                    if (!registrado) {
                        System.out.println("No hay espacio para registrar mas productos.");
                    }
                    break;

                case 'b':
                    p.getInventario(productos);
                    System.out.println("\n--- Inventario Ordenado ---");
                    for (Producto prod : productos) {
                        if (prod != null) {
                            System.out.println(prod);
                        }
                    }
                    break;

                case 'c':
                    System.out.println("\n--- Productos a reabastecer (Stock < 3) ---");
                    boolean necesitaReabastecer = false;
                    for (Producto prod : productos) {
                        if (prod != null && prod.getStock() < 3) {
                            System.out.println(prod);
                            necesitaReabastecer = true;
                        }
                    }
                    if (!necesitaReabastecer) {
                        System.out.println("Todo el inventario esta en buen nivel de stock.");
                    }
                    break;

                case 'd':
                    System.out.print("Introduce el precio a buscar: ");
                    double precioBuscar = s.nextDouble();
                    s.nextLine();
                    boolean encontrado = false;
                    for (Producto prod : productos) {
                        if (prod != null && Math.abs(prod.getPrecio() - precioBuscar) < 0.01) {
                            System.out.println("Producto encontrado: " + prod);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontro ningun producto con ese precio.");
                    }
                    break;

                case 'e':
                    System.out.println("Regresando al menu principal...");
                    break;

                case 'f':
                    System.out.print("Nombre del producto a reabastecer: ");
                    String nombreReabastecer = s.nextLine();
                    
                    Producto productoReabastecer = p.obtenerProducto(productos, nombreReabastecer);

                    if (productoReabastecer == null) {
                        System.out.println("Error: Producto no encontrado. No se puede reabastecer.");
                        break;
                    }
                    
                    int cantidadAumentar = 0;
                    boolean cantidadValida = false;
                    while (!cantidadValida) {
                        System.out.print("Cantidad de unidades a anadir (stock actual: " + productoReabastecer.getStock() + "): ");
                        try {
                            cantidadAumentar = Integer.parseInt(s.nextLine());
                            if (cantidadAumentar <= 0) {
                                System.out.println("Error: La cantidad a anadir debe ser mayor a cero.");
                            } else {
                                cantidadValida = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresa solo un numero entero para la cantidad.");
                        }
                    }
                    
                    productoReabastecer.aumentarStock(cantidadAumentar);
                    System.out.println("Inventario de '" + productoReabastecer.getName() + "' actualizado.");
                    System.out.println("Nuevo stock: " + productoReabastecer.getStock());
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcionProd != 'e');
    }
}