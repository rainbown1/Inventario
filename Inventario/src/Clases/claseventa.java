package Clases;

public class claseventa {
    private int id;
    private int cantidadProdu;
    private int total;

    public claseventa(){
        id= 0;
        cantidadProdu= 0;
        total= 0;
    }
    
    public int getid(){
        return id;
    }
     public void setid(int id){
       this.id= id;
    }
    public int getcantidadProdu(){
            return cantidadProdu;
    }
    public void setcantidadProdu(int cantidadProdu){
        this.cantidadProdu= cantidadProdu;
    }
    public int gettotal(){
        return total;
    }
      public void settotal( int total){
        this.total= total;
    }
}
