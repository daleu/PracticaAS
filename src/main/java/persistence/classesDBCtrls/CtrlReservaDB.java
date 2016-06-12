package persistence.classesDBCtrls;

import domain.classes.Reserva;
import domain.classes.ReservaPK;
import domain.controllers.CtrlReserva;
import persistence.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Collection;
import java.util.Set;


public class CtrlReservaDB implements CtrlReserva {


    public Collection<Reserva> getAll(){

        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        Collection<Reserva> res = (Collection<Reserva>) session.createQuery("from "+ Reserva.TAULA).list();
        session.close();
        return res;

    }

    public Reserva getReserva(String nomRecurs, Integer horaInici, Date data) {

        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        Reserva u = (Reserva) session.get(Reserva.class,new ReservaPK(nomRecurs,horaInici,data));
        sf.close();

        if (u == null)
            throw new IllegalStateException("reservaNoExisteix");

        return u;
    }

}
