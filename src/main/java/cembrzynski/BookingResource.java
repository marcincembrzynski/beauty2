
package cembrzynski;





import java.util.logging.Logger;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Named
@Path("/booking")
public class BookingResource {
    
    private final static Logger logger = Logger.getLogger(BookingResource.class.getName());
   
   
    @GET
    public Response test(){
        return Response.ok("ok").build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBooking(Booking booking) throws InterruptedException{
     
        booking.setCreated(java.time.LocalDateTime.now().toString());
        
        BookingService bookingService = new BookingService();
        Booking newBooking = bookingService.create(booking);
        logger.info(newBooking.toString());
       
        boolean sent = SMSService.instance().sendSMS(newBooking);
        
        EmailService emailService = new EmailService();
        emailService.sendEmailMail(newBooking);
         
        return Response.ok(newBooking).build();
    }
    
   
}
