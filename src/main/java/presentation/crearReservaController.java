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


public class crearReservaController {
    private menuPrincipal mp;
    private cResAmbNot_selec_data creaAmbNot1;
    private FactoriaUseCase factoriaDomain;
    private crearReservaVista vista;
    private CrearReservaAmbNotificacioUseCaseController cranucc;


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
        cranucc = fuc.getCrearReservaAmbNotificacio();
        List<RecursDisponiblesPerData> info = cranucc.obteRecursosDisponibles(sqlDate, horaInici, horaFi);
        System.out.println(info.size());
        vista.seleccionarRecurs(info);

    }

    public void goinici() {
        vista = ViewFactory.getInstance().getcrearReservaVista();
        vista.init(this);
    }

    public List<TupleUsers> getUsuarisANotifcar() throws Exception {

        return factoriaDomain.getCrearReservaAmbNotificacio().obteUsuarisPerAssignar();
    }

    public void assignarUsuaris(List<String> usernames) throws Exception {
        cranucc.assignarUsuarisAReserva(usernames);

        vista.assignacioCorrecte(this);
    }

    public void assignarUsuaris() throws Exception {
//        FactoriaUseCase fuc = new FactoriaUseCase();
//        CrearReservaAmbNotificacioUseCaseController aux = fuc.getCrearReservaAmbNotificacio();
        List<TupleUsers> aux2 = cranucc.obteUsuarisPerAssignar();
        vista.assignarUsuaris(aux2);
    }

    public void noAssignarUsuaris(){
        vista.goMenuPrincipal();
    }

    public void crearReserva(String nomrecurs, String username, String comentari) throws Exception {
//        FactoriaUseCase fuc = new FactoriaUseCase();
//        CrearReservaAmbNotificacioUseCaseController aux = fuc.getCrearReservaAmbNotificacio();
        cranucc.crearReservaAmbNotificacio(nomrecurs,username,comentari);
        vista.vistacreadaCorrectament();
    }

    public void introNomUsuari(String nom){
        vista.vistaNomUsuari(nom);
    }
}
