public class Nodo {
    Auto auto;
    Nodo siguiente;

    public Nodo(Auto auto) {
        this.auto = auto;
        this.siguiente = null;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    public Auto getAuto(){
        return auto;
    }
    public void setAuto(Auto auto){
        this.auto = auto;
    }
}
