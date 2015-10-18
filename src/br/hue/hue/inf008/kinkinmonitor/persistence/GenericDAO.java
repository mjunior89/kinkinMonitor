package br.hue.hue.inf008.kinkinmonitor.persistence;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {

	public List<T> listAll() throws SQLException;

	public T findById(int id) throws SQLException;

	public T findByQuery(String query) throws SQLException;

	public int insert(T domain) throws SQLException;

	public int update(T domain) throws SQLException;

	public int delete(T domain) throws SQLException;

}
