package com.github.adamzink.springbootmysqldemo.resource;

import com.github.adamzink.springbootmysqldemo.facade.UserFacade;
import com.github.adamzink.springbootmysqldemo.model.client.User;
import com.github.adamzink.springbootmysqldemo.model.client.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Component
public class UserResource {

    @Autowired
    UserFacade userFacade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User save(final UserRequest userRequest) {
        return userFacade.save(userRequest);
    }

}

