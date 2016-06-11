package presentation;

import presentation.creaReservaAmbNotificacio_1;
import presentation.menuPrincipal;

/**
 * Created by Usuario on 11/06/2016.
 */
public class crearReservaController {
    menuPrincipal mp;
    creaReservaAmbNotificacio_1 creaAmbNot1;

    crearReservaVista vista;

    public crearReservaController(){
        vista = ViewFactory.getInstance().getcrearReservaVista();
        vista.init(this);
    }

    public void iniciarFuncionalitat(){
        vista.mostraIntroduccioData();
    }
}
