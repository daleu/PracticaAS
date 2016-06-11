package domain.casesControllers;


import domain.classes.Reserva;
import domain.classes.ReservaAmbNotificacio;
import domain.dataTypes.TupleUsers;
import domain.factories.FactoriaCtrl;
import domain.factories.FactoriaUseCase;

import java.util.Date;
import java.util.List;

public class AssignarUsuarisANotificarUseCaseController {


    public List<TupleUsers> obteUsuarisAAssignar(String nomR, Date data, Integer horaInici) throws Exception{

        Reserva reserva = FactoriaCtrl
                .getInstance()
                .getCtrlReserva()
                .getReserva(nomR,horaInici,data);

        //reserva.reservaValida();



        return null;
    }

    //TODO: Operacions de crida a la persistencia
}
