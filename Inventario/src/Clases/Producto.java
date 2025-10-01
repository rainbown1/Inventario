package Clases;

public class Producto {

    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(String nombre, double precio, String categoria, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public Producto() {}
    
    public void reducirStock(int cantidadVendida) {
        this.stock -= cantidadVendida;
    }
    public void aumentarStock(int cantidadRecibida) {
        this.stock += cantidadRecibida;
    }
    public Producto obtenerProducto(Producto[] productos, String nombre) {
        for (Producto prod : productos) {
            if (prod != null && prod.getName().equalsIgnoreCase(nombre)) {
                return prod;
            }
        }
        return null;
    }
    public void getInventario(Producto[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - i - 1; j++) {
                if (products[j] != null && products[j + 1] != null) {
                    if (products[j].getPrecio() > products[j + 1].getPrecio()) {
                        Producto temp = products[j];
                        products[j] = products[j + 1];
                        products[j + 1] = temp;
                    }
                }
            }
        }
    }
    public boolean buscarProducto(Producto[] producto, String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < producto.length; i++) {
            if (producto[i] != null && producto[i].getName().equalsIgnoreCase(nombre)) {
                System.out.println("Producto encontrado:");
                System.out.println(producto[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado");
        }
        return encontrado;
    }

    public String getName() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getCategoria() { return categoria; } 

    @Override
    public String toString() {
        return String.format("Nombre: %s  Precio: $%.2f  Stock: %d  Categoria: %s", nombre, precio, stock, categoria);
    }
}