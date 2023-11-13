package br.com.bikeinsure.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.bikeinsure.dao.ColaboradorDao;
import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.model.Colaborador;

public class TesteAtualizarColaborador {

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

            // ID do colaborador a ser atualizado (substitua pelo ID desejado)
            int idColaboradorParaAtualizar = 1; // Substitua pelo ID desejado

            try {
                // Pesquisar o colaborador pelo ID
                Colaborador colaborador = colaboradorDao.pesquisar(idColaboradorParaAtualizar);

                // Atualizar os dados do colaborador (substitua pelos novos dados desejados)
                colaborador.setNome("Novo Nome");
                colaborador.setSenhaHash("NovaSenhaHash");
                colaborador.setSalt("NovoSalt");

                // Chamada do método para atualizar o colaborador
                colaboradorDao.atualizar(colaborador);

                // Exibição de mensagem de sucesso
                System.out.println("Colaborador atualizado com sucesso!");

            } catch (IdNotFoundException e) {
                // Tratamento de exceção se o colaborador não for encontrado pelo ID
                System.out.println("Colaborador não encontrado.");
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
