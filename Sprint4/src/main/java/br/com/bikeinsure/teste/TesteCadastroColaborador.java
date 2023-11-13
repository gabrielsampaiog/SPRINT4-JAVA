package br.com.bikeinsure.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.bikeinsure.dao.ColaboradorDao;
import br.com.bikeinsure.model.Colaborador;

public class TesteCadastroColaborador {

    public static void main(String[] args) {
        // Configuração da conexão com o banco de dados (substitua as credenciais conforme necessário)
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try {
            // Estabelecendo a conexão
            Connection conn = DriverManager.getConnection(url, usuario, senha);

            // Criação de uma instância do DAO
            ColaboradorDao colaboradorDao = new ColaboradorDao(conn);

            // Dados do colaborador a ser cadastrado (substitua pelos dados desejados)
            int idColaborador = 1; // Substitua pelo ID desejado
            String nomeColaborador = "Nome do Colaborador";
            String senhaHash = "hash_da_senha"; // Substitua pela senha desejada
            String salt = "salt"; // Substitua pelo salt desejado

            // Criação de uma instância de Colaborador com os dados fornecidos
            Colaborador novoColaborador = new Colaborador(idColaborador, nomeColaborador, senhaHash, salt);

            try {
                // Chamada do método para cadastrar o colaborador
                colaboradorDao.cadastrar(novoColaborador);

                // Exibição de mensagem de sucesso
                System.out.println("Colaborador cadastrado com sucesso!");

            } catch (SQLException e) {
                // Tratamento de exceções SQL, se necessário
                e.printStackTrace();
            }

            // Fechamento da conexão
            conn.close();

        } catch (SQLException e) {
            // Tratamento de exceções relacionadas à conexão
            e.printStackTrace();
        }
    }
}
