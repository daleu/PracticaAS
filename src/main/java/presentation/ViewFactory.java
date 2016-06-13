package presentation;


public class ViewFactory {
    private static ViewFactory ourInstance = new ViewFactory();

    public static ViewFactory getInstance() {
        return ourInstance;
    }

    private ViewFactory() {
    }

    public crearReservaVista getcrearReservaVista() {
        return new crearReservaVistaSistema();
    }
}
