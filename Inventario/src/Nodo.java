public class Nodo {
    int num;
    Nodo siguiente;

    public Nodo(int num) {
        this.num = num;
        this.siguiente = null;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
