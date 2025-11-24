package Forma002;

import java.util.List;
import java.util.Map;

public class InventarioVista {
     public void refrescarVista(Map<String, Integer> stockActual) {
        System.out.println("Inventario actual");
        stockActual.forEach((id, cantidad) ->
                System.out.println("Producto ID: " + id + " | Cantidad: " + cantidad));
        System.out.println("--");
    }

    public void mostrarAlerta(String mensaje) {
        System.out.println("ALERTA: " + mensaje);
    }

    public void mostrarAlertas(List<String> alertas) {
        if (alertas.isEmpty()) {
            System.out.println("No hay alertas en este momento.");
            return;
        }
        alertas.forEach(alerta -> System.out.println("alerta: " + alerta));
    }
}