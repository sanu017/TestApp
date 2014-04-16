package com.anubhav.testapp.dao;

import com.anubhav.testapp.object.User;
import com.anubhav.testapp.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Anubhav on 4/15/2014.
 */
public class UserDAO {

    public List getAllUsers() throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from User").list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }

    public User findByInternalId(Integer internalId) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (User) session.get(User.class, internalId);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }
}
