package domain.casesControllers;


import domain.classes.Reserva;
import domain.dataTypes.TupleUsers;
import domain.factories.FactoriaCtrl;
import domain.factories.FactoriaUseCase;

import java.util.Date;
import java.util.List;

public class AssignarUsuarisANotificarUseCaseController {


    public List<TupleUsers> obteUsuarisAAssignar(String nomR, Date data, Integer horaInici) throws Exception{

        Reserva reserva = FactoriaCtrl
                .getInstance()
                .getCtrlReserva().getReserva(nomR,horaInici,data);

        if(reserva!= null){
            throw new Exception("noReservaAmbNotificació: la reserva no és del tipus amb notificació");
        }



        return null;
    }

    //TODO: Operacions de crida a la persistencia
}
