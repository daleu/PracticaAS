package domain.casesControllers;

import domain.adaptadors.IAdaptadorMissatgeria;
import domain.classes.Reserva;
import domain.classes.ReservaAmbNotificacio;
import domain.classes.Usuari;
import domain.dataTypes.TuplaEnviarDadesAReserva;
import domain.exceptions.NoHiHaProusUsuaris;
import domain.factories.FactoriaAdaptadors;
import domain.factories.FactoriaCtrl;
import domain.dataTypes.TupleUsers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AssignarUsuarisANotificarUseCaseController {

    private Reserva reserva;

    public List<TupleUsers> obteUsuarisAAssignar(String nomR, Date data, Integer horaInici) throws Exception{
        reserva = FactoriaCtrl
                .getInstance()
                .getCtrlReserva()
                .getReserva(nomR,horaInici,data);

        reserva.reservaValida();
        Collection<Usuari> usuaris = FactoriaCtrl
                .getInstance()
                .getCtrlUsuari()
                .getall();

        List<TupleUsers> llistaUsuarisAAssignar = reserva.usuarisAAssignar(usuaris);
        if (llistaUsuarisAAssignar==null) throw new NoHiHaProusUsuaris();

        return llistaUsuarisAAssignar;
    }

    public void afegirUsuarisAReserva(List<String> usernameList) throws Exception{

        Collection<Usuari> usuaris = FactoriaCtrl.getInstance()
                                        .getCtrlUsuari().getall();


        List<String> emails = new ArrayList<String>();

        for(Usuari u: usuaris) {
            if (!usernameList.contains(u.getUsername())) {
               usuaris.remove(u);
            }
        }

        //Afegir Usuaris
        ReservaAmbNotificacio reservaAmbNotificacio = (ReservaAmbNotificacio) reserva;

        TuplaEnviarDadesAReserva tuplaEnviarDadesAReserva = reservaAmbNotificacio.afegirUsuaris(usuaris);


        //Enviar dades
        tuplaEnviarDadesAReserva.setEmails(emails);
        IAdaptadorMissatgeria iAdapatorMissatgeria = FactoriaAdaptadors.getInstance()
                                                                        .getAdaptadorMissatgeria();

        iAdapatorMissatgeria.enviarDadesReserva(tuplaEnviarDadesAReserva);
    }

}