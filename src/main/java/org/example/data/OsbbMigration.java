package org.example.data;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;

import static org.example.data.Config.*;

public class OsbbMigration {

    private static final Logger logger = Logger.getLogger(OsbbMigration.class);

    public void flywayMigration() {
        logger.debug("Flyway migration execute");

        Flyway.configure()
                .dataSource(jdbcUrl, username, password)
                .locations("classpath:flyway/script")
                .load()
                .migrate();
    }
}
