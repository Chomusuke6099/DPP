package Forma001.Strategy;

import Forma001.Model.InventarioModel;

public class LifoStrategy implements EstrategiaStorage {
    private InventarioModel model;

    public LifoStrategy(InventarioModel model) {
        this.model = model;
    }

    @Override
    public void executeStorage(String productoId, int cantidad) {
        // Lógica LIFO: agregar al inicio de la pila de stock
        int stockActual = model.getStock(productoId);
        model.actualizarStock(productoId, stockActual + cantidad);
        System.out.println("Reabastecimiento LIFO aplicado para " + productoId);
    }
}