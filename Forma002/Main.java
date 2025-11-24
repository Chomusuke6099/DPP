package Forma002;

public class Main {

    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioVista vista = new InventarioVista();
        InventarioController controlador = new InventarioController(modelo, vista);

        AdminObserver admin = new AdminObserver(vista);
        controlador.registrarAdminObserver(admin);

        Producto arroz = new Producto("P-001", "Arroz 1kg", 3.50);
        Producto aceite = new Producto("P-002", "Aceite 1L", 7.80);

        controlador.agregarProducto(arroz, 4);
        controlador.agregarProducto(aceite, 12);

        controlador.actualizarStock("P-001", 3);
        controlador.actualizarStock("P-002", 6);

        controlador.reabastecer("P-001", 10, new FifoStrategy());
        controlador.reabastecer("P-002", 5, new LifoStrategy());
    }
}