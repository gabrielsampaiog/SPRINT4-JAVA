package br.com.bikeinsure.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.bikeinsure.dao.SeguroDao;
import br.com.bikeinsure.exception.BadInfoException;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.factory.ConnectionFactory;
import br.com.bikeinsure.model.Seguros;

public class SeguroService {

    private SeguroDao seguroDao;

    public SeguroService() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        seguroDao = new SeguroDao(conn);
    }

    public void cadastrar(Seguros seguro) throws ClassNotFoundException, SQLException, BadInfoException {
        validar(seguro);
        seguroDao.cadastrar(seguro);
    }

    private void validar(Seguros seguro) throws BadInfoException {
        // Implementar regras de validação, se necessário
    }

    public void atualizar(Seguros seguro) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
        validar(seguro);
        seguroDao.atualizar(seguro);
    }

    public void deletar(int cdSeguro) throws ClassNotFoundException, SQLException, IdNotFoundException {
        seguroDao.deletar(cdSeguro);
    }

    public List<Seguros> listar() throws ClassNotFoundException, SQLException {
        return seguroDao.listarTodos();
    }

    public Seguros pesquisar(int cdSeguro) throws ClassNotFoundException, SQLException, IdNotFoundException {
        return seguroDao.pesquisar(cdSeguro);
    }
}
