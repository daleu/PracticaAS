package domain.casesControllers;

import domain.classes.Recurs;
import domain.classes.ReservaAmbNotificacio;
import domain.classes.Sala;
import domain.classes.Usuari;
import domain.controllers.CtrlRecurs;
import domain.controllers.CtrlReserva;
import domain.controllers.CtrlUsuari;
import domain.dataTypes.RecursDisponiblesPerData;
import domain.exceptions.NoHiHaRecursos;
import domain.exceptions.PeriodeErrorni;
import domain.exceptions.recursSalaSolapada;
import domain.factories.FactoriaCtrl;
import domain.factories.FactoriaUseCase;
import domain.dataTypes.TupleUsers;

import java.sql.Date;
import java.util.List;

public class CrearReservaAmbNotificacioUseCaseController {

    private FactoriaUseCase factoriaUseCase;
    private FactoriaCtrl fatoriaACtrl;
    //PROVISIONAL
    private Date dateRActual;
    private Integer hiActual;
    private Integer hfActual;

    private ReservaAmbNotificacio rN = null;

    public CrearReservaAmbNotificacioUseCaseController() {
       factoriaUseCase = FactoriaUseCase.getInstance();
        fatoriaACtrl = FactoriaCtrl.getInstance();
    }


    //(nomR: String, username: String,
    // comentari: String[0..1])

    public void crearReservaAmbNotificacio(String nomR, String username, String comentari) throws recursSalaSolapada {

        CtrlRecurs cRec = fatoriaACtrl.getCtrlRecurs();
        CtrlUsuari cUsu = fatoriaACtrl.getCtrlUsuari();
        CtrlReserva cRes = fatoriaACtrl.getCtrlReserva();


        Usuari u = cUsu.getUsuari(username);
        Recurs r = cRec.getRecurs(nomR);

        if (r instanceof Sala) {

            if(u.teSalaEnPeriode(dateRActual,hiActual,hfActual)) {
             throw new recursSalaSolapada();
            }
        }



    }

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

    public List<TupleUsers> obteUsuarisPerAssignar() throws Exception {

        List<TupleUsers> usuarisPerAssignar = factoriaUseCase
                                                .getAssignarUsuarisANotificarAUnaReserva()
                                                .obteUsuarisAAssignar(rN.getNomrecurs(),dateRActual,hiActual);

        return usuarisPerAssignar;

    }


    //TODO: Operacions de crida a la persistencia
}
