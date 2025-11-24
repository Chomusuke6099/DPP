package Forma002;

public class AdminObserver implements InventarioObserver {
    private final InventarioVista vista;

    public AdminObserver(InventarioVista vista) {
        this.vista = vista;
    }

    @Override
    public void actualizar(String mensaje) {
        vista.mostrarAlerta(mensaje);
    }
}