package br.hue.hue.inf008.kinkinmonitor;

import br.hue.hue.inf008.kinkinmonitor.persistence.DataSource;

public class Main {

	public static void main(String[] args) {
		DataSource ds = new DataSource();
		ds.initDataBase();
	}

}
