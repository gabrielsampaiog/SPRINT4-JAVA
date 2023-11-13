package br.com.bikeinsure.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.bikeinsure.dao.SeguroDao;
import br.com.bikeinsure.model.Seguros;

public class TesteListarSeguros {

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
                // Chamando o método para listar todos os seguros
                List<Seguros> listaSeguros = seguroDao.listarTodos();

                // Exibindo os seguros
                System.out.println("Lista de Seguros:");
                for (Seguros seguro : listaSeguros) {
                    System.out.println(seguro);
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
