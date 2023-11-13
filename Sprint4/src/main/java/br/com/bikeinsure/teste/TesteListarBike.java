package br.com.bikeinsure.teste;

import br.com.bikeinsure.dao.BikeDao;
import br.com.bikeinsure.model.Bike;
import br.com.bikeinsure.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class TesteListarBike {

    public static void main(String[] args) {
        try {
            // Obtendo uma conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();

            // Criando uma instância de BikeDao para interagir com o banco de dados
            BikeDao bikeDao = new BikeDao(conn);

            // Obtendo a lista de bikes
            ArrayList<Bike> bikes = bikeDao.retornarDados();

            // Fechando a conexão com o banco de dados
            conn.close();

            // Exibindo as informações das bikes
            if (bikes != null) {
                for (Bike bike : bikes) {
                    System.out.println("ID: " + bike.getbikeId());
                    System.out.println("Nome: " + bike.getNomeBike());
                    System.out.println("Preço: " + bike.getPreco());
                    System.out.println("Cor: " + bike.getCor());
                    System.out.println("Tamanho: " + bike.getTamanho());
                    System.out.println("Marca: " + bike.getMarca());
                    System.out.println("Personalizada: " + bike.getPersonalizada());
                    System.out.println("Nome do Modelo: " + bike.getNomeModelo());
                    System.out.println("Descrição do Modelo: " + bike.getDescricaoModelo());
                    System.out.println("------------------------------");
                }
            } else {
                System.out.println("Nenhuma bike encontrada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
