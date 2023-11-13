package br.com.bikeinsure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.model.Colaborador;

public class ColaboradorDao {

    private Connection conn;

    // Construtor que recebe uma conexão ao banco de dados
    public ColaboradorDao(Connection conn) {
        this.conn = conn;
    }

    // Método para pesquisar um colaborador pelo ID
    public Colaborador pesquisar(int idColaborador) throws SQLException, IdNotFoundException {
        // Preparação da consulta SQL para buscar um colaborador pelo ID
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM t_colaborador WHERE id_colaborador = ?");
        stm.setInt(1, idColaborador);

        // Execução da consulta
        ResultSet result = stm.executeQuery();

        // Verificação se o colaborador foi encontrado
        if (!result.next()) {
            throw new IdNotFoundException("Colaborador não encontrado");
        }

        // Recuperação dos dados do colaborador do ResultSet
        String nome = result.getString("nome");
        String salt = result.getString("salt");
        String senhaHash = result.getString("senha_hash");

        // Criação do objeto Colaborador com os dados recuperados
        Colaborador colaborador = new Colaborador(idColaborador, nome, senhaHash, salt);

        return colaborador;
    }

    // Método para cadastrar um colaborador no banco de dados
    public void cadastrar(Colaborador colaborador) throws SQLException {
        // Preparação da consulta SQL para cadastrar um colaborador no banco de dados
        PreparedStatement stm = conn.prepareStatement("INSERT INTO t_colaborador "
                + "(id_colaborador, nome, senha_hash, salt) VALUES (?, ?, ?, ?)");

        // Definição dos parâmetros da consulta com os dados do colaborador
        stm.setInt(1, colaborador.getIdColaborador());
        stm.setString(2, colaborador.getNome());
        stm.setString(3, colaborador.getSenhaHash());
        stm.setString(4, colaborador.getSalt());

        // Execução da consulta de inserção
        stm.executeUpdate();
    }

    // Método para deletar um colaborador pelo ID
    public void deletar(int idColaborador) throws SQLException {
        // Preparação da consulta SQL para deletar um colaborador pelo ID
        PreparedStatement stm = conn.prepareStatement("DELETE FROM t_colaborador WHERE id_colaborador = ?");
        stm.setInt(1, idColaborador);

        // Execução da consulta de exclusão
        stm.executeUpdate();
    }

    // Método para atualizar os dados de um colaborador
    public void atualizar(Colaborador colaborador) throws SQLException {
        // Preparação da consulta SQL para atualizar um colaborador pelo ID
        PreparedStatement stm = conn.prepareStatement("UPDATE t_colaborador SET nome = ?, senha_hash = ?, salt = ? WHERE id_colaborador = ?");

        // Definição dos parâmetros da consulta com os dados do colaborador
        stm.setString(1, colaborador.getNome());
        stm.setString(2, colaborador.getSenhaHash());
        stm.setString(3, colaborador.getSalt());
        stm.setInt(4, colaborador.getIdColaborador());

        // Execução da consulta de atualização
        stm.executeUpdate();
    }

    // Método para listar todos os colaboradores
    public List<Colaborador> listarTodos() throws SQLException {
        // Preparação da consulta SQL para listar todos os colaboradores
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM t_colaborador");

        // Execução da consulta
        ResultSet result = stm.executeQuery();
        List<Colaborador> colaboradores = new ArrayList<>();

        // Iteração sobre os resultados e adição à lista
        while (result.next()) {
            int idColaborador = result.getInt("id_colaborador");
            String nome = result.getString("nome");
            String salt = result.getString("salt");
            String senhaHash = result.getString("senha_hash");

            Colaborador colaborador = new Colaborador(idColaborador, nome, senhaHash, salt);
            colaboradores.add(colaborador);
        }

        return colaboradores;
    }


}
