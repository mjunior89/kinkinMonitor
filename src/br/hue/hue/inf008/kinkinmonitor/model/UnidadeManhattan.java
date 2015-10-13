package br.hue.hue.inf008.kinkinmonitor.model;

import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;

public class UnidadeManhattan extends UnidadeMonitora {

	public static final String SEQUENCE = "SQ_UNIDADE_MANHATTAN";

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
