
package cembrzynski;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author marcin
 */
public class AppProperties implements ServletContextListener{
    
    private final static Logger logger = Logger.getLogger(AppProperties.class.getName());
    private static Properties properties = new Properties();

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
   
    
    

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        try {
            
            InputStream inputStream  = AppProperties.class.getClassLoader().getResourceAsStream("app.properties");
            //Properties  properties = new Properties();
            properties.load(inputStream);
            sce.getServletContext().setAttribute("properties", properties);
            logger.info("#### properties: " + properties.toString());
           
        } catch (IOException ex) {
            Logger.getLogger(AppProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
