package tech.trimed.controller;

import java.util.UUID;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tech.trimed.Service.UserService;
import tech.trimed.entity.UsuarioEntity;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
    @QueryParam("pageSize")@DefaultValue("10")Integer pageSize){
        var users = userService.findAll(page, pageSize);
       return Response.ok(users).build();
    }

    @POST
    @Transactional
    public Response createUser(UsuarioEntity userEntity){
       return Response.ok(userService.createUser(userEntity)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") UUID id, UsuarioEntity usuarioEntity){
       return Response.ok(userService.updateUser(id, usuarioEntity)).build();
    }

    @GET
    @Path("/{id}")
    public Response createUser(@PathParam("id") UUID id){
       return Response.ok(userService.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") UUID id){
        userService.deleteById(id);
       return Response.noContent().build();
    }

}
