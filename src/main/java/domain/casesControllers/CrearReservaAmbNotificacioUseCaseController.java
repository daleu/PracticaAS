package domain.casesControllers;
import domain.classes.*;
import domain.controllers.CtrlRecurs;
import domain.controllers.CtrlReserva;
import domain.controllers.CtrlUsuari;
import domain.dataTypes.RecursDisponiblesPerData;
import domain.exceptions.NoHiHaRecursos;
import domain.exceptions.PeriodeErrorni;
import domain.exceptions.RecursSalaSolapada;
import domain.exceptions.RecursNoSala;
import domain.factories.FactoriaCtrl;
import domain.factories.FactoriaUseCase;
import domain.dataTypes.TupleUsers;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

public class CrearReservaAmbNotificacioUseCaseController {

    private FactoriaUseCase factoriaUseCase;
    private FactoriaCtrl fatoriaACtrl;

    //1a Funcio
    private Date dateRActual;
    private Integer hiActual;
    private Integer hfActual;

    //3a Funcio
    private ReservaAmbNotificacio rN = null;

    //4a Funcio
    private List<String> usuariList = null;

    public CrearReservaAmbNotificacioUseCaseController() {
       factoriaUseCase = FactoriaUseCase.getInstance();
        fatoriaACtrl = FactoriaCtrl.getInstance();
    }


    public void crearReservaAmbNotificacio(String nomR, String username, String comentari) throws Exception {

        CtrlRecurs cRec = fatoriaACtrl.getCtrlRecurs();
        CtrlUsuari cUsu = fatoriaACtrl.getCtrlUsuari();
        CtrlReserva cRes = fatoriaACtrl.getCtrlReserva();

        Usuari u = cUsu.getUsuari(username);
        Recurs r = cRec.getRecurs(nomR);

        if (!(r instanceof Sala)) {
            throw new RecursNoSala();
        }

        if(u.teSalaEnPeriode(dateRActual,hiActual,hfActual)) {
         throw new RecursSalaSolapada();
        }

        //CREA
        //Assigna data, hores, comentaris, recurs i usuari a la classe pare
        //Inicialitza llista d'usuaris a notificar
        rN = new ReservaAmbNotificacio(dateRActual,hiActual,hfActual,comentari,r,u);

        //ASSIGNA USUARIS
        factoriaUseCase
                .getAssignarUsuarisANotificarAUnaReserva().afegirUsuarisAReserva(usuariList);

        Collection<Usuari> cU = FactoriaCtrl.getInstance().getCtrlUsuari().getall();
        Collection<Usuari> usuarisAAssignar = null;
        for(Usuari usu: cU) {
            usuariList.contains(usu.getUsername());
            usuarisAAssignar.add(usu);
        }
        rN.associarUsuaris(usuarisAAssignar);
    }


    /* 2. OBTE RECURSOS DISPONIBLES */
    public List<RecursDisponiblesPerData> obteRecursosDisponibles(Date d, Integer hi, Integer hf) throws Exception {

        if(hf < hf) throw new PeriodeErrorni();

        List<RecursDisponiblesPerData> recursos = factoriaUseCase
                                                    .getConsultarRecursosDisponiblesPerData()
                                                    .obtéRecursosDisponiblesPerData(d,hi,hf);
        this.dateRActual = d;
        this.hfActual = hf;
        this.hiActual = hi;

         if (recursos == null) throw new NoHiHaRecursos();
        return recursos;
    }

    /*3. OBTE USUARIS PER ASSIGNAR */
    public List<TupleUsers> obteUsuarisPerAssignar() throws Exception {

        List<TupleUsers> usuarisPerAssignar = factoriaUseCase
                                                .getAssignarUsuarisANotificarAUnaReserva()
                                                .obteUsuarisAAssignar(rN.getNomrecurs(),dateRActual,hiActual);
        return usuarisPerAssignar;
    }

    /*4. ASSIGNAR USUARIS A RESERVA*/
    public void assignarUsuarisAReserva(List<String> usuariList) {
        this.usuariList = usuariList;
        rN.assignarUsuaris(usuariList);
    }
}
