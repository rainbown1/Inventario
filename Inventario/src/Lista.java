import java.util.Scanner;

public class Lista {

    private Nodo cabeza;

    public Lista(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    // Constructor adicional para lista vacía
    public Lista() {
        this.cabeza = null;
    }

    public boolean vacia() {
        if (cabeza == null) {
            return true;
        }
        return false;
    }

    public void agregar(Auto elemento) { // Faltaba el parámetro
        Nodo nuevoNodo = new Nodo(elemento); // Asumimos que Nodo tiene constructor con parámetro
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
    }

    //MEtodos de clase auto getPropietario y setEstado
    public boolean buscarPorMatricula(String propietario) {
        Nodo temp = cabeza;
        while (temp != null) {
            Auto autoActual = temp.getAuto();
            if (autoActual.getPropietario().equals(propietario)) {
                // Cambiar estado a "Reparado"
                autoActual.setEstado("Reparado y entregado");
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("No hay elementos en la lista");
            return;
        }
        Nodo n = cabeza;
        while (n != null) {
            System.out.println(n.getAuto().toString());
            n = n.getSiguiente();
        }
    }

    public boolean existePropietario(String propietario) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.getAuto().getPropietario().equalsIgnoreCase(propietario)) {
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    // Método en caso de que existan varios autos con el mismo nombre de propietario
    public boolean buscarPorPropietarioYMatricula(String propietario, Scanner Leer) {
        Nodo temp = cabeza;
        int coincidencias = 0;

        while (temp != null) {
            if (temp.getAuto().getPropietario().equalsIgnoreCase(propietario)) {
                coincidencias++;
            }
            temp = temp.getSiguiente();
        }

        if (coincidencias == 0) {
            return false;
        }

        if (coincidencias == 1) {
            temp = cabeza;
            while (temp != null) {
                if (temp.getAuto().getPropietario().equalsIgnoreCase(propietario)) {
                    temp.getAuto().setEstado("Reparado y entregado");
                    return true;
                }
                temp = temp.getSiguiente();
            }
        } else {
            System.out.print("Hay varios vehículos con ese propietario. Ingresa la matrícula: ");
            if (!Leer.hasNextInt()) {
                System.out.println("Error: Matrícula inválida.");
                Leer.nextLine(); // limpiar entrada inválida
                return false;
            }
            int matricula = Leer.nextInt();
            Leer.nextLine(); // limpiar buffer

            temp = cabeza;
            while (temp != null) {
                Auto auto = temp.getAuto();
                if (auto.getPropietario().equalsIgnoreCase(propietario) &&
                    auto.getMatricula() == matricula) {
                    auto.setEstado("Reparado y entregado");
                    return true;
                }
                temp = temp.getSiguiente();
            }
        }

        return false;
    }

    // Método para eliminar o conservar los autos que salen
    public boolean eliminarPorPropietarioYMatricula(String propietario, int matricula) {
        if (cabeza == null) return false;

        if (cabeza.getAuto().getPropietario().equalsIgnoreCase(propietario) &&
            cabeza.getAuto().getMatricula() == matricula) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            Auto auto = actual.getSiguiente().getAuto();
            if (auto.getPropietario().equalsIgnoreCase(propietario) &&
                auto.getMatricula() == matricula) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    //Método para las matrículas duplicadas
    public boolean existeMatricula(int matricula) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.getAuto().getMatricula() == matricula) {
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }
}
