package br.hue.hue.inf008.kinkinmonitor.controller;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
import br.hue.hue.inf008.kinkinmonitor.persistence.UnidadeManhattanDAO;
import java.util.List;

public class UnidadeManhattanController implements IController<UnidadeManhattan> {

	private UnidadeManhattanDAO dao = null;

	public UnidadeManhattanController() {
		this.dao = new UnidadeManhattanDAO();
	}

	@Override
	public List<UnidadeManhattan> listAll() throws Exception {
		return this.dao.listAll();
	}

	public List<UnidadeManhattan> listAllByAreaMonitorada(AreaMonitorada areaSelecionada) throws Exception {
		return this.dao.listAllByAreaMonitorada(areaSelecionada);
	}

	@Override
	public UnidadeManhattan findById(String nome) throws Exception {
		return this.dao.findByNome(nome);
	}

	@Override
	public int insert(UnidadeManhattan domain) throws Exception {
		return this.dao.insert(domain);
	}

	@Override
	public int update(UnidadeManhattan domain) throws Exception {
		return this.dao.update(domain);
	}

	@Override
	public int delete(UnidadeManhattan domain) throws Exception {
		return this.dao.delete(domain);
	}
}
