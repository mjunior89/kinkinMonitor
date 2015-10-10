package br.hue.hue.inf008.kinkinmonitor.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCFactoryManager {

    protected Connection createConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Creating Java DataBase Connection....");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kinkin_monitor", "postgres", "123456");
        } catch (Exception e) {
            Logger.getLogger(JDBCFactoryManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }

    public void executeStatement(String query) {
        Connection con = null;
        try {
            con = createConnection();
            Statement stmt = con.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e) {
            Logger.getLogger(JDBCFactoryManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
