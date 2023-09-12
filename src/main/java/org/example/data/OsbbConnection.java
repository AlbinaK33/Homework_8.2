package org.example.data;

import org.apache.log4j.Logger;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.example.data.Config.*;

public class OsbbConnection implements Closeable {

    OsbbConnection(){}

    private static final Logger logger = Logger.getLogger(OsbbConnection.class);
    public static Connection connection = null;

    OsbbConnection jdbcConnection() throws SQLException {
        logger.info("Crud has initialized");
        connection = DriverManager.getConnection(jdbcUrl, username, password);
        return this;
    }

    @Override
    public void close(){
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
