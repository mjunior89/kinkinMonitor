package br.hue.hue.inf008.kinkinmonitor.controller;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.persistence.UnidadeEuclidianaDAO;
import java.util.List;

public class UnidadeEuclidianaController implements IController<UnidadeEuclidiana> {

	private UnidadeEuclidianaDAO dao = null;

	public UnidadeEuclidianaController() {
		this.dao = new UnidadeEuclidianaDAO();
	}

	@Override
	public List<UnidadeEuclidiana> listAll() throws Exception {
		return this.dao.listAll();
	}

	public List<UnidadeEuclidiana> listAllByAreaMonitorada(AreaMonitorada areaSelecionada) throws Exception {
		return this.dao.listAllByAreaMonitorada(areaSelecionada);
	}

	@Override
	public UnidadeEuclidiana findById(String nome) throws Exception {
		return this.dao.findByNome(nome);
	}

	@Override
	public int insert(UnidadeEuclidiana domain) throws Exception {
		if (domain.getNome() == null || domain.getNome().isEmpty()) {
			throw new Exception("Identificador deve ser preenchido.");
		}
		return this.dao.insert(domain);
	}

	@Override
	public int update(UnidadeEuclidiana domain) throws Exception {
		return this.dao.update(domain);
	}

	@Override
	public int delete(UnidadeEuclidiana domain) throws Exception {
		return this.dao.delete(domain);
	}

}
