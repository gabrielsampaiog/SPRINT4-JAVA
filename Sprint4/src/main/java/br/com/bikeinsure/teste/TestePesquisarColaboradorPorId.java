package br.com.bikeinsure.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.bikeinsure.dao.ColaboradorDao;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.model.Colaborador;

public class TestePesquisarColaboradorPorId {

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

            // ID do colaborador a ser pesquisado (substitua pelo ID desejado)
            int idColaboradorParaPesquisar = 1;

            try {
                // Chamada do método para pesquisar o colaborador por ID
                Colaborador colaboradorEncontrado = colaboradorDao.pesquisar(idColaboradorParaPesquisar);

                // Exibição dos dados do colaborador encontrado
                System.out.println("Colaborador encontrado:");
                System.out.println("ID: " + colaboradorEncontrado.getIdColaborador());
                System.out.println("Nome: " + colaboradorEncontrado.getNome());
                System.out.println("Senha Hash: " + colaboradorEncontrado.getSenhaHash());
                System.out.println("Salt: " + colaboradorEncontrado.getSalt());
            } catch (SQLException | IdNotFoundException e) {
                // Tratamento de exceções, se necessário
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
