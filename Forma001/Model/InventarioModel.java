package Forma001.Model;

import java.util.*;

import Forma001.Observer.InventarioObserver;
import Forma001.Strategy.EstrategiaStorage;


public class InventarioModel {
    private final List<Producto> productos = new ArrayList<>();
    private final Map<String, Integer> stockLevels = new HashMap<>();
    private final List<InventarioObserver> observadores = new ArrayList<>();
    private EstrategiaStorage estrategia;

    public void registrarObservador(InventarioObserver observador) {
        observadores.add(observador);
    }

    public void setStrategy(EstrategiaStorage estrategia) {
        this.estrategia = estrategia;
    }

    public void actualizarStock(String productoId, int cantidad) {
        stockLevels.put(productoId, cantidad);
        if (cantidad <= 5) {
            notificarBajoStock(productoId);
        }
    }

    private void notificarBajoStock(String productoId) {
        String mensaje = "Hay poco stock de " + productoId;
        observadores.forEach(obs -> obs.actualizar(mensaje));
    }

    public void reabastecer(String productoId, int cantidad) {
        if (estrategia != null) {
            estrategia.executeStorage(productoId, cantidad);
        }
    }

    public int getStock(String productoId) {
        return stockLevels.getOrDefault(productoId, 0);
    }

    // Método para agregar productos (simplificado)
    public void addProducto(Producto producto) {
        productos.add(producto);
        stockLevels.put(producto.getId(), producto.getStockInicial());
    }
}