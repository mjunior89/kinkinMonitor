package br.hue.hue.inf008.kinkinmonitor.model;

import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;

public class UnidadeEuclidiana extends UnidadeMonitora {

	public static final String SEQUENCE = "SQ_UNIDADE_EUCLIDIANA";

	@Override
	public void mover(PontoLocalizacao destino) {

	}

	@Override
	protected boolean podeMover(PontoLocalizacao destino) {

		return false;
	}

	@Override
	protected boolean calcularDistancia(PontoLocalizacao destino) {

		return false;
	}

}
