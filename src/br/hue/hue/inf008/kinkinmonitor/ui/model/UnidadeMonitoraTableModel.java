package br.hue.hue.inf008.kinkinmonitor.ui.model;

import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UnidadeMonitoraTableModel extends AbstractTableModel {

	private List<UnidadeMonitora> unidades = null;

	public UnidadeMonitoraTableModel(List<UnidadeMonitora> unidades) {
		this.unidades = new ArrayList<>(unidades);
	}

	@Override
	public String getColumnName(int column) {
		String[] colunas = new String[]{"Identificador", "Câmera", "Termômetro", "Medidor CO2", "Medidor CH4", "Localização", "tipo"};
		return colunas[column];
	}

	@Override
	public int getRowCount() {
		return this.unidades.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		UnidadeMonitora unidade = this.unidades.get(rowIndex);
		String valor = new String[]{unidade.getNome(), (unidade.isCamera() ? "Sim" : "Não"), (unidade.isTermometro() ? "Sim" : "Não"), (unidade.isMedidorCO2() ? "Sim" : "Não"), (unidade.isMedidorCH4() ? "Sim" : "Não"), unidade.getLocalizacao().toString(), unidade.getClass().getCanonicalName()}[columnIndex];
		return valor;
	}

}
