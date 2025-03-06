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
import tech.trimed.entity.SemestreEntity;
import tech.trimed.service.SemestreService;

@Path("/semestre")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SemestreController {

    private final SemestreService semestreService;

    public SemestreController(SemestreService semestreService){
        this.semestreService = semestreService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
    @QueryParam("pageSize")@DefaultValue("10")Integer pageSize){
        var users = semestreService.findAll(page, pageSize);
       return Response.ok(users).build();
    }

    @POST
    @Transactional
    public Response createSemestre(SemestreEntity semestreEntity){
       return Response.ok(semestreService.createSemestre(semestreEntity)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateSemestre(@PathParam("id") Integer id, SemestreEntity semestreEntity){
       return Response.ok(semestreService.updateSemestre(id, semestreEntity)).build();
    }

    @GET
    @Path("/{id}")
    public Response createSemestre(@PathParam("id") Integer id){
       return Response.ok(semestreService.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSemestre(@PathParam("id") Integer id){
      semestreService.deleteById(id);
       return Response.noContent().build();
    }

}
