package br.com.bikeinsure.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.bikeinsure.dao.ColaboradorDao;
import br.com.bikeinsure.model.Colaborador;

public class TesteListarColaborador {

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

            try {
                // Chamada do método para listar todos os colaboradores
                List<Colaborador> colaboradores = colaboradorDao.listarTodos();

                // Exibição dos colaboradores
                for (Colaborador colaborador : colaboradores) {
                    System.out.println("ID: " + colaborador.getIdColaborador());
                    System.out.println("Nome: " + colaborador.getNome());
                    System.out.println("Senha Hash: " + colaborador.getSenhaHash());
                    System.out.println("Salt: " + colaborador.getSalt());
                    System.out.println("------------------------");
                }

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
