package db;

import models.Folder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBFolder {

    private static Session session;
    private static Transaction transaction;

    public static void update(Folder folder){
        session = HibernateUtil.getSessionFactory().openSession();
        try{ transaction = session.beginTransaction();
            session.update(folder);
            transaction.commit();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
