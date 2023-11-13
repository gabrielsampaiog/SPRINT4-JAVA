package br.com.bikeinsure.teste;

import br.com.bikeinsure.dao.BikeDao;
import br.com.bikeinsure.model.Bike;
import br.com.bikeinsure.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteAtualizarBike {

    public static void main(String[] args) {
        try {
            // Obtendo uma conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();

            // Criando uma instância de Bike com os novos valores
            Bike bikeAtualizada = new Bike(
                    1,                  // bikeId
                    "Novo Nome",        // nomeBike
                    600.00,             // preco
                    "Vermelha",         // cor
                    "Modelo ABC",       // nomeModelo
                    "Nova Descrição do Modelo ABC",  // descricaoModelo
                    "Grande",           // tamanho
                    "Nova Marca",       // marca
                    "Sim"               // personalizada
            );

            // Criando uma instância de BikeDao para interagir com o banco de dados
            BikeDao bikeDao = new BikeDao(conn);

            // Atualizando os dados da bike
            String resultado = bikeDao.alterar(bikeAtualizada);

            // Fechando a conexão com o banco de dados
            conn.close();

            // Exibindo o resultado da atualização
            System.out.println(resultado);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
