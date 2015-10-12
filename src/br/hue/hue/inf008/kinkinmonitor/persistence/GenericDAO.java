package br.hue.hue.inf008.kinkinmonitor.persistence;

import java.util.List;

public interface GenericDAO<T> {

	public List<T> listAll();

	public T findById(int id);

	public T findByQuery(String query);

	public void insert(T domain);

	public void update(T domain);

	public void delete(T domain);

}
