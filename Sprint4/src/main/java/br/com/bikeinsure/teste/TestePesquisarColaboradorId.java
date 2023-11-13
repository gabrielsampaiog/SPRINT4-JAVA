package br.com.bikeinsure.teste;

import br.com.bikeinsure.model.Colaborador;
import br.com.bikeinsure.service.ColaboradorService;

public class TestePesquisarColaboradorId {

    public static void main(String[] args) {
        try {
            ColaboradorService colaboradorService = new ColaboradorService();

            // Pesquisar Colaborador por ID
            Colaborador colaboradorEncontrado = colaboradorService.pesquisarColaborador(1); // Substitua 1 pelo ID desejado

            // Exibir os detalhes do Colaborador encontrado
            if (colaboradorEncontrado != null) {
                System.out.println("Nome: " + colaboradorEncontrado.getNome());
                // ... outros detalhes
            } else {
                System.out.println("Colaborador não encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
