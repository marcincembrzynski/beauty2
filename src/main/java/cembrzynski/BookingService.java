package cembrzynski;

import com.googlecode.objectify.Key;
import static com.googlecode.objectify.ObjectifyService.ofy;

public class BookingService {
    
   
    
    public Booking create(Booking booking){
        Key<Booking> key = ofy().save().entity(booking).now(); 
        System.out.println("### key: " + key);      
        return booking;
    }
}
