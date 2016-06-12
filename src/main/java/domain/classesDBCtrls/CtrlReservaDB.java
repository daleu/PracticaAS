package domain.classesDBCtrls;

import domain.classes.Reserva;
import domain.classes.ReservaPK;
import domain.controllers.CtrlReserva;
import domain.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.sql.Date;

/**
 * Created by crist_000 on 11/06/2016.
 */
public class CtrlReservaDB implements CtrlReserva {
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
