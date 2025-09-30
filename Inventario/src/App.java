import java.util.Scanner;

import Clases.Producto;
import Clases.claseventa;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        Producto p = new Producto();
        int opcion;
        claseventa[] Guardar = new claseventa[2];
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


     do {

    System.out.println("-|Ventas|-");
    System.out.println("-Elige la opcion que necesites!");
    System.out.println("1-Registrar una venta");
    System.out.println("2-Total ventas");
    System.out.println("3-Buscar venta");
    System.out.println("4-Regresar al menu");
    opcion= s.nextInt();

   switch (opcion) {
    case 1:
          
        
            for (int i = 0; i < Guardar.length; i++) {
               Guardar[i]= new claseventa();
               Guardar[i].setid(i+1);
            System.out.print("Cantidad de productos a comprar;");
            Guardar[i].setcantidadProdu(s.nextInt());
            System.out.println("Total: ");
            Guardar[i].settotal(s.nextInt());
           
        
            
        }
        break;
   case 2:
      System.out.println("\n--- Ventas Registradas ---");
       
        for (int i = 0; i < Guardar.length; i++) {
            System.out.println("Venta #"+Guardar[i].getid() );
            System.out.println("Cantidad de productos: " +Guardar[i].getcantidadProdu());
            System.out.println("Total:"+Guardar[i].gettotal());
        }
   break;
   case 3:
   int idbuscar;
       System.out.println("Ingresa id a buscar: ");
      idbuscar= s.nextInt();
        boolean encontrado = false;

    for (int i = 0; i < Guardar.length; i++) {
        if (Guardar[i] != null && Guardar[i].getid() == idbuscar) {
            System.out.println("ID Encontrado: "+Guardar[i].getid());
            System.out.println("Cantidad: " + Guardar[i].getcantidadProdu());
            System.out.println("Total: " + Guardar[i].gettotal());
            encontrado = true;
            break; 
        }
    }

    if (!encontrado) {
        System.out.println("ID no encontrado");
    }
    break;
      
  
    default:
        break;
   }  
}

while (opcion!=4);

    }
}
