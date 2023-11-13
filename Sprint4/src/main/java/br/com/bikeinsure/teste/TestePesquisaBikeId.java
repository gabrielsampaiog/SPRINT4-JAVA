package br.com.bikeinsure.teste;

import br.com.bikeinsure.model.Bike;
import br.com.bikeinsure.service.BikeService;

public class TestePesquisaBikeId {

    public static void main(String[] args) {
        try {
            BikeService bikeService = new BikeService();

            // Buscar Bike por ID
            Bike bikeEncontrada = bikeService.pesquisar(1); // Substitua 1 pelo ID desejado

            // Exibir os detalhes da Bike encontrada
            if (bikeEncontrada != null) {
                System.out.println("Nome: " + bikeEncontrada.getNomeBike());
                System.out.println("Preço: " + bikeEncontrada.getPreco());
                System.out.println("Cor: " + bikeEncontrada.getCor());
                // ... outros detalhes
            } else {
                System.out.println("Bike não encontrada.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
