package br.hue.hue.inf008.kinkinmonitor;

import br.hue.hue.inf008.kinkinmonitor.persistence.DataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		DataSource ds = new DataSource();
		try {
			ds.initDataBase();
		} catch (SQLException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		IntegrationSPEC tests = new IntegrationSPEC();

	}

}
