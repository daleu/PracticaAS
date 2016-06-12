package domain.classesDBCtrls;

import domain.classes.Reserva;
import domain.classes.ReservaAmbNotificacio;
import domain.classes.ReservaPK;
import domain.classes.ReservaambnotificacioPK;
import domain.controllers.CtrlReserva;
import domain.exceptions.NoEsReservaAmbNotificacio;
import domain.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.sql.Date;

/**
 * Created by crist_000 on 11/06/2016.
 */
public class CtrlReservaDB implements CtrlReserva {
    /*public Reserva getReserva(String nomRecurs, Integer horainici, Date data) throws NoEsReservaAmbNotificacio{

        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        Reserva res1 = (Reserva) session.get(Reserva.class, Reserva.class);

        Reserva res2 = (ReservaAmbNotificacio) session.get(ReservaAmbNotificacio.class, ReservaAmbNotificacio.class);
        session.close();

        if(res1 == null) throw new NoEsReservaAmbNotificacio();
        if (res1!=null) return res1;
        else return res2;
    }*/
    // David no se si a ti tu getReserva te funciona, pero a mi no, he comentado la tuya y puesto la mia =)
    // A la mia le faltaria el tratado de excepciones, la tuya tiene un error en el session.get que nunca le pasas el identificador asi que no se com hacias el get
    // Si crees que puedes adaptar la mia goes! =)
    public Reserva getReserva(String nomRecurs, Integer horaInici, Date data) {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        ReservaPK pk = new ReservaPK();
        pk.setnomrecurs(nomRecurs);
        pk.setHorainici(horaInici);
        pk.setData(data);
        Reserva reserva = (Reserva) session.get(Reserva.class, pk);
        session.close();
        return reserva;
    }

    public void insertarReserva(Reserva reserva) {

    }

    public ArrayList<Reserva> getAll() {
        return null;
    }
}
