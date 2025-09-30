package Clases;

public class Producto {

    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public Producto(){}

    public void getInventario(Producto[] products){
        for (int i = 1; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - i; j++) {
                if (products[j].getPrecio() > products[j + 1].getPrecio()) {
                    Producto max = products[j];
                    products[j] = products[j+1];
                    products[j+1] = max;
                }
            }
        }
    }

    public boolean buscarProducto(Producto[] producto, String nombre){
        boolean encontrado = false;
        for (int i = 0; i < producto.length; i++) {
           if (producto[i].getName().equalsIgnoreCase(nombre)) {
                System.out.println("Producto encontrado");
                encontrado = true;
                System.out.println(producto[i]);
                break;
           }
           
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado");
           }
        return encontrado;
    }
    
    public String getName(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + "  Precio: $" + precio + "  Stock: " + stock;
    }

}
