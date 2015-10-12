package br.hue.hue.inf008.kinkinmonitor.model;

import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;

public abstract class UnidadeMonitora {

	private double id;
	private PontoLocalizacao localizacao;
	private boolean hasCamera, hasTermometro, hasMedidorCO2, hasMedidorCH4;

	public UnidadeMonitora() {
		this.localizacao = new PontoLocalizacao();
		this.hasCamera = this.hasTermometro = this.hasMedidorCO2 = this.hasMedidorCH4 = false;
	}

	public abstract void mover(PontoLocalizacao local);

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

	public boolean isHasCamera() {
		return hasCamera;
	}

	public void setHasCamera(boolean hasCamera) {
		this.hasCamera = hasCamera;
	}

	public boolean isHasTermometro() {
		return hasTermometro;
	}

	public void setHasTermometro(boolean hasTermometro) {
		this.hasTermometro = hasTermometro;
	}

	public boolean isHasMedidorCO2() {
		return hasMedidorCO2;
	}

	public void setHasMedidorCO2(boolean hasMedidorCO2) {
		this.hasMedidorCO2 = hasMedidorCO2;
	}

	public boolean isHasMedidorCH4() {
		return hasMedidorCH4;
	}

	public void setHasMedidorCH4(boolean hasMedidorCH4) {
		this.hasMedidorCH4 = hasMedidorCH4;
	}

}
