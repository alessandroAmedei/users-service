package it.amedei.api;/*
@author Alessandro Amedei
2022    
*/

import it.amedei.entity.User;
import it.amedei.exception.RestException;
import it.amedei.validator.ValidationGroups;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService {

    @Inject
    UserController userController;

    @GET
    @Path("/{id}")
    public User findById(@PathParam("id") Integer id) throws RestException {
        return userController.findById(id);
    }

    @POST
    @Path("/find")
    public List<User> find(User user) {
        return userController.find(user);
    }

    @PUT
    public User update(@Valid @ConvertGroup(to = ValidationGroups.Put.class) User user) throws RestException {
        return userController.update(user);
    }

    @POST
    public User create(@Valid @ConvertGroup(to = ValidationGroups.Post.class) User user) throws RestException {
        return userController.create(user);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) throws RestException {
        userController.delete(id);
    }

    @POST
    @Path("/csv")
    @Consumes("text/csv")
    public List<User> insertCsv(File file) throws IOException, RestException {
        return userController.insertCsv(file);
    }

}
