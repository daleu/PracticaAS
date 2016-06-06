
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//Classe amb funcions utils per a l'ús de l'eina Hibernate
public class HibernateUtils {

    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("res/hibernate.cfg.xml");
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory  = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Object save(Object o) {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.save(o);

        session.getTransaction().commit();

        session.close();

        return o;
    }

    public static Object update(Object o) {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.merge(o);

        session.getTransaction().commit();

        session.close();
        return o;

    }

    public static void delete(Object o) {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(o);

        session.getTransaction().commit();

        session.close();

    }

    public static int emptyTable(String myTable){
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        String hql = String.format("delete from %s",myTable);
        Query query = session.createQuery(hql);
        int res =  query.executeUpdate();
        session.getTransaction().commit();

        session.close();

        return res;

    }
}
