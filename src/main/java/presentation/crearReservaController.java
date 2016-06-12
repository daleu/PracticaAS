package presentation;

/**
 * Created by Usuario on 11/06/2016.
 */
public class crearReservaController {
    menuPrincipal mp;
    cResAmbNot_selec_data creaAmbNot1;

    crearReservaVista vista;

    public crearReservaController(){
        vista = ViewFactory.getInstance().getcrearReservaVista();
        vista.init(this);
    }

    public void iniciarFuncionalitat(){
        vista.mostraIntroduccioData();
    }
}
