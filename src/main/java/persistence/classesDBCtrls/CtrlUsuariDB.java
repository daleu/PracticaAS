package persistence.classesDBCtrls;


import domain.classes.Recurs;
import domain.classes.Usuari;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistence.hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CtrlUsuariDB implements domain.controllers.CtrlUsuari {


    public Collection<Usuari> getall() {

        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        List<Usuari> allusuaris = (List<Usuari>)session.createQuery("from "+ Usuari.TAULA).list();
        session.close();

        //TODO: Saber fer un getALL

        return (Collection<Usuari>) allusuaris;
    }

    public Usuari getUsuari(String username) {

        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        Usuari u = (Usuari) session.get(Usuari.class,username);
        session.close();

        if (u == null)
            throw new IllegalStateException("usuariNoExisteix");

        return u;
    }
}
