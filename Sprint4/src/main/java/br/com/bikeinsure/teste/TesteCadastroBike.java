package br.com.bikeinsure.teste;

import br.com.bikeinsure.dao.BikeDao;
import br.com.bikeinsure.factory.ConnectionFactory;
import br.com.bikeinsure.model.Bike;

public class TesteCadastroBike {

    public static void main(String[] args) {
        try {
            // Obtendo uma conexão com o banco de dados
            var connection = ConnectionFactory.getConnection();

            // Criando uma instância da classe de acesso a dados de Bike
            var bikeDao = new BikeDao(connection);

            // Cadastrando a bike
            bikeDao.cadastrar(new Bike(
                1,                 // Defina o ID da bike conforme necessário
                "Nome da Bike",
                1000.0,
                "Azul",
                "Modelo XYZ",
                "Descrição do Modelo",
                "M",
                "Marca ABC",
                "Sim"
            ));

            System.out.println("Bike cadastrada com sucesso.");

            // Fechando a conexão com o banco de dados
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
