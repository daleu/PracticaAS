package presentation;

import javax.swing.*;
import java.util.List;

/**
 * Created by Usuario on 11/06/2016.
 */
public class crearReservaVistaSistema implements crearReservaVista {
    JFrame c;
    crearReservaController ctrl;

    public void init(crearReservaController ctrl) {
        c = new menuPrincipal(ctrl);
        this.ctrl = ctrl;
    }

    public void mostraIntroduccioData(){
        c.setVisible(false);
        c = new creaReservaAmbNotificacio_1(ctrl);
    }
}