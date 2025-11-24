package Forma001.Controller;

import Forma001.Model.InventarioModel;
import Forma001.Strategy.EstrategiaStorage;
import Forma001.Strategy.FifoStrategy;
import Forma001.Strategy.LifoStrategy;
import Forma001.View.InventarioView;

public class InventarioController {
    private InventarioModel model;
    private InventarioView view;

    public InventarioController(InventarioModel model, InventarioView view) {
        this.model = model;
        this.view = view;
    }

    public void updateStock(String productoId, int nuevaCantidad) {
        model.actualizarStock(productoId, nuevaCantidad);
        view.displayStock();
    }

    public void reabastecerStock(String productoId, int cantidad, String strategyType) {
        EstrategiaStorage estrategia;
        if ("FIFO".equals(strategyType)) {
            estrategia = new FifoStrategy(model);
        } else {
            estrategia = new LifoStrategy(model);
        }
        model.setStrategy(estrategia);
        model.reabastecer(productoId, cantidad);
    }
}