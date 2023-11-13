package br.com.bikeinsure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.model.Seguros;

public class SeguroDao {

    private Connection conn;

    public SeguroDao(Connection conn) {
        this.conn = conn;
    }

    // Método para cadastrar um seguro
    public void cadastrar(Seguros seguro) throws SQLException {
        PreparedStatement stm = conn.prepareStatement("INSERT INTO t_seguro "
                + "(cd_seguro, tipo_seguro, inicio_seguro, fim_seguro, status_seguro) VALUES (?, ?, ?, ?, ?)");

        stm.setInt(1, seguro.getCdSeguro());
        stm.setString(2, seguro.getTipoSeguro());
        stm.setString(3, seguro.getInicioSeguro());
        stm.setString(4, seguro.getFimSeguro());
        stm.setString(5, seguro.getStatusSeguro());

        stm.executeUpdate();
    }

    // Método para pesquisar um seguro por código
    public Seguros pesquisar(int cdSeguro) throws SQLException, IdNotFoundException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM t_seguro WHERE cd_seguro = ?");
        stm.setInt(1, cdSeguro);

        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new IdNotFoundException("Seguro não encontrado");
        }

        String tipoSeguro = result.getString("tipo_seguro");
        String inicioSeguro = result.getString("inicio_seguro");
        String fimSeguro = result.getString("fim_seguro");
        String statusSeguro = result.getString("status_seguro");

        Seguros seguro = new Seguros(cdSeguro, tipoSeguro, inicioSeguro, fimSeguro, statusSeguro);
        return seguro;
    }

    // Método para listar todos os seguros
    public List<Seguros> listarTodos() throws SQLException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM t_seguro");

        ResultSet result = stm.executeQuery();
        List<Seguros> seguros = new ArrayList<>();

        while (result.next()) {
            int cdSeguro = result.getInt("cd_seguro");
            String tipoSeguro = result.getString("tipo_seguro");
            String inicioSeguro = result.getString("inicio_seguro");
            String fimSeguro = result.getString("fim_seguro");
            String statusSeguro = result.getString("status_seguro");

            Seguros seguro = new Seguros(cdSeguro, tipoSeguro, inicioSeguro, fimSeguro, statusSeguro);
            seguros.add(seguro);
        }

        return seguros;
    }

    // Método para deletar um seguro por código
    public void deletar(int cdSeguro) throws SQLException {
        PreparedStatement stm = conn.prepareStatement("DELETE FROM t_seguro WHERE cd_seguro = ?");
        stm.setInt(1, cdSeguro);

        stm.executeUpdate();
    }

    // Método para atualizar os dados de um seguro
    public void atualizar(Seguros seguro) throws SQLException {
        PreparedStatement stm = conn.prepareStatement("UPDATE t_seguro SET tipo_seguro = ?, inicio_seguro = ?, "
                + "fim_seguro = ?, status_seguro = ? WHERE cd_seguro = ?");

        stm.setString(1, seguro.getTipoSeguro());
        stm.setString(2, seguro.getInicioSeguro());
        stm.setString(3, seguro.getFimSeguro());
        stm.setString(4, seguro.getStatusSeguro());
        stm.setInt(5, seguro.getCdSeguro());

        stm.executeUpdate();
    }
}
