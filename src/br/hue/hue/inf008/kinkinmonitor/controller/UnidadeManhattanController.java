package br.hue.hue.inf008.kinkinmonitor.controller;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
import br.hue.hue.inf008.kinkinmonitor.persistence.UnidadeManhattanDAO;
import java.util.List;

public class UnidadeManhattanController {

	private UnidadeManhattanDAO dao;

	public UnidadeManhattanController() {
		this.dao = new UnidadeManhattanDAO();
	}

	public List<UnidadeManhattan> listAll() throws Exception {
		return this.dao.listAll();
	}

	public List<UnidadeManhattan> listAllByAreaMonitorada(AreaMonitorada areaSelecionada) throws Exception {
		return this.dao.listAllByAreaMonitorada(areaSelecionada);
	}

	public UnidadeManhattan findById(String nome) throws Exception {
		return this.dao.findByNome(nome);
	}

	public int insert(UnidadeManhattan domain) throws Exception {
		return this.dao.insert(domain);
	}

	public int update(UnidadeManhattan domain) throws Exception {
		return this.dao.update(domain);
	}

	public int delete(UnidadeManhattan domain) throws Exception {
		return this.dao.delete(domain);
	}
}
