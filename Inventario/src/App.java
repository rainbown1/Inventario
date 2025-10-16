import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);
        Lista taller = new Lista();
        int option = 0;

        do {
            System.out.println("\n=== Menú del Taller ===");
            System.out.println("1. Ingresa Nueva Reparación");
            System.out.println("2. Salida de Vehículos");
            System.out.println("3. Listado de Vehículos");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            if (!Leer.hasNextInt()) {
                System.out.println("Error: Debes ingresar un número entre 1 y 4.");
                Leer.nextLine();
                continue;
            }
            option = Leer.nextInt();
            Leer.nextLine();

            switch (option) {
                case 1:
                    System.out.println("===== FAVOR DE AGREGAR VEHÍCULO =====");
                    System.out.print("Nombre de propietario: ");
                    String Nombredueño = Leer.nextLine().trim();
                    if (Nombredueño.isEmpty()) {
                        System.out.println("Error: El nombre del propietario no puede estar vacío.");
                        break;
                    }

                    System.out.print("Marca del vehículo: ");
                    String Modelo = Leer.nextLine().trim();
                    if (Modelo.isEmpty()) {
                        System.out.println("Error: La marca no puede estar vacía.");
                        break;
                    }

                    System.out.print("Matrícula: ");
                    if (!Leer.hasNextInt()) {
                        System.out.println("Error: La matrícula debe ser un número.");
                        Leer.nextLine();
                        break;
                    }
                    int matricula = Leer.nextInt();
                    Leer.nextLine();

                    if (taller.existeMatricula(matricula)) {
                        System.out.println("Error: Ya existe un vehículo con esa matrícula.");
                        break;
                    }

                    String Estado = "En reparación";
                    Auto nuevoAuto = new Auto(Nombredueño, Modelo, matricula, Estado);
                    taller.agregar(nuevoAuto);
                    System.out.println("Vehículo registrado.\n");
                    break;

                case 2:
                    System.out.println("===== SALIDA DE VEHÍCULO =====");

                    if (taller.vacia()) {
                        System.out.println("No hay vehículos registrados actualmente.");
                        break;
                    }

                    System.out.print("Nombre del propietario: ");
                    String buscar = Leer.nextLine().trim();
                    if (buscar.isEmpty()) {
                        System.out.println("Error: El nombre no puede estar vacío.");
                        break;
                    }

                    boolean reparado = taller.buscarPorPropietarioYMatricula(buscar, Leer);
                    if (reparado) {
                        System.out.print("¿Deseas eliminar el vehículo entregado de la lista? (s/n): ");
                        String respuesta = Leer.nextLine().trim().toLowerCase();
                        if (respuesta.equals("s")) {
                            System.out.print("Ingresa nuevamente la matrícula para confirmar: ");
                            if (!Leer.hasNextInt()) {
                                System.out.println("Error: Matrícula inválida.");
                                Leer.nextLine();
                                break;
                            }
                            int matriculaConfirmada = Leer.nextInt();
                            Leer.nextLine();

                            boolean eliminado = taller.eliminarPorPropietarioYMatricula(buscar, matriculaConfirmada);
                            if (eliminado) {
                                System.out.println("Vehículo eliminado de la lista.");
                            } else {
                                System.out.println("No se encontró el vehículo para eliminar.");
                            }
                        } else {
                            System.out.println("Vehículo entregado, pero no eliminado.");
                        }
                    } else {
                        System.out.println("Vehículo no encontrado o matrícula incorrecta.");
                    }
                    break;

                case 3:
                    System.out.println("===== LISTADO DE VEHÍCULOS =====");
                    taller.mostrarLista();
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Elige entre 1 y 4.");
            }

        } while (option != 4);
    }
}
