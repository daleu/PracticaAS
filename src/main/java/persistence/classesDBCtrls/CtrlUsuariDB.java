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
        Criteria crit = session.createCriteria(Usuari.class);

        List allUsuaris = crit.list();

        return (Collection<Usuari>) allUsuaris;
    }
}
