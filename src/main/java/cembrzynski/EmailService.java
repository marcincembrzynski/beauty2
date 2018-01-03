/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cembrzynski;

import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author marcin
 */
public class EmailService {

    private final static Logger logger = Logger.getLogger(EmailService.class.getName());
  
    
    
    public boolean sendEmailMail(Booking booking) {

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(AppProperties.getProperty("email.from.email"), AppProperties.getProperty("email.from.name")));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(AppProperties.getProperty("email.to.email"), AppProperties.getProperty("email.to.name")));
            msg.setSubject("Booking: " + booking.getId());
            msg.setText(booking.toString());
            Transport.send(msg);
        } catch (Exception ex) {
            logger.info(ex.getMessage());
            return false;
        }
        
        return true;

    }
}
