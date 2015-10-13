package br.hue.hue.inf008.kinkinmonitor.model;

import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;

public abstract class UnidadeMonitora {

	private double id;
	private PontoLocalizacao localizacao;
	private boolean camera, termometro, medidorCO2, medidorCH4;

	public UnidadeMonitora() {
		this.localizacao = new PontoLocalizacao();
		this.camera = this.termometro = this.medidorCO2 = this.medidorCH4 = false;
	}

	public abstract void mover(PontoLocalizacao destino);

	protected abstract boolean podeMover(PontoLocalizacao destino);

	protected abstract boolean calcularDistancia(PontoLocalizacao destino);

	public double getId() {
		return id;
	}

	public void setId(double id) {
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

}
