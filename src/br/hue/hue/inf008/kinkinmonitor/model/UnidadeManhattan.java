package br.hue.hue.inf008.kinkinmonitor.model;

import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;

public class UnidadeManhattan extends UnidadeMonitora {

	public static final String SEQUENCE = "SQ_UNIDADE_MANHATTAN";

	@Override
	public double calcularDistancia(PontoLocalizacao destino) {
		double distancia = 0d;
		if (this.getLocalizacao() != null && destino != null) {
			double diffLatitude = this.getLocalizacao().getLatitude() - destino.getLatitude();
			double diffLongitude = this.getLocalizacao().getLongitude() - destino.getLongitude();
			distancia = Math.abs(diffLatitude) + Math.abs(diffLongitude);
		}
		return distancia;
	}
}
