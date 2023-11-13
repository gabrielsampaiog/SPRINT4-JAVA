package br.com.bikeinsure.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.bikeinsure.dao.BikeDao;
import br.com.bikeinsure.exception.BadInfoException;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.factory.ConnectionFactory;
import br.com.bikeinsure.model.Bike;

public class BikeService {

    private BikeDao bikeDao;

    public BikeService() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        bikeDao = new BikeDao(conn);
    }

    public void cadastrar(Bike bike) throws ClassNotFoundException, SQLException, BadInfoException {
        validar(bike);
        bikeDao.cadastrar(bike);
    }

    private void validar(Bike bike) throws BadInfoException {
        // Implementar regras de validação, se necessário
    }

    public void atualizar(Bike bike) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
        validar(bike);
        bikeDao.alterar(bike);
    }

    public void deletar(int bikeId) throws ClassNotFoundException, SQLException, IdNotFoundException {
        bikeDao.deletar(bikeId);
    }

    public List<Bike> listar() throws ClassNotFoundException, SQLException {
        return bikeDao.retornarDados();
    }

    public Bike pesquisar(int bikeId) throws ClassNotFoundException, SQLException, IdNotFoundException {
        return bikeDao.pesquisar(bikeId);
    }
}
