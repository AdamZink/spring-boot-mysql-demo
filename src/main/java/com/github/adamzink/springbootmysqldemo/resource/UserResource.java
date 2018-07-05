package com.github.adamzink.springbootmysqldemo.resource;

import com.github.adamzink.springbootmysqldemo.model.client.User;
import com.github.adamzink.springbootmysqldemo.model.client.UserRequest;
import com.github.adamzink.springbootmysqldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/users")
@Component
public class UserResource {

    @Autowired
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getAll() {
        return userService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User save(final UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(@PathParam("id") final Long id, final UserRequest userRequest) {
        return userService.update(id, userRequest);
    }

}

