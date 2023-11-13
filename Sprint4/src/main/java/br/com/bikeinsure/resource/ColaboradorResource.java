package br.com.bikeinsure.resource;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.bikeinsure.dao.ColaboradorDao;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.factory.ConnectionFactory;
import br.com.bikeinsure.model.Colaborador;
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

@Path("/api/colaboradores")  // Ajustei o path para "/api/colaboradores"
public class ColaboradorResource {

    private ColaboradorDao dao;

    public ColaboradorResource() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        dao = new ColaboradorDao(conn);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@PathParam("id") int idColaborador) throws SQLException {
        try {
            return Response.ok(dao.pesquisar(idColaborador)).build();
        } catch (IdNotFoundException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/cadastrar")  // Adicionei o path "/cadastrar"
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Colaborador colaborador, @Context UriInfo uri) throws SQLException {
        dao.cadastrar(colaborador);

        UriBuilder url = uri.getAbsolutePathBuilder();
        url.path(String.valueOf(colaborador.getIdColaborador()));

        return Response.created(url.build()).build();
    }
}
