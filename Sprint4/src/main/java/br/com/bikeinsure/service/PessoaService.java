package br.com.bikeinsure.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.bikeinsure.dao.PessoaDao;
import br.com.bikeinsure.exception.BadInfoException;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.factory.ConnectionFactory;
import br.com.bikeinsure.model.Pessoa;

public class PessoaService {

    private PessoaDao pessoaDao;

    public PessoaService() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        pessoaDao = new PessoaDao(conn);
    }

    public void cadastrar(Pessoa pessoa) throws ClassNotFoundException, SQLException, BadInfoException {
        validar(pessoa);
        pessoaDao.cadastrar(pessoa);
    }

    private void validar(Pessoa pessoa) throws BadInfoException {
        // Implementar regras de validação, se necessário
    }

    public void atualizar(Pessoa pessoa) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
        validar(pessoa);
        pessoaDao.atualizar(pessoa);
    }

    public void deletar(int idPessoa) throws ClassNotFoundException, SQLException, IdNotFoundException {
        pessoaDao.deletar(idPessoa);
    }

    public List<Pessoa> listar() throws ClassNotFoundException, SQLException {
        return pessoaDao.listar();
    }

    public Pessoa pesquisar(int idPessoa) throws ClassNotFoundException, SQLException, IdNotFoundException {
        return pessoaDao.buscarPorId(idPessoa);
    }

	
}
