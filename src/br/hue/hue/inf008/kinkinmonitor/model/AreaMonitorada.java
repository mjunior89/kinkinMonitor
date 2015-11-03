package br.hue.hue.inf008.kinkinmonitor.model;

import java.util.ArrayList;
import java.util.List;

public class AreaMonitorada {

	public static final String SEQUENCE = "SQ_AREA_MONITORADA";

	private int id;
	private String nome;
	private List<UnidadeMonitora> unidades = new ArrayList<>();

	public AreaMonitorada() {
	}

	public AreaMonitorada(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<UnidadeMonitora> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<UnidadeMonitora> unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "Área Monitorada: " + this.getNome();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = (31 * hash) + this.getId();
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AreaMonitorada)) {
			return false;
		}
		AreaMonitorada other = (AreaMonitorada) obj;
		if (this.getId() == 0) {
			return this == other;
		} else {
			return this.getId() == other.getId();
		}
	}
}
