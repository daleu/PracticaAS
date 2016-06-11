package domain.classesDBCtrls;

import domain.classes.Reserva;
import domain.classes.ReservaAmbNotificacio;
import domain.classes.ReservaPK;
import domain.controllers.CtrlReserva;
import domain.exceptions.NoHiHaReserva;
import domain.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by crist_000 on 11/06/2016.
 */
public class CtrlReservaDB implements CtrlReserva {
    public Reserva getReserva(String nomRecurs, Integer horainici, Date data) throws NoHiHaReserva{

        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        Reserva res1 = (Reserva) session.get(Reserva.class, Reserva.class);

        Reserva res2 = (ReservaAmbNotificacio) session.get(ReservaAmbNotificacio.class, ReservaAmbNotificacio.class);
        session.close();

        if(res1 == null) throw new NoHiHaReserva();
        if (res1!=null) return res1;
        else return res2;
    }

    public void insertarReserva(Reserva reserva) {

    }

    public ArrayList<Reserva> getAll() {
        return null;
    }
}
