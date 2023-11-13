package br.com.bikeinsure.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Nome da classe do driver para o Oracle
    private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";

    // URL de conexão para o Oracle
    private static final String ORACLE_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    // Credenciais de acesso ao banco de dados Oracle
    private static final String USERNAME = "rm550897";
    private static final String PASSWORD = "100402";

    // Obtém uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(ORACLE_DRIVER);
            return DriverManager.getConnection(ORACLE_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // Trate ou propague a exceção conforme necessário
            throw new SQLException("Erro ao obter conexão com o banco de dados.", e);
        }
    }

    // Fecha a conexão com o banco de dados
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // Log ou trate a exceção, se necessário
                e.printStackTrace();
            }
        }
    }
}
