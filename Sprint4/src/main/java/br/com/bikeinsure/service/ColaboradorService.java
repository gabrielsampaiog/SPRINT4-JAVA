package br.com.bikeinsure.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.bikeinsure.dao.ColaboradorDao;
import br.com.bikeinsure.exception.BadInfoException;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.factory.ConnectionFactory;
import br.com.bikeinsure.model.Colaborador;

public class ColaboradorService {

    private ColaboradorDao colaboradorDao;

    public ColaboradorService() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        colaboradorDao = new ColaboradorDao(conn);
    }

    public void cadastrarColaborador(Colaborador colaborador) throws ClassNotFoundException, SQLException, BadInfoException {
        validar(colaborador);
        colaboradorDao.cadastrar(colaborador);
    }

    private void validar(Colaborador colaborador) throws BadInfoException {
        // Implementar regras de validação, se necessário
    }

    public void atualizarColaborador(Colaborador colaborador) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
        validar(colaborador);
        colaboradorDao.atualizar(colaborador);
    }

    public void deletarColaborador(int idColaborador) throws ClassNotFoundException, SQLException, IdNotFoundException {
        colaboradorDao.deletar(idColaborador);
    }

    public List<Colaborador> listarColaboradores() throws ClassNotFoundException, SQLException {
        return colaboradorDao.listarTodos();
    }

    public Colaborador pesquisarColaborador(int idColaborador) throws ClassNotFoundException, SQLException, IdNotFoundException {
        return colaboradorDao.pesquisar(idColaborador);


    }
}
