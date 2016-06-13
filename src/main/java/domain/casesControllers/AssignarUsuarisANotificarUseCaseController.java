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

    private String nomR;
    private Date data;
    private Integer horaInici;

    public List<TupleUsers> obteUsuarisAAssignar(String nomR, Date data, Integer horaInici) throws Exception{

        Reserva reserva = FactoriaCtrl
                .getInstance()
                .getCtrlReserva()
                .getReserva(nomR,horaInici,data);

        reserva.reservaValida();
        Collection<Usuari> usuaris = FactoriaCtrl
                .getInstance()
                .getCtrlUsuari()
                .getall();

        ReservaAmbNotificacio r = (ReservaAmbNotificacio) reserva;

        if( r.reservaValida()) {

            //TODO: Mira si reserva valida

            List<TupleUsers> llistaUsuarisAAssignar = r.usuarisAAssignar(usuaris);

            if (llistaUsuarisAAssignar == null) throw new NoHiHaProusUsuaris();

            return llistaUsuarisAAssignar;
        }

        return null;

    }

    public void afegirUsuarisAReserva(List<String> usernameList) throws Exception{


        ReservaAmbNotificacio reserva = (ReservaAmbNotificacio) FactoriaCtrl
                .getInstance()
                .getCtrlReserva()
                .getReserva(nomR,horaInici,data);

        Collection<Usuari> usuaris = FactoriaCtrl.getInstance()
                                        .getCtrlUsuari().getall();


        List<String> emails = new ArrayList<String>();
        ArrayList<Usuari> user = new ArrayList<Usuari>();

        for(Usuari u: usuaris) {
            if(usernameList.contains(u.getUsername())) {
                user.add(u);
                emails.add(u.getEmail());
            }
        }

        TuplaEnviarDadesAReserva tuplaEnviarDadesAReserva = reserva.afegirUsuaris(user);

        //Enviar dades
        tuplaEnviarDadesAReserva.setEmails(emails);
        IAdaptadorMissatgeria iAdapatorMissatgeria = FactoriaAdaptadors.getInstance()
                                                                        .getAdaptadorMissatgeria();

        iAdapatorMissatgeria.enviarDadesReserva(tuplaEnviarDadesAReserva);
    }

}