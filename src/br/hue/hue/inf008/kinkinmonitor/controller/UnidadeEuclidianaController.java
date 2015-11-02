package br.hue.hue.inf008.kinkinmonitor.controller;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.persistence.UnidadeEuclidianaDAO;
import java.util.List;

public class UnidadeEuclidianaController {

	private UnidadeEuclidianaDAO dao;

	public UnidadeEuclidianaController() {
		this.dao = new UnidadeEuclidianaDAO();
	}

	public List<UnidadeEuclidiana> listAll() throws Exception {
		return this.dao.listAll();
	}

	public List<UnidadeEuclidiana> listAllByAreaMonitorada(AreaMonitorada areaSelecionada) throws Exception {
		return this.dao.listAllByAreaMonitorada(areaSelecionada);
	}

	public UnidadeEuclidiana findById(String nome) throws Exception {
		return this.dao.findByNome(nome);
	}

	public int insert(UnidadeEuclidiana domain) throws Exception {
		return this.dao.insert(domain);
	}

	public int update(UnidadeEuclidiana domain) throws Exception {
		return this.dao.update(domain);
	}

	public int delete(UnidadeEuclidiana domain) throws Exception {
		return this.dao.delete(domain);
	}

}
