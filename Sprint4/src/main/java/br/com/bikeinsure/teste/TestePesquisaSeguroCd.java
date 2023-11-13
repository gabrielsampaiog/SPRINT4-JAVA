package br.com.bikeinsure.teste;

import br.com.bikeinsure.model.Seguros;
import br.com.bikeinsure.service.SeguroService;

public class TestePesquisaSeguroCd {

    public static void main(String[] args) {
        try {
            SeguroService seguroService = new SeguroService();

            // Pesquisar Seguro por código
            Seguros seguroEncontrado = seguroService.pesquisar(1); // Substitua 1 pelo código desejado

            // Exibir os detalhes do Seguro encontrado
            if (seguroEncontrado != null) {
                System.out.println("Tipo de Seguro: " + seguroEncontrado.getTipoSeguro());
                // ... outros detalhes
            } else {
                System.out.println("Seguro não encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
