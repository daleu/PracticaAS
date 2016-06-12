package domain.classesDBCtrls;

import domain.classes.Recurs;
import domain.classes.Reserva;
import domain.classes.ReservaPK;
import domain.controllers.CtrlRecurs;
import domain.hibernate.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist_000 on 11/06/2016.
 */
public class CtrlRecursDB implements CtrlRecurs {
    public Recurs getRecurs(String nomRecurs) {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        return null;
    }

    public void insertarRecurs(Recurs reserva) {

    }

    public ArrayList<Recurs> getAll() {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        Criteria crit = session.createCriteria(Recurs.class);

        List recurs = crit.list();

        return (ArrayList<Recurs>) recurs;
    }

}
