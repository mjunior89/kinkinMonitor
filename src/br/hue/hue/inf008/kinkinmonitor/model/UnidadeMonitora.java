package br.hue.hue.inf008.kinkinmonitor.model;

import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;

public abstract class UnidadeMonitora {

	private int id;
	private PontoLocalizacao localizacao;
	private boolean camera, termometro, medidorCO2, medidorCH4;
	private AreaMonitorada areaMonitorada;

	public UnidadeMonitora() {
		this.localizacao = null;
		this.areaMonitorada = null;
		this.camera = this.termometro = this.medidorCO2 = this.medidorCH4 = false;
	}

	public boolean mover(PontoLocalizacao destino) {
		if (this.podeMover(destino)) {
			this.setLocalizacao(destino);
			return true;
		}
		return false;
	}

	protected boolean podeMover(PontoLocalizacao destino) {
		return !(this.getLocalizacao().equals(destino));
	}

	public abstract double calcularDistancia(PontoLocalizacao destino);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PontoLocalizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(PontoLocalizacao localizacao) {
		this.localizacao = localizacao;
	}

	public boolean isCamera() {
		return camera;
	}

	public void setCamera(boolean camera) {
		this.camera = camera;
	}

	public boolean isTermometro() {
		return termometro;
	}

	public void setTermometro(boolean termometro) {
		this.termometro = termometro;
	}

	public boolean isMedidorCO2() {
		return medidorCO2;
	}

	public void setMedidorCO2(boolean medidorCO2) {
		this.medidorCO2 = medidorCO2;
	}

	public boolean isMedidorCH4() {
		return medidorCH4;
	}

	public void setMedidorCH4(boolean medidorCH4) {
		this.medidorCH4 = medidorCH4;
	}

	public AreaMonitorada getAreaMonitorada() {
		return areaMonitorada;
	}

	public void setAreaMonitorada(AreaMonitorada areaMonitorada) {
		this.areaMonitorada = areaMonitorada;
	}

	@Override
	public String toString() {
		String toString = "Unidade Nº " + id;
		if (this.getLocalizacao() != null) {
			toString += ", localização:{" + this.getLocalizacao().getLongitude() + "LAT; " + this.getLocalizacao().getLongitude() + "LONG}";
		}
		return toString;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = (31 * hash) + this.getId();
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof UnidadeMonitora)) {
			return false;
		}
		UnidadeMonitora other = (UnidadeMonitora) obj;
		if (this.getId() == 0) {
			return this == other;
		} else {
			return this.getId() == other.getId();
		}
	}
}
