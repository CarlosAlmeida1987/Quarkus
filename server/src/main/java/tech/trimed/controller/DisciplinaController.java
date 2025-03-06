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
import tech.trimed.entity.DisciplinaEntity;
import tech.trimed.service.DisciplinaService;

@Path("/diciplina")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService){
        this.disciplinaService = disciplinaService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
    @QueryParam("pageSize")@DefaultValue("10")Integer pageSize){
        var users = disciplinaService.findAll(page, pageSize);
       return Response.ok(users).build();
    }

    @POST
    @Transactional
    public Response createDisciplina(DisciplinaEntity disciplinaEntity){
       return Response.ok(disciplinaService.createDisciplina(disciplinaEntity)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateDisciplina(@PathParam("id") Integer id, DisciplinaEntity disciplinaEntity){
       return Response.ok(disciplinaService.updateDisciplina(id, disciplinaEntity)).build();
    }

    @GET
    @Path("/{id}")
    public Response createDisciplina(@PathParam("id") Integer id){
       return Response.ok(disciplinaService.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDisciplina(@PathParam("id") Integer id){
      disciplinaService.deleteById(id);
       return Response.noContent().build();
    }

}
