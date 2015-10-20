package br.hue.hue.inf008.kinkinmonitor.persistence;

import java.sql.SQLException;
import java.util.List;

public abstract class GenericDAO<T> {

	public abstract List<T> listAll() throws SQLException;

	public abstract T findById(int id) throws SQLException;

	public abstract T findByQuery(String query) throws SQLException;

	public abstract int insert(T domain) throws SQLException;

	public abstract int update(T domain) throws SQLException;

	public abstract int delete(T domain) throws SQLException;

}
