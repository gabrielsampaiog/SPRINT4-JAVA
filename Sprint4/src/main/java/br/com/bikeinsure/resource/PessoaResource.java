package br.com.bikeinsure.resource;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.bikeinsure.dao.PessoaDao;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.factory.ConnectionFactory;
import br.com.bikeinsure.model.Pessoa;
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

@Path("/api/pessoas")  // Ajustei o path para "/api/pessoas"
public class PessoaResource {

    private PessoaDao dao;

    public PessoaResource() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        dao = new PessoaDao(conn);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@PathParam("id") int idPessoa) throws SQLException {
        try {
            return Response.ok(dao.buscarPorId(idPessoa)).build();
        } catch (IdNotFoundException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/cadastrar")  
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Pessoa pessoa, @Context UriInfo uri) throws SQLException {
        dao.cadastrar(pessoa);

        UriBuilder url = uri.getAbsolutePathBuilder();
        url.path(String.valueOf(pessoa.getIdPessoa()));

        return Response.created(url.build()).build();
    }
}
