package persistence.classesDBCtrls;

import domain.classes.Recurs;
import domain.classes.Reserva;
import domain.classes.Usuari;
import domain.controllers.CtrlRecurs;
import persistence.hibernate.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Collection;
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


    public Collection<Recurs> getAll() {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        Collection<Recurs> res = (Collection<Recurs>) session.createQuery("from "+ Recurs.TAULA).list();
        session.close();
        return res;

    }

}
