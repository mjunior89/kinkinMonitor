package br.hue.hue.inf008.kinkinmonitor.controller;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.persistence.AreaMonitoradaDAO;
import java.util.List;

public class AreaMonitoradaController implements IController<AreaMonitorada> {

	private AreaMonitoradaDAO dao = null;

	public AreaMonitoradaController() {
		this.dao = new AreaMonitoradaDAO();
	}

	@Override
	public List<AreaMonitorada> listAll() throws Exception {
		return this.dao.listAll();
	}

	@Override
	public AreaMonitorada findById(String nome) throws Exception {
		if (nome == null || nome.isEmpty()) {
			throw new Exception("Informe o Identificador da Área Monitorada.");
		}
		return this.dao.findByNome(nome);
	}

	@Override
	public int insert(AreaMonitorada domain) throws Exception {
		if (domain.getNome() == null || domain.getNome().isEmpty()) {
			throw new Exception("Informe o Identificador da Área Monitorada.");
		}
		return this.dao.insert(domain);
	}

	@Override
	public int update(AreaMonitorada domain) throws Exception {
		if (domain.getNome() == null || domain.getNome().isEmpty()) {
			throw new Exception("Informe o Identificador da Área Monitorada.");
		}
		return this.dao.update(domain);
	}

	@Override
	public int delete(AreaMonitorada domain) throws Exception {
		return this.dao.delete(domain);
	}

}
