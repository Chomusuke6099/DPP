package Forma002;

public class Producto {
    private final String id;
    private final String nombre;
    private final double precioUnitario;

    public Producto(String id, String nombre, double precioUnitario) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}