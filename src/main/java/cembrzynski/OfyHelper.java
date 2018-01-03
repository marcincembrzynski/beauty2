/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cembrzynski;

import com.googlecode.objectify.ObjectifyService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author marcin
 */
public class OfyHelper implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ObjectifyService.register(Booking.class);

    }

    public void contextDestroyed(ServletContextEvent event) {

    }
}
