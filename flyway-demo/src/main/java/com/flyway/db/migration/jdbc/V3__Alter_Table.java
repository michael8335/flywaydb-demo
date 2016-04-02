package com.flyway.db.migration.jdbc;

import org.flywaydb.core.api.callback.FlywayCallback;
import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by didi on 16/3/16.
 */
public class V3__Alter_Table implements JdbcMigration {

    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/flyway_demo";

    public void migrate(Connection connection) throws Exception {
        PreparedStatement statement = connection.prepareStatement("alter table user_jdbc add nickname varchar(32);");
        try {
            statement.execute();
        } finally {
            statement.close();

        }
    }
}
