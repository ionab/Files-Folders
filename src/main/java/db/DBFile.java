package db;

import models.File;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBFile {

    private static Session session;
    private static Transaction transaction;

    public static void update(File file){
        session = HibernateUtil.getSessionFactory().openSession();
        try{ transaction = session.beginTransaction();
            session.update(file);
            transaction.commit();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(File file){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.delete(file);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
