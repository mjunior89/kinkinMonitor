package br.hue.hue.inf008.kinkinmonitor.persistence;

import java.util.List;

public interface GenericDAO<T> {

	public List<T> listAll();

	public T findById(int id);

	public T findByQuery(String query);

	public int insert(T domain);

	public int update(T domain);

	public int delete(T domain);

}
