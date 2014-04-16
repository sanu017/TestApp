package com.anubhav.testapp.listener;

//import org.hsqldb.Server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Anubhav on 4/16/2014.
 */
public class HSqlManager implements ServletContextListener {

    //private static Server hsqlServer = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Inside HSqlManager: contextInitialized()");
        /*try {
            hsqlServer = new Server();
            hsqlServer.setLogWriter(null);
            hsqlServer.setSilent(true);
            hsqlServer.setDatabaseName(0, "xdb");
            hsqlServer.setDatabasePath(0, "file:testdb");

            // Start the database
            hsqlServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Inside HSqlManager: contextDestroyed()");
        /*try {
            if (hsqlServer != null) {
                hsqlServer.checkRunning(true);
                hsqlServer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
