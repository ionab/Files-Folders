package db;

import models.Owner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBOwner {


    private static Session session;
    private static Transaction transaction;

    public static void update(Owner owner){
        session = HibernateUtil.getSessionFactory().openSession();
        try{ transaction = session.beginTransaction();
            session.update(owner);
            transaction.commit();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Owner owner){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.delete(owner);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
