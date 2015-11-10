package br.hue.hue.inf008.kinkinmonitor.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;

public class AreaMonitoradaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<AreaMonitorada> areas;

	public AreaMonitoradaTableModel(List<AreaMonitorada> areas) {
		this.areas = new ArrayList<>(areas);
	}

	@Override
	public String getColumnName(int column) {
		return "";
	}

	@Override
	public int getRowCount() {
		return this.areas.size();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.areas.get(rowIndex);
	}

}
