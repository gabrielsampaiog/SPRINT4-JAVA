package br.com.bikeinsure.teste;

import java.sql.SQLException;
import br.com.bikeinsure.exception.BadInfoException;
import br.com.bikeinsure.model.Pessoa;
import br.com.bikeinsure.service.PessoaService;

public class TesteCadastroPessoa {

    public static void main(String[] args) {
        try {
            // Criando um objeto Pessoa para cadastro
            Pessoa novaPessoa = new Pessoa(
                0, // O ID será gerado automaticamente pelo banco de dados
                "Fulano de Tal",
                "123.456.789-01",
                123456789,
                "01/01/1990",
                "Rua Teste, 123",
                "hashed_password", // Substitua pela senha real já hasheada
                "salt_value",      // Substitua pelo valor real do salt
                "fulano@teste.com",
                "(11) 98765-4321"
            );

            // Criando uma instância do serviço
            PessoaService pessoaService = new PessoaService();

            // Cadastrando a pessoa
            pessoaService.cadastrar(novaPessoa);

            System.out.println("Pessoa cadastrada com sucesso!");
        } catch (ClassNotFoundException | SQLException | BadInfoException e) {
            e.printStackTrace();
        }
    }
}
