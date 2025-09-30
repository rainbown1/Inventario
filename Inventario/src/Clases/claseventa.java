package Clases;

public class claseventa {
    private int id;
    private String nombreProducto;
    private double precioUnitario;
    private int cantidadProdu;
    private int total;

    public claseventa(){
        id = 0;
        nombreProducto = "";
        precioUnitario = 0.0;
        cantidadProdu = 0;
        total = 0;
    }
    
    public int getid(){
        return id;
    }
    public void setid(int id){
       this.id = id;
    }
  
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    

    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getcantidadProdu(){
        return cantidadProdu;
    }
    public void setcantidadProdu(int cantidadProdu){
        this.cantidadProdu = cantidadProdu;
    }
    public int gettotal(){
        return total;
    }
    public void settotal( int total){
        this.total = total;
    }
}