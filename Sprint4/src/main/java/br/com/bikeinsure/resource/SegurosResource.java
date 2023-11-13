package br.com.bikeinsure.resource;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.bikeinsure.dao.SeguroDao;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.factory.ConnectionFactory;
import br.com.bikeinsure.model.Seguros;
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

@Path("/api/seguros")  // Ajustei o path para "/api/seguros"
public class SegurosResource {

    private SeguroDao dao;

    public SegurosResource() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        dao = new SeguroDao(conn);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@PathParam("id") int cdSeguro) throws SQLException {
        try {
            return Response.ok(dao.pesquisar(cdSeguro)).build();
        } catch (IdNotFoundException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/cadastrar")  // Adicionei o path "/cadastrar"
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Seguros seguro, @Context UriInfo uri) throws SQLException {
        dao.cadastrar(seguro);

        UriBuilder url = uri.getAbsolutePathBuilder();
        url.path(String.valueOf(seguro.getCdSeguro()));

        return Response.created(url.build()).build();
    }
}
