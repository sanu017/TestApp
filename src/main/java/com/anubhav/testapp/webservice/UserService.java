package com.anubhav.testapp.webservice;

import com.anubhav.testapp.dao.UserDAO;
import com.anubhav.testapp.object.Book;
import com.anubhav.testapp.object.User;
import com.anubhav.testapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.activation.MimeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Anubhav on 4/16/2014.
 */
@Path("/user")
public class UserService {

    private UserDAO userDAO = new UserDAO();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list(){
        return userDAO.getAllUsers();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") String id){
        return userDAO.getUser(id);
    }

    @GET
    @Path("/bootstrap")
    @Produces(MediaType.APPLICATION_JSON)
    public String bootstrap(){
        System.out.println("Start bootstrap");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            User u1 = new User(101, "User1",  null);
            session.save(u1);

            Book b1 = new Book(101, "1212-121", "Book1 Title", "Book1 Author",  null);
            session.save(b1);
            Book b2 = new Book(101, "1212-121", "Book1 Title", "Book1 Author",  null);
            session.save(b2);
            Book b3 = new Book(101, "1212-121", "Book1 Title", "Book1 Author",  null);
            session.save(b3);
            Book b4 = new Book(101, "1212-121", "Book1 Title", "Book1 Author",  null);
            session.save(b4);
            Book b5 = new Book(101, "1212-121", "Book1 Title", "Book1 Author",  null);
            session.save(b5);

            Set<Book> bookSet = new HashSet<Book>();
            bookSet.add(b1);
            bookSet.add(b2);
            User u2 = new User(102,  "User2", bookSet);
            session.save(u2);
            transaction.commit();
            return "success";
        }catch(Exception  e){
            e.printStackTrace();
            transaction.rollback();
            return e.getMessage();
        }finally {
            session.close();
            System.out.println("End bootstrap");
        }
    }
}
