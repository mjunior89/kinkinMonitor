package br.hue.hue.inf008.kinkinmonitor.domain;

import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;

public abstract class UnidadeMonitora {

    private double id;
    private PontoLocalizacao localizacao;
    private boolean hasCamera, hasTermometro, hasMedidorCO2, hasMedidorCH4;

}