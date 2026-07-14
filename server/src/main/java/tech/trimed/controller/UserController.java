package tech.trimed.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
import tech.trimed.dto.UsuarioRequestDTO;
import tech.trimed.dto.UsuarioResponseDTO;
import tech.trimed.service.UserService;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GET
    @RolesAllowed("manager")
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
    @QueryParam("pageSize")@DefaultValue("10")Integer pageSize){
        var users = userService.findAll(page, pageSize);
       return Response.ok(users).build();
    }

    @POST
    @Transactional
    @RolesAllowed("manager")
    public Response createUser(@Valid UsuarioRequestDTO dto){
       UsuarioResponseDTO created = userService.createUser(dto);
       return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @RolesAllowed("manager")
    public Response updateUser(@PathParam("id") Integer id, @Valid UsuarioRequestDTO dto){
       return Response.ok(userService.updateUser(id, dto)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("manager")    
    public Response findById(@PathParam("id") Integer id){
       return Response.ok(userService.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    public Response deleteUser(@PathParam("id") Integer id){
        userService.deleteById(id);
       return Response.noContent().build();
    }

}
