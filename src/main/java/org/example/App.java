package org.example;

import org.apache.log4j.Logger;
import org.example.data.OsbbCrud;

public class App {

    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Starting logger");

        new OsbbCrud().getResultConnection();
    }
}
