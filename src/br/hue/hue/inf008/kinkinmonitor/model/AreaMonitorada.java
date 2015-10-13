package br.hue.hue.inf008.kinkinmonitor.model;

import java.util.ArrayList;
import java.util.List;

public class AreaMonitorada {

	private int id;
	private String nome;
	private List<UnidadeMonitora> unidades = new ArrayList<>();

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

}
