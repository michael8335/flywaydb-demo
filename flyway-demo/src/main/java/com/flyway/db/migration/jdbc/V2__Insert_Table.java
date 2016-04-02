package com.flyway.db.migration.jdbc;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by didi on 16/3/16.
 */
public class V2__Insert_Table implements JdbcMigration {
    @Override
    public void migrate(Connection connection) throws Exception {
        PreparedStatement statement = connection.prepareStatement("insert into user_jdbc(name,sex,degree) value('jdbc',1,12.32);");
        try {
            statement.execute();
        } finally {
            statement.close();

        }
    }
}
