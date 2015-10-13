package br.hue.hue.inf008.kinkinmonitor.persistence;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnidadeManhattanDAO implements GenericDAO<UnidadeManhattan> {

	@Override
	public List<UnidadeManhattan> listAll() {
		List<UnidadeManhattan> undManhList = new ArrayList<>();
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM UNIDADE_MANHATTAN";
			rs = ds.executeQuery(query);
			while (rs.next()) {
				UnidadeManhattan undManh = new UnidadeManhattan();
				undManh.setId(rs.getInt("ID"));
				undManh.setCamera(rs.getBoolean("CAMERA"));
				undManh.setMedidorCH4(rs.getBoolean("MEDIDOR_CH4"));
				undManh.setMedidorCO2(rs.getBoolean("MEDIDOR_CO2"));
				undManh.setTermometro(rs.getBoolean("TERMOMETRO"));
				undManh.setLocalizacao(new PontoLocalizacao(rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE")));
				undManh.setAreaMonitorada(new AreaMonitorada(rs.getInt("ID_AREA_MONITORADA"), null));
				undManhList.add(undManh);
			}
		} catch (SQLException e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Mensagem de exceção vem aqui!!", e);
		} finally {
			ds.close(rs);
		}
		return undManhList;
	}

	@Override
	public UnidadeManhattan findById(int id) {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM UNIDADE_MANHATTAN WHERE ID=" + id;
			rs = ds.executeQuery(query);
			while (rs.next()) {
				UnidadeManhattan undManh = new UnidadeManhattan();
				undManh.setId(rs.getInt("ID"));
				undManh.setCamera(rs.getBoolean("CAMERA"));
				undManh.setMedidorCH4(rs.getBoolean("MEDIDOR_CH4"));
				undManh.setMedidorCO2(rs.getBoolean("MEDIDOR_CO2"));
				undManh.setTermometro(rs.getBoolean("TERMOMETRO"));
				undManh.setLocalizacao(new PontoLocalizacao(rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE")));
				undManh.setAreaMonitorada(new AreaMonitorada(rs.getInt("ID_AREA_MONITORADA"), null));
				return undManh;
			}
		} catch (SQLException e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Mensagem de exceção vem aqui!!", e);
		} finally {
			ds.close(rs);
		}
		return null;
	}

	@Override
	public UnidadeManhattan findByQuery(String query) {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			rs = ds.executeQuery(query);
			while (rs.next()) {
				UnidadeManhattan undManh = new UnidadeManhattan();
				undManh.setId(rs.getInt("ID"));
				undManh.setCamera(rs.getBoolean("CAMERA"));
				undManh.setMedidorCH4(rs.getBoolean("MEDIDOR_CH4"));
				undManh.setMedidorCO2(rs.getBoolean("MEDIDOR_CO2"));
				undManh.setTermometro(rs.getBoolean("TERMOMETRO"));
				undManh.setLocalizacao(new PontoLocalizacao(rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE")));
				undManh.setAreaMonitorada(new AreaMonitorada(rs.getInt("ID_AREA_MONITORADA"), null));
				return undManh;
			}
		} catch (SQLException e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Mensagem de exceção vem aqui!!", e);
		} finally {
			ds.close(rs);
		}
		return null;
	}

	@Override
	public void insert(UnidadeManhattan unidadeManhattan) {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		unidadeManhattan.setId(ds.fetchNextIdSequence(UnidadeManhattan.SEQUENCE));
		try {
			String sql
				= "INSERT INTO UNIDADE_MANHATTAN (ID, CAMERA, MEDIDOR_CH4, MEDIDOR_CO2, TERMOMETRO, LATITUDE, LONGITUDE, ID_AREA_MONITORADA) VALUES("
				+ unidadeManhattan.getId()
				+ ", " + unidadeManhattan.isCamera()
				+ ", " + unidadeManhattan.isMedidorCH4()
				+ ", " + unidadeManhattan.isMedidorCO2()
				+ ", " + unidadeManhattan.isTermometro();
			if (unidadeManhattan.getLocalizacao() != null) {
				sql += ", " + unidadeManhattan.getLocalizacao().getLatitude()
					+ ", " + unidadeManhattan.getLocalizacao().getLongitude();
			} else {
				throw new Exception(); // Exception impedindo nullidade do campo
			}
			if (unidadeManhattan.getLocalizacao() != null) {
				sql += ", " + unidadeManhattan.getAreaMonitorada().getId();
			} else {
				throw new Exception(); // Exception impedindo nullidade do campo
			}
			sql += ")";
			ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Mensagem de exceção vem aqui!!", e);
		} finally {
			ds.close(rs);
		}
	}

	@Override
	public void update(UnidadeManhattan unidadeManhattan) {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		unidadeManhattan.setId(ds.fetchNextIdSequence(UnidadeManhattan.SEQUENCE));
		try {
			String sql
				= "UPDATE UNIDADE_MANHATTAN SET CAMERA = " + unidadeManhattan.isCamera()
				+ ", MEDIDOR_CH4 = " + unidadeManhattan.isMedidorCH4()
				+ ", MEDIDOR_CO2 = " + unidadeManhattan.isMedidorCO2()
				+ ", TERMOMETRO = " + unidadeManhattan.isTermometro();
			if (unidadeManhattan.getLocalizacao() != null) {
				sql += ", LATITUDE = " + unidadeManhattan.getLocalizacao().getLatitude()
					+ ", LONGITUDE = " + unidadeManhattan.getLocalizacao().getLongitude();
			} else {
				throw new Exception(); // Exception impedindo nullidade do campo
			}
			if (unidadeManhattan.getLocalizacao() != null) {
				sql += ", ID_AREA_MONITORADA = " + unidadeManhattan.getAreaMonitorada().getId();
			} else {
				throw new Exception(); // Exception impedindo nullidade do campo
			}
			sql += " WHERE ID + " + unidadeManhattan.getId() + ")";
			ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Mensagem de exceção vem aqui!!", e);
		} finally {
			ds.close(rs);
		}
	}

	@Override
	public void delete(UnidadeManhattan unidadeManhattan) {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String sql = "DELETE FROM UNIDADE_MANHATTAN WHERE ID=" + unidadeManhattan.getId();
			ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Mensagem de exceção vem aqui!!", e);
		} finally {
			ds.close(rs);
		}
	}

}
