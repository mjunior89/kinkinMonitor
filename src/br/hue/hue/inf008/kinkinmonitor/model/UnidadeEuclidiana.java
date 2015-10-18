package br.hue.hue.inf008.kinkinmonitor.model;

import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;

public class UnidadeEuclidiana extends UnidadeMonitora {

	public static final String SEQUENCE = "SQ_UNIDADE_EUCLIDIANA";

	@Override
	public double calcularDistancia(PontoLocalizacao destino) {
		double distancia = 0d;
		if (this.getLocalizacao() != null && destino != null) {
			double diffLatitude = this.getLocalizacao().getLatitude() - destino.getLatitude();
			double diffLongitude = this.getLocalizacao().getLongitude() - destino.getLongitude();
			distancia = Math.sqrt(Math.pow(diffLatitude, 2) + Math.pow(diffLongitude, 2));
		}
		return distancia;
	}

}
