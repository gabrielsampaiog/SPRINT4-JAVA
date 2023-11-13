package br.com.bikeinsure.teste;

import br.com.bikeinsure.dao.BikeDao;
import br.com.bikeinsure.factory.ConnectionFactory;

public class TesteDeletarBikePeloId {

    public static void main(String[] args) {
        try {
            // Obtendo uma conexão com o banco de dados
            var connection = ConnectionFactory.getConnection();

            // Criando uma instância da classe de acesso a dados de Bike
            var bikeDao = new BikeDao(connection);

            // Defina o ID da bike que deseja deletar
            int bikeIdParaDeletar = 1; // Substitua pelo ID correto

            // Deletando a bike pelo ID
            bikeDao.deletar(bikeIdParaDeletar);

            System.out.println("Bike deletada com sucesso.");

            // Fechando a conexão com o banco de dados
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
