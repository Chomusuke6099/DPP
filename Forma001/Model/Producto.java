package Forma001.Model;

public class Producto {
    private String id;
    private String nombre;
    private int stockInicial;

    public Producto(String id, String nombre, int stockInicial) {
        this.id = id;
        this.nombre = nombre;
        this.stockInicial = stockInicial;
    }

    public String getId() {
        return id;
    }

    public int getStockInicial() {
        return stockInicial;
    }
}