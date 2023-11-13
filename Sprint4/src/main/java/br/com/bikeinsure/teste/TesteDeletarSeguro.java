package br.com.bikeinsure.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.bikeinsure.dao.SeguroDao;

public class TesteDeletarSeguro {

    public static void main(String[] args) {
        // Configuração da conexão com o banco de dados (substitua as credenciais conforme necessário)
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        // Código do seguro que deseja deletar (substitua pelo código desejado)
        int cdSeguroParaDeletar = 1;

        try {
            // Estabelecendo a conexão
            Connection conn = DriverManager.getConnection(url, usuario, senha);

            // Criando uma instância do DAO
            SeguroDao seguroDao = new SeguroDao(conn);

            try {
                // Chamando o método para deletar o seguro pelo código
                seguroDao.deletar(cdSeguroParaDeletar);

                // Exibindo mensagem de sucesso
                System.out.println("Seguro deletado com sucesso!");

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
