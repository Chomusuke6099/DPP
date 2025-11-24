package Forma002;

public class FifoStrategy implements EstrategiaStorage {
    @Override
    public void ejecutarAlmacenamiento(InventarioModel modelo, String productoId, int cantidad) {
        modelo.incrementarStock(productoId, cantidad);
        modelo.actualizarStock(productoId, ((java.util.Map) modelo.obtenerEstadoStock()).get(productoId));
    }
}