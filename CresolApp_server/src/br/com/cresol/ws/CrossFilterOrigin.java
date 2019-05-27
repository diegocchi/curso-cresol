package br.com.cresol.ws;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CrossFilterOrigin implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, 
    		ContainerResponseContext response) {
    	System.out.println("******************************");
        System.out.println("Criando os Filter no Sistema");
        System.out.println("******************************");
    	response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", 
        		"GET, POST, PUT, DELETE, OPTIONS");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", 
        		"origin, content-type,content-encoding, accept"); 
    }

}
