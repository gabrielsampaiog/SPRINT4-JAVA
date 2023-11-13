package br.com.bikeinsure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.bikeinsure.exception.IdNotFoundException;
import br.com.bikeinsure.model.Bike;

public class BikeDao {

	private Connection conn;

	public BikeDao(Connection conn) {
		this.conn = conn;
	}

	 // Método para pesquisar uma bike pelo código
	public Bike pesquisar(int codigo) throws SQLException, IdNotFoundException {
		// Preparação da consulta SQL para buscar uma bike pelo código
		PreparedStatement stm = conn.prepareStatement("select * from t_bike where id = ?");
		stm.setInt(1, codigo);

		// Execução da consulta
		ResultSet result = stm.executeQuery();

		// Verificação se a bike foi encontrada
		if (!result.next()) {
			throw new IdNotFoundException("Bike não encontrada");
		}

		// Recuperação dos dados da bike do ResultSet
		String nomeBike = result.getString("nome_bike");
		double preco = result.getDouble("preco");
		String cor = result.getString("cor");
		String tamanho = result.getString("tamanho");
		String marca = result.getString("marca");
		String personalizada = result.getString("personalizada");
		// Adição das colunas necessárias para inicializar o objeto Modelo
		String nomeModelo = result.getString("nome_modelo");
		String descricaoModelo = result.getString("descricao_modelo");
		int bikeId = result.getInt("bikeId");

		// Criação do objeto Bike com os dados recuperados
		Bike bike = new Bike(bikeId, nomeBike, preco, cor, nomeModelo, descricaoModelo, tamanho, marca,personalizada);
		return bike;
	}

	 // Método para cadastrar uma bike no banco de dados
	public void cadastrar(Bike bike) throws SQLException {
		// Preparação da consulta SQL para cadastrar uma bike no banco de dados
		PreparedStatement stm = conn.prepareStatement("insert into t_bike "
				+ "(id, nome_bike, preco, cor, nome_modelo, descricao_modelo, tamanho, marca, personalizada) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

		// Definição dos parâmetros da consulta com os dados da bike
		stm.setInt(1, bike.getbikeId());
		stm.setString(2, bike.getNomeBike());
		stm.setDouble(3, bike.getPreco());
		stm.setString(4, bike.getCor());
		stm.setString(5, bike.getNomeModelo());
		stm.setString(6, bike.getDescricaoModelo());
		stm.setString(7, bike.getTamanho());
		stm.setString(8, bike.getMarca());
		stm.setString(9, bike.getPersonalizada());

		// Execução da consulta de inserção
		stm.executeUpdate();
	}

	// Método para deletar uma bike pelo código
	public void deletar(int bikeId) throws SQLException {
		String sql = "DELETE FROM t_bike WHERE bikeId = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, bikeId);
			ps.executeUpdate();
		}
	}

	// Método para alterar os dados de uma bike
	public String alterar(Bike bike) {
		String sql = "update t_bike set nome_bike=?, preco=?, cor=?, nome_modelo=?, descricao_modelo=?, tamanho=?, marca=?, personalizada=? where bikeId=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bike.getNomeBike());
			ps.setDouble(2, bike.getPreco());
			ps.setString(3, bike.getCor());
			ps.setString(4, bike.getNomeModelo());
			ps.setString(5, bike.getDescricaoModelo());
			ps.setString(6, bike.getTamanho());
			ps.setString(7, bike.getMarca());
			ps.setString(8, bike.getPersonalizada());
			ps.setInt(9, bike.getbikeId());

			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Método para retornar todos os dados das bikes
	public ArrayList<Bike> retornarDados() {
		String sql = "select * from t_bike";
		ArrayList<Bike> retornarBikes = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String nomeBike = rs.getString("nome_bike");
					double preco = rs.getDouble("preco");
					String cor = rs.getString("cor");
					String tamanho = rs.getString("tamanho");
					String marca = rs.getString("marca");
					String personalizada = rs.getString("personalizada");
					String nomeModelo = rs.getString("nome_modelo");
					String descricaoModelo = rs.getString("descricao_modelo");
					int bikeId = rs.getInt("bikeId");

					Bike bike = new Bike(bikeId, nomeBike, preco, cor, nomeModelo, descricaoModelo, tamanho, marca,
							personalizada);
					retornarBikes.add(bike);
				}
				return retornarBikes;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
