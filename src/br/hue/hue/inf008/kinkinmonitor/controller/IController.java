package br.hue.hue.inf008.kinkinmonitor.controller;

import java.util.List;

public interface IController<T> {

	public List<T> listAll() throws Exception;

	public T findById(String nome) throws Exception;

	public int insert(T domain) throws Exception;

	public int update(T domain) throws Exception;

	public int delete(T domain) throws Exception;

}
