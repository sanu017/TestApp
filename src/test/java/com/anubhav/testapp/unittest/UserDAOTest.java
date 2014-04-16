package com.anubhav.testapp.unittest;

import com.anubhav.testapp.dao.UserDAO;
import com.anubhav.testapp.object.User;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by Anubhav on 4/16/2014.
 */
public class UserDAOTest {

    @Test
    public void testGetAllUsers() throws Exception {
        UserDAO  userDAO = new UserDAO();
        List userList = null;
        try {
            userList = userDAO.getAllUsers();
        } catch (Exception e) {
            //e.printStackTrace();
            userList = null;
        }
        assertNotNull("Exception in UserDAO.getAllUsers() method.", userList);
    }

    @Test
    public void  testFindUserByIdSuccess(){
        UserDAO userDAO = new UserDAO();
        User user = null;
        try {
            user = userDAO.findByInternalId(1);
        } catch (Exception e) {
            //e.printStackTrace();
            user = null;
        }
        assertNotNull("Error finding user by internalId.", user);
    }

    @Test
    public void  testFindUserByIdNotFound(){
        UserDAO userDAO = new UserDAO();
        User user = null;
        String exceptionMessage = null;
        try {
            user = userDAO.findByInternalId(1);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
            user = null;
        }
        assertNull(exceptionMessage, user);
    }
}
