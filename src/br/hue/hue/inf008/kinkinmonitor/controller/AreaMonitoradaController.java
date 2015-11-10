package br.hue.hue.inf008.kinkinmonitor.controller;

import java.util.List;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.persistence.AreaMonitoradaDAO;

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
			throw new Exception("Identificador deve ser preenchido.");
		}
		return this.dao.findByNome(nome);
	}

	@Override
	public int insert(AreaMonitorada domain) throws Exception {
		if (domain.getNome() == null || domain.getNome().isEmpty()) {
			throw new Exception("Identificador deve ser preenchido.");
		}
		return this.dao.insert(domain);
	}

	@Override
	public int update(AreaMonitorada domain) throws Exception {
		if (domain.getNome() == null || domain.getNome().isEmpty()) {
			throw new Exception("Identificador deve ser preenchido.");
		}
		return this.dao.update(domain);
	}

	@Override
	public int delete(AreaMonitorada domain) throws Exception {
		if (domain == null || domain.getId() == 0) {
			throw new Exception("Área Monitorada deve ser informada.");
		}
		return this.dao.delete(domain);
	}

}