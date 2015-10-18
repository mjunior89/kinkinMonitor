package br.hue.hue.inf008.kinkinmonitor.persistence;

import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
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
		int resultado = 0;
		try {
			Connection con = this.createConnection();
			Statement stmt = con.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.getConnection().close();
			stmt.close();
		} catch (SQLException e) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao executar esta operação", e);
		}
		return resultado;
	}

	public void closeResultSet(ResultSet rs) {
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

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao tentar fechar a conexão JDBC", ex);
		}
	}

	public int fetchNextIdSequence(String seqName) {
		int idValue = 0;
		ResultSet rs = null;
		try {
			String query = "SELECT NEXTVAL('" + seqName + "') as ID_VAL";
			rs = this.executeQuery(query);
			while (rs.next()) {
				idValue = rs.getInt("ID_VAL");
			}
		} catch (Exception ex) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao tentar buscar o próximo valor da sequence: " + seqName + ".", ex);
		} finally {
			this.closeResultSet(rs);
		}
		return idValue;
	}

	public void initDataBase() {
		boolean check = verifyExistingDatatable();
		if (!check) {
			String sqlInit
				= "CREATE SEQUENCE SQ_UNIDADE_EUCLIDIANA START 1;\n"
				+ "CREATE SEQUENCE SQ_UNIDADE_MANHATTAN START 1;\n"
				+ "CREATE SEQUENCE SQ_AREA_MONITORADA START 1;\n"
				+ "CREATE TABLE AREA_MONITORADA(\n"
				+ "  ID INTEGER NOT NULL,\n"
				+ "  NOME VARCHAR(250) NOT NULL,\n"
				+ "  PRIMARY KEY (ID));\n"
				+ "CREATE TABLE UNIDADE_EUCLIDIANA(\n"
				+ "  ID INTEGER NOT NULL,\n"
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
		}
	}

	private boolean verifyExistingDatatable() {
		String sqlVerify = "SELECT 1 AS RESULT FROM PG_TABLES WHERE TABLENAME ILIKE('AREA_MONITORADA')";
		DataSource ds = new DataSource();
		ResultSet rs = null;
		boolean check = false;
		try {
			rs = ds.executeQuery(sqlVerify);
			while (rs.next()) {
				check = true;
			}
		} catch (SQLException e) {
			Logger.getLogger(UnidadeEuclidiana.class.getName()).log(Level.SEVERE, "Mensagem de exceção vem aqui!!", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return check;
	}

}
