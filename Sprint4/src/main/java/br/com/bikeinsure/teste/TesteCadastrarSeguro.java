package br.com.bikeinsure.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.bikeinsure.dao.SeguroDao;
import br.com.bikeinsure.model.Seguros;

public class TesteCadastrarSeguro {

    public static void main(String[] args) {
        // Configuração da conexão com o banco de dados (substitua as credenciais conforme necessário)
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try {
            // Estabelecendo a conexão
            Connection conn = DriverManager.getConnection(url, usuario, senha);

            // Criando uma instância do DAO
            SeguroDao seguroDao = new SeguroDao(conn);

            try {
                // Criando um objeto Seguros para cadastrar
                Seguros novoSeguro = new Seguros(1, "Seguro Tipo X", "2023-01-01", "2023-12-31", "Ativo");

                // Chamando o método para cadastrar o seguro
                seguroDao.cadastrar(novoSeguro);

                // Exibindo mensagem de sucesso
                System.out.println("Seguro cadastrado com sucesso!");

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
