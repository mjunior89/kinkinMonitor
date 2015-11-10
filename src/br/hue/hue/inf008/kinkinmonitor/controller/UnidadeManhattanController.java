package br.hue.hue.inf008.kinkinmonitor.controller;

import java.util.ArrayList;
import java.util.List;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora;
import br.hue.hue.inf008.kinkinmonitor.persistence.UnidadeManhattanDAO;

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
		if (areaSelecionada == null || areaSelecionada.getId() == 0) {
			throw new Exception("Área Monitorada deve ser informada.");
		}
		return this.dao.listAllByAreaMonitorada(areaSelecionada);
	}

	@Override
	public UnidadeManhattan findById(String nome) throws Exception {
		if (nome == null || nome.isEmpty()) {
			throw new Exception("Identificador deve ser preenchido.");
		}
		return this.dao.findByNome(nome);
	}

	@Override
	public int insert(UnidadeManhattan domain) throws Exception {
		if (domain.getNome() == null || domain.getNome().isEmpty()) {
			throw new Exception("Identificador deve ser preenchido.");
		}
		verificarLocalizacaoMonitorada(domain);
		return this.dao.insert(domain);
	}

	@Override
	public int update(UnidadeManhattan domain) throws Exception {
		if (domain.getNome() == null || domain.getNome().isEmpty()) {
			throw new Exception("Identificador deve ser preenchido.");
		}
		verificarLocalizacaoMonitorada(domain);
		return this.dao.update(domain);
	}

	@Override
	public int delete(UnidadeManhattan domain) throws Exception {
		if (domain == null || domain.getId() == 0) {
			throw new Exception("Unidade Monitora deve ser informada.");
		}
		return this.dao.delete(domain);
	}

	private void verificarLocalizacaoMonitorada(UnidadeManhattan domain) throws Exception {
		List<UnidadeMonitora> unidades = new ArrayList<>();
		unidades.addAll(this.listAllByAreaMonitorada(domain.getAreaMonitorada()));
		unidades.addAll(new UnidadeManhattanController().listAllByAreaMonitorada(domain.getAreaMonitorada()));
		for (UnidadeMonitora unit : unidades) {
			if (unit.getLocalizacao().equals(domain.getLocalizacao()) && !unit.equals(domain)) {
				throw new Exception("Localização já monitorada. Lat.: " + domain.getLocalizacao().getLatitude() + ", Long.:" + domain.getLocalizacao().getLongitude() + ".");
			}
		}
	}
}