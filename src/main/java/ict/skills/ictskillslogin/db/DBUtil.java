package ict.skills.ictskillslogin.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBUtil {
    private static Session session = null;
    private static SessionFactory sf;

    private static Session getSession() {
        if (session != null) return session;

        Configuration conf = new Configuration();

        conf.configure("hibernate.cfg.xml");

        sf = conf.buildSessionFactory();
        session = sf.openSession();

        return session;
    }

    public static void load() {
        getSession();
    }

    public static Object doWithTransaction(TransactionExecuter a) {
        Object x = null;
        if (session == null) getSession();
        if (!session.isOpen()) session = sf.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            x = a.execute(session);

            tx.commit();

            return x;
        }
        catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }
}
