package tech.trimed.controller;

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
import tech.trimed.entity.CursoEntity;
import tech.trimed.service.CursosService;

@Path("/curso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursosController {

    private final CursosService cursosService;

    public CursosController(CursosService cursosService){
        this.cursosService = cursosService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
    @QueryParam("pageSize")@DefaultValue("10")Integer pageSize){
        var users = cursosService.findAll(page, pageSize);
       return Response.ok(users).build();
    }

    @POST
    @Transactional
    public Response createCurso(CursoEntity cursoEntity){
       return Response.ok(cursosService.createCurso(cursoEntity)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateCurso(@PathParam("id") Integer id, CursoEntity cursoEntity){
       return Response.ok(cursosService.updateCurso(id, cursoEntity)).build();
    }

    @GET
    @Path("/{id}")
    public Response createCurso(@PathParam("id") Integer id){
       return Response.ok(cursosService.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCurso(@PathParam("id") Integer id){
      cursosService.deleteById(id);
       return Response.noContent().build();
    }

}
