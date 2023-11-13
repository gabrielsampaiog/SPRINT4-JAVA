package br.com.bikeinsure.teste;

import java.sql.SQLException;
import br.com.bikeinsure.service.PessoaService;
import br.com.bikeinsure.exception.IdNotFoundException;

public class TesteDeletarPessoaPorId {

    public static void main(String[] args) {
        try {
            // Criando uma instância do serviço
            PessoaService pessoaService = new PessoaService();

            // ID da pessoa a ser deletada (substitua pelo ID desejado)
            int idPessoaParaDeletar = 1;

            // Deletando a pessoa por ID
            pessoaService.deletar(idPessoaParaDeletar);

            System.out.println("Pessoa deletada com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (IdNotFoundException e) {
            // Lidar com a exceção IdNotFoundException
            System.out.println("Erro ao deletar pessoa: " + e.getMessage());
        }
    }
}
