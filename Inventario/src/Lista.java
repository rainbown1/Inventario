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
    
    public void agregar(int elemento) { // Faltaba el parámetro
        Nodo nuevoNodo = new Nodo(elemento); // Asumimos que Nodo tiene constructor con parámetro
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
    }

    public boolean buscar(int elemento) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.num == elemento) {
                return true;
            }
            temp = temp.getSiguiente(); // Faltaba avanzar al siguiente nodo
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
            System.out.print(n.num + " --> "); // Cambiado a print para mejor formato
            n = n.getSiguiente(); // Faltaba avanzar al siguiente nodo
        }
        System.out.println("null"); // Para indicar el final de la lista
    }
}