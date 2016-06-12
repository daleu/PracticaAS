package persistence.classesDBCtrls;

import domain.classes.Recurs;
import domain.classes.Usuari;
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

        Recurs r = (Recurs) session.get(Recurs.class,nomRecurs);
        sf.close();

        if (r == null)
            throw new IllegalStateException("recursNoExisteix");
        return r;
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
