package br.hue.hue.inf008.kinkinmonitor.persistence;

import java.util.List;

public interface GenericDAO<T> {

	public List<T> listAll() throws Exception;

	public T findByNome(String nome) throws Exception;

	public int insert(T domain) throws Exception;

	public int update(T domain) throws Exception;

	public int delete(T domain) throws Exception;

}
