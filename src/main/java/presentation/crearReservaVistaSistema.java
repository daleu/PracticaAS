package presentation;

import domain.dataTypes.RecursDisponiblesPerData;
import domain.dataTypes.TupleUsers;

import javax.swing.*;
import java.util.List;


public class crearReservaVistaSistema implements crearReservaVista {
    JFrame c;
    crearReservaController ctrl;

    public void init(crearReservaController ctrl) {
        c = new menuPrincipal(ctrl);
        this.ctrl = ctrl;
    }

    public void mostraIntroduccioData(){
        c.setVisible(false);
        c = new cResAmbNot_selec_data(ctrl);
    }

    public void seleccionarRecurs(List<RecursDisponiblesPerData> aux){
        c.setVisible(false);
        c = new seleccionarRecurs(ctrl,aux);
    }

    public void assignacioCorrecte(crearReservaController crearReservaController) {
        c.setVisible(false);
        c = new assignacioCorrecte(ctrl);
    }


    public void assignarUsuaris(List<TupleUsers> aux2){
        c.setVisible(false);
        c = new LlistarUsuarisANotificar(aux2);
    }

    public void goMenuPrincipal(){
        c.setVisible(false);
        c = new menuPrincipal(ctrl);
    }

    public void vistacreadaCorrectament(){
        c.setVisible(false);
        c = new recursNotificacioCreat_Continuar(ctrl);
    }

}
