package com.github.adamzink.springbootmysqldemo.resource;

import com.github.adamzink.springbootmysqldemo.model.client.User;
import com.github.adamzink.springbootmysqldemo.model.client.UserRequest;
import com.github.adamzink.springbootmysqldemo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/users")
@Api(value = "User", description = "Resource for getting and modifying Users")
@Component
public class UserResource {

    @Autowired
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all Users",
            response = User.class,
            responseContainer = "List")
    public Collection<User> getAll() {
        return userService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create a User",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request format")})
    public User save(
            @ApiParam(value = "User to be created", required = true) final UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Update a User",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request format"),
            @ApiResponse(code = 404, message = "User not found")})
    public User update(
            @ApiParam(value = "User id to update", required = true) @PathParam("id") final Long id,
            @ApiParam(value = "User details to be updated", required = true) final UserRequest userRequest) {
        return userService.update(id, userRequest);
    }

    @DELETE
    @Path("{id}")
    @ApiOperation(value = "Delete a User")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "User deleted successfully"),
            @ApiResponse(code = 404, message = "User not found")})
    public void delete(
            @ApiParam(value = "User id to delete", required = true) @PathParam("id") final Long id) {
        userService.delete(id);
    }

}

