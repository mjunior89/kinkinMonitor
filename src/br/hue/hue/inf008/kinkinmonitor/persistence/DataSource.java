package br.hue.hue.inf008.kinkinmonitor.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSource {

	private Connection connection = null;

	public Connection createConnection() {
		try {
			// Verifica a existência da classe responsável pelo drive de conexão do postgresql
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/kinkin_monitor";
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "123456");
			connection = DriverManager.getConnection(url, props);
		} catch (ClassNotFoundException | SQLException e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, e);
		}
		return connection;
	}

	public ResultSet executeQuery(String query) {
		try {
			Connection con = this.createConnection();
			Statement stmt = con.createStatement();
			return stmt.executeQuery(query);
		} catch (SQLException e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public int executeUpdate(String query) {
		try {
			Connection con = this.createConnection();
			Statement stmt = con.createStatement();
			return stmt.executeUpdate(query);
		} catch (SQLException e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao executar esta operação", e);
		}
		return 0;
	}

	void close(ResultSet rs) {
		try {
			if (rs != null) {
				if (rs.getStatement() != null) {
					if (rs.getStatement().getConnection() != null) {
						rs.getStatement().getConnection().close();
					}
					rs.getStatement().close();
				}
				rs.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao tentar fechar a conexão JDBC", ex);
		}
	}

	public void initDataBase() {
		String sqlInit
			= "CREATE SEQUENCE \"SQ_UNIDADE_EUCLIDIANA\" START 1;\n"
			+ "CREATE SEQUENCE \"SQ_UNIDADE_MANHATAN\" START 1;\n";
		this.executeUpdate(sqlInit);
	}

}
