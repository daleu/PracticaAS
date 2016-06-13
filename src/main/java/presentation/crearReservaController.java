package presentation;

import java.util.Date;
import java.util.List;


import domain.casesControllers.CrearReservaAmbNotificacioUseCaseController;
import domain.dataTypes.RecursDisponiblesPerData;
import domain.factories.FactoriaUseCase;
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

    public void OkDate(Date d, int horaInici, int horaFi){
        FactoriaUseCase fuc = new FactoriaUseCase();
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        CrearReservaAmbNotificacioUseCaseController  cranucc = fuc.getCrearReservaAmbNotificacio();
        try {
            List<RecursDisponiblesPerData> info = cranucc.obteRecursosDisponibles(sqlDate, horaInici, horaFi);
        } catch (Exception e){
            vista = ViewFactory.getinstance().
    }
}
