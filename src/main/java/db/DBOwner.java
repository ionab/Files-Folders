package db;

import models.Folder;
import models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

    public static List<Folder> getFoldersOfOwner(Owner owner){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Folder> folders = null;
        try {
            Criteria cr = session.createCriteria(Folder.class);
            cr.add(Restrictions.eq("owner", owner));
            folders = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        } return folders;
    }
}
