
package cembrzynski;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import java.util.logging.Level;
import java.util.logging.Logger;




public class SMSService {
    
    private final static Logger logger = Logger.getLogger(SMSService.class.getName());
    private final String ACCOUNT_SID = AppProperties.getProperty("twillio.account.sid");
    private final String AUTH_TOKEN =  AppProperties.getProperty("twillio.account.auth_token");
    private final String PHONE_FROM = AppProperties.getProperty("twillio.account.phone.from");
    private final String PHONE_TO = AppProperties.getProperty("twillio.account.phone.to");
  
   

    public SMSService() {
        logger.log(Level.INFO, "##### ACCOUNT_SID: {0}", ACCOUNT_SID);
        logger.log(Level.INFO, "##### AUTH_TOKEN: {0}", AUTH_TOKEN);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public static SMSService instance() {
        return new SMSService();
    }
    
    
    public boolean sendSMS(Booking booking){
        
        PhoneNumber fromNumber = new PhoneNumber(PHONE_FROM);
        PhoneNumber toNumber = new PhoneNumber(PHONE_TO);
        
        
        try{
        
            MessageCreator messageCreator = Message.creator(toNumber, fromNumber, booking.toString());
            Message message = messageCreator.create();
            
        
        }catch(Exception ex){
            logger.info("## Message send failure");
            return false;
        }
        
        return true;
        
    }
}
