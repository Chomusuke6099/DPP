package Forma002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void actualizarStock(String productoId, Object cantidad) {
        int cantidadInt = (Integer) cantidad;
        stockLevels.put(productoId, cantidadInt);
        if (cantidadInt <= 5) {
            notificarBajoStock(productoId);
        }
    }

    private void notificarBajoStock(String productoId) {
        String mensaje = "Hay poco stock de " + productoId;
        observadores.forEach(obs -> obs.actualizar(mensaje));
    }

    public void agregarProducto(Producto producto, int cantidad) {
        // Agrega el producto a la lista de productos si no existe
        if (!productos.contains(producto)) {
            productos.add(producto);
        }

        // Usa el identificador del producto (String) como clave del stock
        String productoId = producto.getId();
        stockLevels.merge(productoId, cantidad, Integer::sum);

        // Notificar si el stock resultante es bajo
        int cantidadActual = stockLevels.get(productoId);
        if (cantidadActual <= 5) {
            notificarBajoStock(productoId);
        }
    }

    public void incrementarStock(String productoId, int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incrementarStock'");
    }

    public Object obtenerEstadoStock() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEstadoStock'");
    }
}