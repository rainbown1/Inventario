public class Lista {

    private Nodo cabeza;

    public Lista(Nodo cabeza){
        this.cabeza = cabeza;
    }

    public boolean vacia(){
        if(cabeza == null){
            return true;
        }
        return false;
    }
    public void agregar(){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
    }
}
