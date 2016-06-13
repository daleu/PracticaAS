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
import java.util.ArrayList;
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


    public CrearReservaAmbNotificacioUseCaseController() {
       factoriaUseCase = FactoriaUseCase.getInstance();
        fatoriaACtrl = FactoriaCtrl.getInstance();
    }


    public void crearReservaAmbNotificacio(String nomR, String username, String comentari) throws Exception {

        CtrlRecurs cRec = fatoriaACtrl.getCtrlRecurs();
        CtrlUsuari cUsu = fatoriaACtrl.getCtrlUsuari();

        Usuari u = cUsu.getUsuari(username);
        Recurs r = cRec.getRecurs(nomR);

        if (!(r instanceof Sala)) {
            throw new RecursNoSala();
        }

        if(u.teSalaEnPeriode(dateRActual,hiActual,hfActual)) {
         throw new RecursSalaSolapada();
        }

        //CREACIO
        //Assigna data, hores, comentaris, recurs i usuari a la classe pare
        //Inicialitza llista d'usuaris a notificar
        rN = new ReservaAmbNotificacio(dateRActual,hiActual,hfActual,comentari,r.getNom(),u.getUsername());

        //Associacions de classes i per a bd
        rN.associarUsuari(u);

        //Guardar a persistencia
        persistence.hibernate.HibernateUtils.save(rN);

    }


    /* 2. OBTE RECURSOS DISPONIBLES */
    public List<RecursDisponiblesPerData> obteRecursosDisponibles(Date d, Integer hi, Integer hf) throws Exception {

        List<RecursDisponiblesPerData> recursos = factoriaUseCase
                                                    .getConsultarRecursosDisponiblesPerData()
                                                    .obtéRecursosDisponiblesPerData(d,hi,hf);
        this.dateRActual = d;
        this.hfActual = hf;
        this.hiActual = hi;

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
    public void assignarUsuarisAReserva(List<String> usuariList) throws Exception {

        factoriaUseCase.getAssignarUsuarisANotificarAUnaReserva().afegirUsuarisAReserva(usuariList);

    }
}
