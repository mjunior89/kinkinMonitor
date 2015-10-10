package br.hue.hue.inf008.kinkinmonitor;

import br.hue.hue.inf008.kinkinmonitor.persistence.JDBCFactoryManager;

public class Main {

    public static void main(String[] args) {
        JDBCFactoryManager factory = new JDBCFactoryManager();
        factory.executeStatement("select now()");
    }

}