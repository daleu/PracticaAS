package domain.casesControllers;


import domain.classes.Reserva;
import domain.classes.ReservaAmbNotificacio;
import domain.classes.Usuari;
import domain.dataTypes.TuplaEnviarDadesAReserva;
import domain.factories.FactoriaCtrl;
import domain.structures.TupleUsers;

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

        return null;
    }


    public void afegirUsuarisAReserva(List<String> usernameList) throws Exception{

        Collection<Usuari> allUsuaris = FactoriaCtrl.getInstance()
                                        .getCtrlUsuari().getall();

        Collection<Usuari> UsuarisANotificar = null;
        List<String> emails = new ArrayList<String>();

        for(Usuari u: allUsuaris) {
            for (String username: usernameList) {
                if ( u.getUsername() == username) {
                    UsuarisANotificar.add(u);
                    emails.add(u.getEmail());
                    usernameList.remove(username);
                    break;
                }
            }
        }

        ReservaAmbNotificacio reservaAmbNotificacio = (ReservaAmbNotificacio) reserva;
        reservaAmbNotificacio.afegirUsuaris(UsuarisANotificar);

        String usuariQueHaFetReserva = reserva.getUsername();
        //String nomR, String data, String horaIni,
       // Integer horaFi, String username, String comentari, List<String> emailList) {
        TuplaEnviarDadesAReserva tuplaEnviaDadesAReserva = new TuplaEnviarDadesAReserva(reserva.getNomrecurs(),
                                                                reserva.getData(),
                                                                reserva.getHorainici(),
                                                                reserva.getHorafi(),
                                                                reserva.getUsername(),
                                                                reserva.getComentaris(),
                                                                emails);

    }
}
