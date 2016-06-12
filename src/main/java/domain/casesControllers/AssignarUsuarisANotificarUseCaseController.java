package domain.casesControllers;


import domain.classes.Reserva;
import domain.structures.TupleUsers;
import domain.classes.ReservaAmbNotificacio;
import domain.classes.Usuari;
import domain.dataTypes.TupleUsers;
import domain.factories.FactoriaCtrl;
import domain.factories.FactoriaUseCase;

import java.sql.Date;
import java.util.List;

public class AssignarUsuarisANotificarUseCaseController {

    private Reserva reserva;

    public List<TupleUsers> obteUsuarisAAssignar(String nomR, Date data, Integer horaInici) throws Exception{

        reserva = FactoriaCtrl
                .getInstance()
                .getCtrlReserva()
                .getReserva(nomR,horaInici,data);

        reserva.reservaValida();

        return null;
    }


    public void afegirUsuarisAReserva(List<String> usernameList) throws Exception{

       reserva.afegirUsuaris(usernameList);

    }

    //TODO: Operacions de crida a la persistencia
}
