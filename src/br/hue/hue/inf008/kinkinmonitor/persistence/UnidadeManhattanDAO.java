package br.hue.hue.inf008.kinkinmonitor.persistence;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnidadeManhattanDAO extends GenericDAO<UnidadeManhattan> {

	@Override
	public List<UnidadeManhattan> listAll() throws Exception {
		List<UnidadeManhattan> undManhList = new ArrayList<>();
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM UNIDADE_MANHATTAN";
			rs = ds.executeQuery(query);
			while (rs.next()) {
				UnidadeManhattan undManh = new UnidadeManhattan();
				undManh.setId(rs.getInt("ID"));
				undManh.setNome(rs.getString("NOME"));
				undManh.setCamera(rs.getBoolean("CAMERA"));
				undManh.setMedidorCH4(rs.getBoolean("MEDIDOR_CH4"));
				undManh.setMedidorCO2(rs.getBoolean("MEDIDOR_CO2"));
				undManh.setTermometro(rs.getBoolean("TERMOMETRO"));
				undManh.setLocalizacao(new PontoLocalizacao(rs.getInt("LATITUDE"), rs.getInt("LONGITUDE")));
				undManh.setAreaMonitorada(new AreaMonitorada(rs.getInt("ID_AREA_MONITORADA"), null));
				undManhList.add(undManh);
			}
		} catch (Exception e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Ocorreu um erro na listagem de todas as Unidades Manhattans.", e);
			throw new Exception("Ocorreu um erro na listagem de todas as Unidades Manhattans.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return undManhList;
	}

	public List<UnidadeManhattan> listAllByAreaMonitorada(AreaMonitorada area) throws Exception {
		List<UnidadeManhattan> undManhList = new ArrayList<>();
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM UNIDADE_MANHATTAN WHERE ID_AREA_MONITORADA = " + area.getId();
			rs = ds.executeQuery(query);
			while (rs.next()) {
				UnidadeManhattan undManh = new UnidadeManhattan();
				undManh.setId(rs.getInt("ID"));
				undManh.setNome(rs.getString("NOME"));
				undManh.setCamera(rs.getBoolean("CAMERA"));
				undManh.setMedidorCH4(rs.getBoolean("MEDIDOR_CH4"));
				undManh.setMedidorCO2(rs.getBoolean("MEDIDOR_CO2"));
				undManh.setTermometro(rs.getBoolean("TERMOMETRO"));
				undManh.setLocalizacao(new PontoLocalizacao(rs.getInt("LATITUDE"), rs.getInt("LONGITUDE")));
				undManh.setAreaMonitorada(new AreaMonitorada(rs.getInt("ID_AREA_MONITORADA"), null));
				undManhList.add(undManh);
			}
		} catch (Exception e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Ocorreu um erro na listagem de todas as Unidades Manhattans.", e);
			throw new Exception("Ocorreu um erro na listagem de todas as Unidades Manhattans.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return undManhList;
	}

	@Override
	public UnidadeManhattan findByNome(String nome) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM UNIDADE_MANHATTAN WHERE NOME='" + nome + "'";
			rs = ds.executeQuery(query);
			while (rs.next()) {
				UnidadeManhattan undManh = new UnidadeManhattan();
				undManh.setId(rs.getInt("ID"));
				undManh.setNome(rs.getString("NOME"));
				undManh.setCamera(rs.getBoolean("CAMERA"));
				undManh.setMedidorCH4(rs.getBoolean("MEDIDOR_CH4"));
				undManh.setMedidorCO2(rs.getBoolean("MEDIDOR_CO2"));
				undManh.setTermometro(rs.getBoolean("TERMOMETRO"));
				undManh.setLocalizacao(new PontoLocalizacao(rs.getInt("LATITUDE"), rs.getInt("LONGITUDE")));
				undManh.setAreaMonitorada(new AreaMonitorada(rs.getInt("ID_AREA_MONITORADA"), null));
				return undManh;
			}
		} catch (Exception e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Ocorreu um erro na consulta dessa Unidade Manhattan.", e);
			throw new Exception("Ocorreu um erro na consulta dessa Unidade Manhattan.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return null;
	}

	@Override
	public int insert(UnidadeManhattan unidadeManhattan) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		int retorno = 0;
		unidadeManhattan.setId(ds.fetchNextIdSequence(UnidadeManhattan.SEQUENCE));
		try {
			String sql
				= "INSERT INTO UNIDADE_MANHATTAN (ID, NOME, CAMERA, MEDIDOR_CH4, MEDIDOR_CO2, TERMOMETRO, LATITUDE, LONGITUDE, ID_AREA_MONITORADA) VALUES("
				+ unidadeManhattan.getId()
				+ ", '" + unidadeManhattan.getNome() + "'"
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
			retorno = ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Ocorreu um erro na criação dessa Unidade Manhattan.", e);
			throw new Exception("Ocorreu um erro na criação dessa Unidade Manhattan.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return retorno;
	}

	@Override
	public int update(UnidadeManhattan unidadeManhattan) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		int retorno = 0;
		try {
			String sql
				= "UPDATE UNIDADE_MANHATTAN SET NOME = '" + unidadeManhattan.getNome() + "'"
				+ ", CAMERA = " + unidadeManhattan.isCamera()
				+ ", MEDIDOR_CH4 = " + unidadeManhattan.isMedidorCH4()
				+ ", MEDIDOR_CO2 = " + unidadeManhattan.isMedidorCO2()
				+ ", TERMOMETRO = " + unidadeManhattan.isTermometro();
			if (unidadeManhattan.getLocalizacao() != null) {
				sql += ", LATITUDE = " + unidadeManhattan.getLocalizacao().getLatitude()
					+ ", LONGITUDE = " + unidadeManhattan.getLocalizacao().getLongitude();
			} else {
				throw new Exception(); // Exception impedindo nullidade do campo
			}
			if (unidadeManhattan.getAreaMonitorada() != null) {
				sql += ", ID_AREA_MONITORADA = " + unidadeManhattan.getAreaMonitorada().getId();
			} else {
				throw new Exception(); // Exception impedindo nullidade do campo
			}
			sql += " WHERE ID = " + unidadeManhattan.getId();
			retorno = ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Ocorreu um erro na atualização dessa Unidade Manhattan.", e);
			throw new Exception("Ocorreu um erro na atualização dessa Unidade Manhattan.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return retorno;
	}

	@Override
	public int delete(UnidadeManhattan unidadeManhattan) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		int retorno = 0;
		try {
			String sql = "DELETE FROM UNIDADE_MANHATTAN WHERE ID=" + unidadeManhattan.getId();
			retorno = ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(UnidadeManhattan.class.getName()).log(Level.SEVERE, "Ocorreu um erro na exclusão dessa Unidade Manhattan.", e);
			throw new Exception("Ocorreu um erro na exclusão dessa Unidade Manhattan.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return retorno;
	}

}
