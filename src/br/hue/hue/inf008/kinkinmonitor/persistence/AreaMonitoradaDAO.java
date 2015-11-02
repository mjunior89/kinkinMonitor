package br.hue.hue.inf008.kinkinmonitor.persistence;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AreaMonitoradaDAO extends GenericDAO<AreaMonitorada> {

	@Override
	public List<AreaMonitorada> listAll() throws Exception {
		List<AreaMonitorada> areaMonList = new ArrayList<>();
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM AREA_MONITORADA";
			rs = ds.executeQuery(query);
			while (rs.next()) {
				AreaMonitorada areaMon = new AreaMonitorada();
				areaMon.setId(rs.getInt("ID"));
				areaMon.setNome(rs.getString("NOME"));
				areaMonList.add(areaMon);
			}
		} catch (Exception e) {
			Logger.getLogger(AreaMonitorada.class.getName()).log(Level.SEVERE, "Ocorreu um erro na listagem de todas as Áreas Monitoradas.", e);
			throw new Exception("Ocorreu um erro na listagem de todas as Áreas Monitoradas.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return areaMonList;
	}

	@Override
	public AreaMonitorada findById(String id) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM AREA_MONITORADA WHERE NOME=" + id;
			rs = ds.executeQuery(query);
			while (rs.next()) {
				AreaMonitorada areaMon = new AreaMonitorada();
				areaMon.setId(rs.getInt("ID"));
				areaMon.setNome(rs.getString("NOME"));
				return areaMon;
			}
		} catch (Exception e) {
			Logger.getLogger(AreaMonitorada.class.getName()).log(Level.SEVERE, "Ocorreu um erro na consulta dessa Área Monitorada.", e);
			throw new Exception("Ocorreu um erro na consulta dessa Área Monitorada.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return null;
	}

	@Override
	public int insert(AreaMonitorada areaMonitorada) throws Exception {
		DataSource ds = new DataSource();
		int retorno = 0;
		try {
			areaMonitorada.setId(ds.fetchNextIdSequence(AreaMonitorada.SEQUENCE));
			String sql
				= "INSERT INTO AREA_MONITORADA (ID, NOME) VALUES("
				+ areaMonitorada.getId()
				+ ", '" + areaMonitorada.getNome()
				+ "')";
			retorno = ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(AreaMonitorada.class.getName()).log(Level.SEVERE, "Ocorreu um erro na criação dessa Área Monitorada.", e);
			throw new Exception("Ocorreu um erro na criação dessa Área Monitorada.", e);
		} finally {
			ds.closeConnection();
		}
		return retorno;
	}

	@Override
	public int update(AreaMonitorada areaMonitorada) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		int retorno = 0;
		areaMonitorada.setId(ds.fetchNextIdSequence(AreaMonitorada.SEQUENCE));
		try {
			String sql
				= "UPDATE AREA_MONITORADA SET NOME = '" + areaMonitorada.getNome() + "'"
				+ " WHERE ID = " + areaMonitorada.getId() + ")";
			retorno = ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(AreaMonitorada.class.getName()).log(Level.SEVERE, "Ocorreu um erro na atualização dessa Área Monitorada.", e);
			throw new Exception("Ocorreu um erro na atualização dessa Área Monitorada.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return retorno;
	}

	@Override
	public int delete(AreaMonitorada areaMonitorada) throws Exception {
		DataSource ds = new DataSource();
		ResultSet rs = null;
		int retorno = 0;
		try {
			String sql = "DELETE FROM AREA_MONITORADA WHERE ID=" + areaMonitorada.getId();
			retorno = ds.executeUpdate(sql);
		} catch (Exception e) {
			Logger.getLogger(AreaMonitorada.class.getName()).log(Level.SEVERE, "Ocorreu um erro na exclusão dessa Área Monitorada.", e);
			throw new Exception("Ocorreu um erro na exclusão dessa Área Monitorada.", e);
		} finally {
			ds.closeResultSet(rs);
		}
		return retorno;
	}

}
