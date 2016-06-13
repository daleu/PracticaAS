package presentation;

import domain.dataTypes.RecursDisponiblesPerData;
import domain.dataTypes.TupleUsers;
import domain.factories.FactoriaCtrl;
import domain.factories.FactoriaUseCase;

import java.sql.Date;
import java.util.List;


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
    FactoriaUseCase factoriaDomain;

    crearReservaVista vista;

    public crearReservaController(){
        vista = ViewFactory.getInstance().getcrearReservaVista();
        factoriaDomain = FactoriaUseCase.getInstance();
        vista.init(this);
    }

    public void iniciarFuncionalitat(){
        vista.mostraIntroduccioData();
    }

    public void seleccionarRecurs(Date data, Integer hi, Integer hf) throws Exception {

        List<RecursDisponiblesPerData> aux = factoriaDomain.getConsultarRecursosDisponiblesPerData().obtéRecursosDisponiblesPerData(data,hi,hf);
        vista.seleccionarRecurs(aux);
    }

    public void OkDate(Date d, int horaInici, int horaFi) throws Exception {
        FactoriaUseCase fuc = new FactoriaUseCase();
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        CrearReservaAmbNotificacioUseCaseController  cranucc = fuc.getCrearReservaAmbNotificacio();
        List<RecursDisponiblesPerData> info = cranucc.obteRecursosDisponibles(sqlDate, horaInici, horaFi);
        vista.seleccionarRecurs(info);
    }

    public void assignarUsuaris() throws Exception {
        FactoriaUseCase fuc = new FactoriaUseCase();
        CrearReservaAmbNotificacioUseCaseController aux = fuc.getCrearReservaAmbNotificacio();
        List<TupleUsers> aux2 = aux.obteUsuarisPerAssignar();
        vista.assignarUsuaris(aux2);
    }

    public void noAssignarUsuaris(){
        vista.goMenuPrincipal();
    }

    public void crearReserva(String nomrecurs, String username, String comentari) throws Exception {
        FactoriaUseCase fuc = new FactoriaUseCase();
        CrearReservaAmbNotificacioUseCaseController aux = fuc.getCrearReservaAmbNotificacio();
        aux.crearReservaAmbNotificacio(nomrecurs,username,comentari);
        vista.vistacreadaCorrectament();
    }
}
