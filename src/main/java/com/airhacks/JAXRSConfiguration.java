package com.airhacks;


import org.glassfish.jersey.server.ResourceConfig;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 *
 * @author airhacks.com
 */

public class JAXRSConfiguration extends ResourceConfig{

    public JAXRSConfiguration() {
        packages("cembrzynski");
    }

    
}
