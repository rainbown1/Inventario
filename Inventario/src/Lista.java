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
                autoActual.setEstado("Reparado");
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("No hay elementos en la lista");
            return; // Faltaba el return para salir del método
        }
        Nodo n = cabeza;
        while (n != null) {
            System.out.print(n.auto + " --> ");
            n = n.getSiguiente(); // avanzar al siguiente nodo
        }
        System.out.println("null"); // Para indicar el final de la lista
    }
}
