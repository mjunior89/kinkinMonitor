package br.hue.hue.inf008.kinkinmonitor.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora;

public class UnidadeMonitoraTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<UnidadeMonitora> unidades = null;

	public UnidadeMonitoraTableModel(List<UnidadeMonitora> unidades) {
		this.unidades = new ArrayList<>(unidades);
	}

	@Override
	public String getColumnName(int column) {
		String[] colunas = new String[] { "Tipo", "Identificador", "Câmera", "Termômetro", "Medidor CO2", "Medidor CH4", "Localização", "object" };
		return colunas[column];
	}

	@Override
	public int getRowCount() {
		return this.unidades.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		UnidadeMonitora unidade = this.unidades.get(rowIndex);
		String tipo = "";
		if (unidade instanceof UnidadeEuclidiana) {
			tipo = "Euclidiana";
		} else if (unidade instanceof UnidadeManhattan) {
			tipo = "Manhattan";
		}
		Object valor = new Object[] { 
				tipo,
				unidade.getNome(),
				(unidade.isCamera() ? "Sim" : "Não"),
				(unidade.isTermometro() ? "Sim" : "Não"),
				(unidade.isMedidorCO2() ? "Sim" : "Não"),
				(unidade.isMedidorCH4() ? "Sim" : "Não"),
				unidade.getLocalizacao().toString(),
				unidade }[columnIndex];
		return valor;
	}

}
