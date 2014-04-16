package com.anubhav.testapp.dao;

import com.anubhav.testapp.object.User;
import com.anubhav.testapp.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Anubhav on 4/15/2014.
 */
public class UserDAO {

    public List getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from User").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public User getUser(String internalId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (User) session.get(User.class, Integer.valueOf(internalId));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
