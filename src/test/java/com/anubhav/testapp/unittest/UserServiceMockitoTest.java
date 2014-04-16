package com.anubhav.testapp.unittest;

import com.anubhav.testapp.dao.UserDAO;
import com.anubhav.testapp.object.User;
import com.anubhav.testapp.webservice.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static junit.framework.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anubhav on 4/16/2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceMockitoTest {

    @Mock
    private UserDAO userDAO;

    private UserService userService = null;

    @Before
    public void setUp(){
        this.userService = new UserService(userDAO);
    }

    @Test
    public void testUserList(){
        List<User> mockitoUserList = new ArrayList<User>();
        mockitoUserList.add(new User(1, "User 1", null));

        List userList = null;
        try {
            Mockito.when(userDAO.getAllUsers()).thenReturn(mockitoUserList);
            userList = userService.list();
        } catch (Exception e) {
            userList = null;
        }
        assertNotNull("Error gettting user list.", userList);
    }

    @Test
    public void testUserListEmpty(){
        List userList = null;
        try {
            Mockito.when(userDAO.getAllUsers()).thenReturn(new ArrayList<User>());
            userList = userService.list();
        } catch (Exception e) {
            userList = null;
        }
        assertEquals("Unable to  handle empty  user list.", userList,  new ArrayList<User>());
    }
}
