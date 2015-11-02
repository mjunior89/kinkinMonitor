package br.hue.hue.inf008.kinkinmonitor.persistence;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnidadeEuclidianaDAO extends GenericDAO<UnidadeEuclidiana> {

	@Override
	public List<UnidadeEuclidiana> listAll() throws Exception {
		List<UnidadeEuclidiana> undEuclidList = new ArrayList<>();
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM UNIDADE_EUCLIDIANA";
			rs = ds.executeQuery(query);
			while (rs.next()) {
				UnidadeEuclidiana undEuclid = new UnidadeEuclidiana();
				undEuclid.setId(rs.getInt("ID"));
				undEuclid.setNome(rs.getString("NOME"));
				undEuclid.setCamera(rs.getBoolean("CAMERA"));
				undEuclid.setMedidorCH4(rs.getBoolean("MEDIDOR_CH4"));
				undEuclid.setMedidorCO2(rs.getBoolean("MEDIDOR_CO2"));
				undEuclid.setTermometro(rs.getBoolean("TERMOMETRO"));
				undEuclid.setLocalizacao(new PontoLocalizacao(rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE")));
				undEuclid.setAreaMonitorada(new AreaMonitorada(rs.getInt("ID_AREA_MONITORADA"), null));
				undEuclidList.add(undEuclid);
			}
		} catch (Exception e) {
			Logger.getLogger(UnidadeEuclidiana.class.getName()).log(Level.SEVERE, "Ocorreu um erro na listagem de todas as Unidades Euclidianas.", e);
			throw new Exception("Ocorreu um erro na listagem de todas as Unidades Euclidianas.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return undEuclidList;
	}

	@Override
	public UnidadeEuclidiana findById(String id) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM UNIDADE_EUCLIDIANA WHERE NOME=" + id;
			rs = ds.executeQuery(query);
			while (rs.next()) {
				UnidadeEuclidiana undEuclid = new UnidadeEuclidiana();
				undEuclid.setId(rs.getInt("ID"));
				undEuclid.setNome(rs.getString("NOME"));
				undEuclid.setCamera(rs.getBoolean("CAMERA"));
				undEuclid.setMedidorCH4(rs.getBoolean("MEDIDOR_CH4"));
				undEuclid.setMedidorCO2(rs.getBoolean("MEDIDOR_CO2"));
				undEuclid.setTermometro(rs.getBoolean("TERMOMETRO"));
				undEuclid.setLocalizacao(new PontoLocalizacao(rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE")));
				undEuclid.setAreaMonitorada(new AreaMonitorada(rs.getInt("ID_AREA_MONITORADA"), null));
				return undEuclid;
			}
		} catch (Exception e) {
			Logger.getLogger(UnidadeEuclidiana.class.getName()).log(Level.SEVERE, "Ocorreu um erro na consulta dessa Unidade Euclidiana.", e);
			throw new Exception("Ocorreu um erro na consulta dessa Unidade Euclidiana.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return null;
	}

	@Override
	public int insert(UnidadeEuclidiana unidadeEuclidiana) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		int retorno = 0;
		try {
			unidadeEuclidiana.setId(ds.fetchNextIdSequence(UnidadeEuclidiana.SEQUENCE));
			String sql
				= "INSERT INTO UNIDADE_EUCLIDIANA (ID, NOME, CAMERA, MEDIDOR_CH4, MEDIDOR_CO2, TERMOMETRO, LATITUDE, LONGITUDE, ID_AREA_MONITORADA) VALUES("
				+ unidadeEuclidiana.getId()
				+ ", " + unidadeEuclidiana.getNome()
				+ ", " + unidadeEuclidiana.isCamera()
				+ ", " + unidadeEuclidiana.isMedidorCH4()
				+ ", " + unidadeEuclidiana.isMedidorCO2()
				+ ", " + unidadeEuclidiana.isTermometro();
			if (unidadeEuclidiana.getLocalizacao() != null) {
				sql += ", " + unidadeEuclidiana.getLocalizacao().getLatitude()
					+ ", " + unidadeEuclidiana.getLocalizacao().getLongitude();
			} else {
				throw new Exception(); // Exception impedindo nullidade do campo
			}
			if (unidadeEuclidiana.getLocalizacao() != null) {
				sql += ", " + unidadeEuclidiana.getAreaMonitorada().getId();
			} else {
				throw new Exception(); // Exception impedindo nullidade do campo
			}
			sql += ")";
			retorno = ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(UnidadeEuclidiana.class.getName()).log(Level.SEVERE, "Ocorreu um erro na criação dessa Unidade Euclidiana.", e);
			throw new Exception("Ocorreu um erro na criação dessa Unidade Euclidiana.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return retorno;
	}

	@Override
	public int update(UnidadeEuclidiana unidadeEuclidiana) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		int retorno = 0;
		unidadeEuclidiana.setId(ds.fetchNextIdSequence(UnidadeEuclidiana.SEQUENCE));
		try {
			String sql
				= "UPDATE UNIDADE_EUCLIDIANA SET NOME = " + unidadeEuclidiana.getNome()
				+ ", CAMERA = " + unidadeEuclidiana.isCamera()
				+ ", MEDIDOR_CH4 = " + unidadeEuclidiana.isMedidorCH4()
				+ ", MEDIDOR_CO2 = " + unidadeEuclidiana.isMedidorCO2()
				+ ", TERMOMETRO = " + unidadeEuclidiana.isTermometro();
			if (unidadeEuclidiana.getLocalizacao() != null) {
				sql += ", LATITUDE = " + unidadeEuclidiana.getLocalizacao().getLatitude()
					+ ", LONGITUDE = " + unidadeEuclidiana.getLocalizacao().getLongitude();
			} else {
				throw new Exception(); // Exception impedindo nullidade do campo
			}
			if (unidadeEuclidiana.getLocalizacao() != null) {
				sql += ", ID_AREA_MONITORADA = " + unidadeEuclidiana.getAreaMonitorada().getId();
			} else {
				throw new Exception(); // Exception impedindo nullidade do campo
			}
			sql += " WHERE ID = " + unidadeEuclidiana.getId() + ")";
			retorno = ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(UnidadeEuclidiana.class.getName()).log(Level.SEVERE, "Ocorreu um erro na atualização dessa Unidade Euclidiana.", e);
			throw new Exception("Ocorreu um erro na atualização dessa Unidade Euclidiana.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return retorno;
	}

	@Override
	public int delete(UnidadeEuclidiana unidadeEuclidiana) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		int retorno = 0;
		try {
			String sql = "DELETE FROM UNIDADE_EUCLIDIANA WHERE ID=" + unidadeEuclidiana.getId();
			retorno = ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(UnidadeEuclidiana.class.getName()).log(Level.SEVERE, "Ocorreu um erro na exclusão dessa Unidade Euclidiana.", e);
			throw new Exception("Ocorreu um erro na exclusão dessa Unidade Euclidiana.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return retorno;
	}

}
