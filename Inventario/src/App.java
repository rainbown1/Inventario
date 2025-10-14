import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int option=0;
         String Nombredueño;
        String Modelo;
        int matricula;
        String Estado;

        Scanner Leer= new Scanner(System.in);
    do {
        System.out.println("1-Ingresa Nueva Reparacion");
        System.out.println("2-Salida de reparacion ");
        System.out.println("3-Listado de vehiculos ");
        System.out.println("4- Salir");
        
        switch (option) {
            case 1:
           
                System.out.println("===== FAVOR DE AGREGAR VEHICULO =====");
                System.out.println("Nombre de propietario:");
                Nombredueño= Leer.nextLine();
                System.out.println("Modelo de vehiculo: ");
                Modelo = Leer.nextLine();
                System.out.println("Ingresa matricula: ");
                matricula = Leer.nextInt();
                System.out.println("Ingresa estado de vehiculo");
                Estado=Leer.nextLine();
                
                break;
                   
                case 2:
                    System.out.println("===== SALIDA DE VEHICULO =====");
                    System.out.println("Vehiculo a buscar: ");
                    // se cambia el estatus a Reparado y se entrega al propietario, saliendo del taller
                break;

                case 4:
                System.out.println("===== LISTADO DE VEHICULOS ====="); 
                break;
            default:
                break;
        }
        
    } while (option!=4);

    }
}
