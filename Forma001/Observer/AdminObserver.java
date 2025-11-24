package Forma001.Observer;

import Forma001.View.InventarioView;

public class AdminObserver implements InventarioObserver {
    private InventarioView view;

    public AdminObserver(InventarioView view) {
        this.view = view;
    }

    @Override
    public void actualizar(String mensaje) {
        view.showAlert(mensaje);
    }
}