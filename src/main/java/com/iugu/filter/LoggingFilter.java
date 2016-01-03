package com.iugu.filter;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;

public class LoggingFilter implements ClientRequestFilter {
    private static final Logger LOG = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        //LOG.log(Level.INFO, requestContext.getEntity().toString());
    	   URI uri = requestContext.getUri();
    	   String method = requestContext.getMethod();
    	   System.out.printf("+++ Request(%s) to: %s\n--- Headers:\n", method, uri);
    	   MultivaluedMap<String, Object> headers = requestContext.getHeaders();
    	   for (String key : headers.keySet()) {
    	      System.out.printf("\t%s: %s\n", key, headers.getFirst(key));
    	   }
    	   
    
    	   System.out.printf("--- End Headers:\n");
    	   Object body = requestContext.getEntity();
    	   System.out.printf("%s\n--- End Body:\n", body);
    	   System.out.println("-----------------------------------------------");    	   

    }
}
