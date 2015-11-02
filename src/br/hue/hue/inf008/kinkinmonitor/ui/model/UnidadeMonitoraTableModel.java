package br.hue.hue.inf008.kinkinmonitor.ui.model;

import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UnidadeMonitoraTableModel extends AbstractTableModel {

	private List<UnidadeMonitora> unidades;

	public UnidadeMonitoraTableModel(List<UnidadeMonitora> unidades) {
		this.unidades = new ArrayList<>(unidades);
	}

	@Override
	public String getColumnName(int column) {
		return "";
	}

	@Override
	public int getRowCount() {
		return this.unidades.size();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.unidades.get(rowIndex);
	}

}
