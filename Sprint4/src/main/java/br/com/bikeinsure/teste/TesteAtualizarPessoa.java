package br.com.bikeinsure.teste;

import java.sql.SQLException;
import br.com.bikeinsure.model.Pessoa;
import br.com.bikeinsure.service.PessoaService;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.exception.BadInfoException;

public class TesteAtualizarPessoa {

    public static void main(String[] args) {
        try {
            // Criando uma instância do serviço
            PessoaService pessoaService = new PessoaService();

            // ID da pessoa a ser atualizada (substitua pelo ID desejado)
            int idPessoaParaAtualizar = 1;

            // Buscando a pessoa pelo ID
            Pessoa pessoa = pessoaService.pesquisar(idPessoaParaAtualizar);

            // Atualizando dados da pessoa (substitua com os dados desejados)
            pessoa.setNome("Novo Nome");
            pessoa.setCpf("123.456.789-01");
            pessoa.setRg(1234567);
            pessoa.setDataNascimento("2000-01-01");
            pessoa.setEndereco("Nova Rua, 123");
            pessoa.setEmail("novo.email@example.com");
            pessoa.setTelefone("(11) 98765-4321");

            // Atualizando a pessoa
            pessoaService.atualizar(pessoa);

            System.out.println("Pessoa atualizada com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (IdNotFoundException | BadInfoException e) {
            // Lidar com a exceção IdNotFoundException ou BadInfoException
            System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }
}
