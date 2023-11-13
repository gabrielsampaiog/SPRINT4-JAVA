package br.com.bikeinsure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.model.Pessoa;

public class PessoaDao {

    private Connection conn;

    public PessoaDao(Connection conn) {
        this.conn = conn;
    }

    // Método para cadastrar uma pessoa
    public void cadastrar(Pessoa pessoa) throws SQLException {
        PreparedStatement stm = conn.prepareStatement("INSERT INTO t_pessoa "
                + "(id_pessoa, nome, cpf, rg, data_nascimento, endereco, senha_hash, salt, email, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        stm.setInt(1, pessoa.getIdPessoa());
        stm.setString(2, pessoa.getNome());
        stm.setString(3, pessoa.getCpf());
        stm.setInt(4, pessoa.getRg());
        stm.setString(5, pessoa.getDataNascimento());
        stm.setString(6, pessoa.getEndereco());
        stm.setString(7, pessoa.getSenhaHash());
        stm.setString(8, pessoa.getSalt());
        stm.setString(9, pessoa.getEmail());
        stm.setString(10, pessoa.getTelefone());

        stm.executeUpdate();
    }

    // Método para buscar uma pessoa por ID
    public Pessoa buscarPorId(int idPessoa) throws IdNotFoundException, SQLException {
        String sql = "SELECT * FROM t_pessoa WHERE id_pessoa = ?";
        
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, idPessoa);

            try (ResultSet result = stm.executeQuery()) {
                if (result.next()) {
                    String nome = result.getString("nome");
                    String cpf = result.getString("cpf");
                    int rg = result.getInt("rg");
                    String dataNascimento = result.getString("data_nascimento");
                    String endereco = result.getString("endereco");
                    String senhaHash = result.getString("senha_hash");
                    String salt = result.getString("salt");
                    String email = result.getString("email");
                    String telefone = result.getString("telefone");

                    return new Pessoa(idPessoa, nome, cpf, rg, dataNascimento, endereco, senhaHash, salt, email, telefone);
                } else {
                    throw new IdNotFoundException("Pessoa não encontrada");
                }
            }
        } catch (SQLException e) {
            // Tratar ou relançar a exceção, dependendo da sua estratégia
            throw new RuntimeException("Erro ao buscar pessoa por ID", e);
        }
    }

    // Método para listar todas as pessoas
    public List<Pessoa> listar() throws SQLException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM t_pessoa");

        ResultSet result = stm.executeQuery();
        List<Pessoa> pessoas = new ArrayList<>();

        while (result.next()) {
            int idPessoa = result.getInt("id_pessoa");
            String nome = result.getString("nome");
            String cpf = result.getString("cpf");
            int rg = result.getInt("rg");
            String dataNascimento = result.getString("data_nascimento");
            String endereco = result.getString("endereco");
            String senhaHash = result.getString("senha_hash");
            String salt = result.getString("salt");
            String email = result.getString("email");
            String telefone = result.getString("telefone");

            Pessoa pessoa = new Pessoa(idPessoa, nome, cpf, rg, dataNascimento, endereco, senhaHash, salt, email, telefone);
            pessoas.add(pessoa);
        }

        return pessoas;
    }

    // Método para deletar uma pessoa por ID
    public void deletar(int idPessoa) throws SQLException {
        PreparedStatement stm = conn.prepareStatement("DELETE FROM t_pessoa WHERE id_pessoa = ?");
        stm.setInt(1, idPessoa);

        stm.executeUpdate();
    }

    // Método para atualizar os dados de uma pessoa
    public void atualizar(Pessoa pessoa) throws SQLException {
        PreparedStatement stm = conn.prepareStatement("UPDATE t_pessoa SET nome = ?, cpf = ?, rg = ?, "
                + "data_nascimento = ?, endereco = ?, senha_hash = ?, salt = ?, email = ?, telefone = ? WHERE id_pessoa = ?");

        stm.setString(1, pessoa.getNome());
        stm.setString(2, pessoa.getCpf());
        stm.setInt(3, pessoa.getRg());
        stm.setString(4, pessoa.getDataNascimento());
        stm.setString(5, pessoa.getEndereco());
        stm.setString(6, pessoa.getSenhaHash());
        stm.setString(7, pessoa.getSalt());
        stm.setString(8, pessoa.getEmail());
        stm.setString(9, pessoa.getTelefone());
        stm.setInt(10, pessoa.getIdPessoa());

        stm.executeUpdate();
    }
}
