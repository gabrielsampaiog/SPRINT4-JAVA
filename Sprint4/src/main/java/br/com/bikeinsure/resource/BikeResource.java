package br.com.bikeinsure.resource;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.bikeinsure.dao.BikeDao;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.factory.ConnectionFactory;
import br.com.bikeinsure.model.Bike;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/api/bikes")  // Adicionei a anotação @Path aqui
public class BikeResource {

    private BikeDao dao;

    public BikeResource() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        dao = new BikeDao(conn);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@PathParam("id") int bikeId) throws SQLException {
        try {
            return Response.ok(dao.pesquisar(bikeId)).build();
        } catch (IdNotFoundException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/cadastrar") 
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Bike bike, @Context UriInfo uri) throws SQLException {
        dao.cadastrar(bike);

        UriBuilder url = uri.getAbsolutePathBuilder();
        url.path(String.valueOf(bike.getbikeId()));

        return Response.created(url.build()).build();
    }
}
