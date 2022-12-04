package it.amedei.exception;/*
@author Alessandro Amedei
2022    
*/


import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersistenceExceptionMiddleware implements ExceptionMapper<PersistenceException> {
    @Override
    public Response toResponse(PersistenceException e) {

        Throwable t = e.getCause();
        while ((t != null) && !(t instanceof ConstraintViolationException)) {
            t = t.getCause();
        }
        if (t instanceof ConstraintViolationException) {
            // Here you're sure you have a ConstraintViolationException, you can handle it
            ConstraintViolationException exception = (ConstraintViolationException) t;
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new RestResponse(exception.getSQLException().getSQLState(), exception.getSQLException().getMessage(), exception.getClass().getName())).build();
        }

        e.printStackTrace();

        return Response.status(500).entity(e).build();
    }


}
