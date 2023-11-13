package br.com.bikeinsure.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.bikeinsure.dao.ColaboradorDao;

public class TesteDeletarColaboradorPeloId {

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

            // ID do colaborador a ser deletado (substitua pelo ID desejado)
            int idColaboradorParaDeletar = 1; // Substitua pelo ID desejado

            try {
                // Chamada do método para deletar o colaborador
                colaboradorDao.deletar(idColaboradorParaDeletar);

                // Exibição de mensagem de sucesso
                System.out.println("Colaborador deletado com sucesso!");

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
