package br.hue.hue.inf008.kinkinmonitor.model;

import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;
import java.util.ArrayList;

public abstract class UnidadeMonitora {

	public static enum EnumUnidadeMonitora {

		CAMERA,
		MEDIDORCH4,
		MEDIDORCO2,
		TERMOMETRO;

	}

	private int id;
	private String nome;
	private PontoLocalizacao localizacao;
	private boolean camera, termometro, medidorCO2, medidorCH4;
	private AreaMonitorada areaMonitorada;

	public UnidadeMonitora() {
		this.nome = null;
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

	public boolean possuiConfiguracaoMinima(ArrayList<EnumUnidadeMonitora> configuracoes) {
		boolean hasMinimalConfs = true;
		for (EnumUnidadeMonitora conf : configuracoes) {
			switch (conf) {
				case CAMERA: {
					hasMinimalConfs = hasMinimalConfs && this.isCamera();
					break;
				}
				case MEDIDORCH4: {
					hasMinimalConfs = hasMinimalConfs && this.isMedidorCH4();
					break;
				}
				case MEDIDORCO2: {
					hasMinimalConfs = hasMinimalConfs && this.isMedidorCO2();
					break;
				}
				case TERMOMETRO: {
					hasMinimalConfs = hasMinimalConfs && this.isTermometro();
					break;
				}
				default: {
					hasMinimalConfs = false;
					break;
				}
			}
			if (!hasMinimalConfs) {
				break;
			}
		}
		return hasMinimalConfs;
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
		String toString = "Unidade:  " + this.nome;
		if (this.getLocalizacao() != null) {
			toString += ", localização:{" + this.getLocalizacao().getLongitude() + "LAT; " + this.getLocalizacao().getLongitude() + "LONG}";
		}
		return toString;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = (31 * hash) + this.getId();
		hash = (31 * hash) + this.getNome().hashCode();
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
			return this.getId() == other.getId() && this.getNome().equals(other.getNome());
		}
	}

}
