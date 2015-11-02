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

	public Connection createConnection() throws Exception {
		try {
			// Verifica a existência da classe responsável pelo drive de conexão do postgresql
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/kinkin_monitor";
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "123456");
			connection = DriverManager.getConnection(url, props);
		} catch (ClassNotFoundException | SQLException e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao tentar conectar com a base de dados.", e);
			throw new Exception("Ocorreu um erro ao tentar conectar com a base de dados.", e);
		}
		return connection;
	}

	public ResultSet executeQuery(String query) throws Exception {
		try {
			this.createConnection();
			Statement stmt = connection.createStatement();
			return stmt.executeQuery(query);
		} catch (SQLException e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao executar esta consulta na 'Base de dados'.", e);
			throw new Exception("Ocorreu um erro ao executar esta consulta na 'Base de dados'.", e);
		}
	}

	public int executeUpdate(String query) throws Exception {
		int resultado = 0;
		Statement stmnt = null;
		try {
			this.createConnection();
			stmnt = connection.createStatement();
			resultado = stmnt.executeUpdate(query);
		} catch (SQLException e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao executar esta operação na 'Base de dados'.", e);
			throw new Exception("Ocorreu um erro ao executar esta operação na 'Base de dados'.", e);
		} finally {
			closeStatement(stmnt);
		}
		return resultado;
	}

	public void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				closeStatement(rs.getStatement());
				rs.close();
			}
		} catch (Exception e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao tentar fechar a conexão com a 'Base de dados'.", e);
		}
	}

	private void closeStatement(Statement stmnt) throws Exception {
		try {
			if (stmnt != null) {
				if (stmnt.getConnection() != null && !stmnt.getConnection().isClosed()) {
					stmnt.getConnection().close();
				}
				stmnt.close();
			}
		} catch (Exception e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao tentar fechar a conexão com a 'Base de dados'.", e);
			throw new Exception("Ocorreu um erro ao tentar fechar a conexão com a 'Base de dados'.", e);
		}
	}

	public void closeConnection() throws Exception {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao tentar fechar a conexão com a 'Base de dados'.", e);
			throw new Exception("Ocorreu um erro ao tentar fechar a conexão com a 'Base de dados'.", e);
		}
	}

	public int fetchNextIdSequence(String seqName) throws Exception {
		int idValue = 0;
		ResultSet rs = null;
		try {
			String query = "SELECT NEXTVAL('" + seqName + "') as ID_VAL";
			rs = this.executeQuery(query);
			while (rs.next()) {
				idValue = rs.getInt("ID_VAL");
			}
		} catch (SQLException e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao tentar buscar o próximo valor da sequence: " + seqName + ".", e);
			throw new Exception("Ocorreu um erro ao tentar buscar o próximo valor da sequence: " + seqName + ".", e);
		} finally {
			this.closeResultSet(rs);
		}
		return idValue;
	}

	public void initDataBase() throws Exception {
		boolean create = true;
		if (create) {
			try {
				String sqlInit
					= "DROP SCHEMA IF EXISTS public CASCADE;\n"
					+ "CREATE SCHEMA public AUTHORIZATION postgres;"
					+ "CREATE SEQUENCE SQ_UNIDADE_EUCLIDIANA START 1;\n"
					+ "CREATE SEQUENCE SQ_UNIDADE_MANHATTAN START 1;\n"
					+ "CREATE SEQUENCE SQ_AREA_MONITORADA START 1;\n"
					+ "CREATE TABLE AREA_MONITORADA(\n"
					+ "  ID INTEGER NOT NULL,\n"
					+ "  NOME VARCHAR(250) NOT NULL,\n"
					+ "  PRIMARY KEY (ID));\n"
					+ "CREATE TABLE UNIDADE_EUCLIDIANA(\n"
					+ "  ID INTEGER NOT NULL,\n"
					+ "  NOME VARCHAR(250) NOT NULL,\n"
					+ "  CAMERA BOOLEAN NOT NULL,\n"
					+ "  MEDIDOR_CH4 BOOLEAN NOT NULL,\n"
					+ "  MEDIDOR_CO2 BOOLEAN NOT NULL,\n"
					+ "  TERMOMETRO BOOLEAN NOT NULL,\n"
					+ "  LATITUDE NUMERIC NOT NULL DEFAULT 0,\n"
					+ "  LONGITUDE NUMERIC NOT NULL DEFAULT 0,\n"
					+ "  ID_AREA_MONITORADA INTEGER NOT NULL,\n"
					+ "  PRIMARY KEY (ID),\n"
					+ "  FOREIGN KEY (ID_AREA_MONITORADA) REFERENCES AREA_MONITORADA (ID));\n"
					+ "CREATE TABLE UNIDADE_MANHATTAN(\n"
					+ "  ID INTEGER NOT NULL,\n"
					+ "  NOME VARCHAR(250) NOT NULL,\n"
					+ "  CAMERA BOOLEAN NOT NULL,\n"
					+ "  MEDIDOR_CH4 BOOLEAN NOT NULL,\n"
					+ "  MEDIDOR_CO2 BOOLEAN NOT NULL,\n"
					+ "  TERMOMETRO BOOLEAN NOT NULL,\n"
					+ "  LATITUDE NUMERIC NOT NULL DEFAULT 0,\n"
					+ "  LONGITUDE NUMERIC NOT NULL DEFAULT 0,\n"
					+ "  ID_AREA_MONITORADA INTEGER NOT NULL,\n"
					+ "  PRIMARY KEY (ID),\n"
					+ "  FOREIGN KEY (ID_AREA_MONITORADA) REFERENCES AREA_MONITORADA (ID));";
				this.executeUpdate(sqlInit);
			} catch (Exception e) {
				Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao tentar inicializar a 'Base de dados'.", e);
				throw new Exception("Ocorreu um erro ao tentar inicializar a 'Base de dados'.", e);
			}
		}
	}

}
