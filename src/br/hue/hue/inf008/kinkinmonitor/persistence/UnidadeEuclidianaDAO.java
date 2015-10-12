package br.hue.hue.inf008.kinkinmonitor.persistence;

import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UnidadeEuclidianaDAO implements GenericDAO<UnidadeEuclidiana> {

	@Override
	public List<UnidadeEuclidiana> listAll() {
		List<UnidadeEuclidiana> undEuclidList = new ArrayList<>();
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM UNIDADE_EUCLIDIANA";
			rs = ds.executeQuery(query);
			while (rs.next()) {
				UnidadeEuclidiana undEuclid = new UnidadeEuclidiana();
				undEuclid.setId(rs.getInt("ID"));
				undEuclid.setHasCamera(rs.getBoolean("CAMERA"));
				undEuclid.setHasMedidorCH4(rs.getBoolean("MEDIDOR_CH4"));
				undEuclid.setHasMedidorCO2(rs.getBoolean("MEDIDOR_CO2"));
				undEuclid.setHasTermometro(rs.getBoolean("TERMOMETRO"));
				undEuclid.setLocalizacao(new PontoLocalizacao(rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE")));
				undEuclidList.add(undEuclid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(rs);
		}
		return undEuclidList;
	}

	@Override
	public UnidadeEuclidiana findById(int id) {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM UNIDADE_EUCLIDIANA WHERE ID=" + id;
			rs = ds.executeQuery(query);
			while (rs.next()) {
				UnidadeEuclidiana undEuclid = new UnidadeEuclidiana();
				undEuclid.setId(rs.getInt("ID"));
				undEuclid.setHasCamera(rs.getBoolean("CAMERA"));
				undEuclid.setHasMedidorCH4(rs.getBoolean("MEDIDOR_CH4"));
				undEuclid.setHasMedidorCO2(rs.getBoolean("MEDIDOR_CO2"));
				undEuclid.setHasTermometro(rs.getBoolean("TERMOMETRO"));
				undEuclid.setLocalizacao(new PontoLocalizacao(rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE")));
				return undEuclid;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close(rs);
		}
		return null;
	}

	@Override
	public UnidadeEuclidiana findByQuery(String query) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void insert(UnidadeEuclidiana unidadeEuclidiana) {
		Connection dbConnection = null;
		Statement statement = null;

		String sql = "insert into unidadeEuclidiana values(" + unidadeEuclidiana.getId() + ")";

		try {
			DataSource dataSource = new DataSource();
			dbConnection = dataSource.createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Record is inserted into UnidadeEuclidiana table for  UnidadeEuclidiana : " + unidadeEuclidiana.getId());

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void update(UnidadeEuclidiana unidadeEuclidiana) {
		Connection dbConnection = null;
		Statement statement = null;

		String sql = "update unidadeEuclidiana set name=" + "'" + unidadeEuclidiana.getId() + "'" + "where unidadeEuclidiana_id="
			+ unidadeEuclidiana.getId();

		try {
			DataSource dataSource = new DataSource();
			dbConnection = dataSource.createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Record is updated into UnidadeEuclidiana table for UnidadeEuclidiana id : " + unidadeEuclidiana.getId());

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@Override
	public void delete(UnidadeEuclidiana domain) {
		Connection dbConnection = null;
		Statement statement = null;

		String sql = "delete from unidadeEuclidiana where unidadeEuclidiana_Id=" + domain.getId();

		try {
			DataSource dataSource = new DataSource();
			dbConnection = dataSource.createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Record is deleted from UnidadeEuclidiana table for UnidadeEuclidiana id : " + domain.getId());

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
