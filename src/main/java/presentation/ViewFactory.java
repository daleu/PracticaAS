package presentation;

/**
 * Created by Usuario on 11/06/2016.
 */
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
