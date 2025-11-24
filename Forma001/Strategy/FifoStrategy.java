package Forma001.Strategy;

import Forma001.Model.InventarioModel;

public class FifoStrategy implements EstrategiaStorage {
    private InventarioModel model;

    public FifoStrategy(InventarioModel model) {
        this.model = model;
    }

    @Override
    public void executeStorage(String productoId, int cantidad) {
        // Lógica FIFO: agregar al final de la cola de stock
        int stockActual = model.getStock(productoId);
        model.actualizarStock(productoId, stockActual + cantidad);
        System.out.println("Reabastecimiento FIFO aplicado para " + productoId);
    }
}