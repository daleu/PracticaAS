package persistence.classesDBCtrls;

import domain.classes.Recurs;
import domain.controllers.CtrlRecurs;
import persistence.hibernate.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;


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
