package Forma001;
import Forma001.Controller.InventarioController;
import Forma001.Model.InventarioModel;
import Forma001.Model.Producto;
import Forma001.Observer.AdminObserver;
import Forma001.Observer.InventarioObserver;
import Forma001.View.InventarioView;

public class Main {
    public static void main(String[] args) {
        InventarioModel model = new InventarioModel();
        InventarioView view = new InventarioView();
        InventarioController controller = new InventarioController(model, view);

        // Registrar observador
        InventarioObserver admin = new AdminObserver(view);
        model.registrarObservador(admin);

        // Agregar producto
        Producto prod = new Producto("P001", "Producto Ejemplo", 10);
        model.addProducto(prod);

        // Actualizar stock y probar notificación
        controller.updateStock("P001", 3);  // Debería notificar bajo stock

        // Reabastecer con Strategy
        controller.reabastecerStock("P001", 20, "FIFO");
    }
}