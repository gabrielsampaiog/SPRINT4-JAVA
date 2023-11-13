package br.com.bikeinsure.teste;

import java.sql.SQLException;
import java.util.List;
import br.com.bikeinsure.model.Pessoa;
import br.com.bikeinsure.service.PessoaService;

public class TesteListarPessoas {

    public static void main(String[] args) {
        try {
            // Criando uma instância do serviço
            PessoaService pessoaService = new PessoaService();

            // Listando todas as pessoas
            List<Pessoa> listaPessoas = pessoaService.listar();

            // Exibindo os dados das pessoas
            for (Pessoa pessoa : listaPessoas) {
                System.out.println("ID: " + pessoa.getIdPessoa());
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CPF: " + pessoa.getCpf());
                System.out.println("RG: " + pessoa.getRg());
                System.out.println("Data de Nascimento: " + pessoa.getDataNascimento());
                System.out.println("Endereço: " + pessoa.getEndereco());
                System.out.println("Email: " + pessoa.getEmail());
                System.out.println("Telefone: " + pessoa.getTelefone());
                System.out.println("==============================");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
