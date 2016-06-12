package domain.casesControllers;

import domain.classes.ReservaAmbNotificacio;
import domain.dataTypes.RecursDisponiblesPerData;
import domain.exceptions.NoHiHaRecursos;
import domain.exceptions.PeriodeErrorni;
import domain.factories.FactoriaUseCase;
import domain.structures.TupleUsers;

import java.sql.Date;
import java.util.List;

public class CrearReservaAmbNotificacioUseCaseController {

    private FactoriaUseCase factoriaUseCase;
    //PROVISIONAL
    private Date dateRActual;
    private Integer hiActual;
    private Integer hfActual;

    private ReservaAmbNotificacio rN = null;

    public CrearReservaAmbNotificacioUseCaseController() {

       factoriaUseCase = FactoriaUseCase.getInstance();

       // crearReservaAmbNotificacio =

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

    /*context CapaDomini :: obtéUsuarisPerAssignar():Set(TupleType(username: String, nom:
            String, email: String))
    exc noHiHaProuUsuaris: no hi ha usuaris al sistema que puguin ser assignats.
    post result= obté el username, nom i email dels usuaris que no estiguin assignats per ser
    notificats a la reserva.*/


    public List<TupleUsers> obteUsuarisPerAssignar() throws Exception {

        List<TupleUsers> usuarisPerAssignar = factoriaUseCase
                                                .getAssignarUsuarisANotificarAUnaReserva()
                                                .obteUsuarisAAssignar(rN.getNomrecurs(),dateRActual,hiActual);

        return usuarisPerAssignar;
    }


    //TODO: Operacions de crida a la persistencia
}
