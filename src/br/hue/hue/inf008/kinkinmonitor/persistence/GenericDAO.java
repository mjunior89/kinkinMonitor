package br.hue.hue.inf008.kinkinmonitor.persistence;

import java.util.List;

public abstract class GenericDAO<T> {

	public abstract List<T> listAll() throws Exception;

	public abstract T findById(String id) throws Exception;

	public abstract int insert(T domain) throws Exception;

	public abstract int update(T domain) throws Exception;

	public abstract int delete(T domain) throws Exception;

}
