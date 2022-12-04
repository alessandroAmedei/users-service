package it.amedei.exception;/*
@author Alessandro Amedei
2022    
*/


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMiddleware implements ExceptionMapper<RestException> {
    @Override
    public Response toResponse(RestException exception) {

        return Response.status(exception.getState())
                .entity(new RestResponse(exception.getCode(), exception.getMessage(), exception.getClass().getName())).build();
    }


}
