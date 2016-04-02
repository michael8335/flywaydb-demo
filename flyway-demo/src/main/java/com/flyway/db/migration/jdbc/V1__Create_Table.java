package com.flyway.db.migration.jdbc;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class V1__Create_Table implements JdbcMigration {

    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/flyway_demo";

    public void migrate(Connection connection) throws Exception {
        PreparedStatement statement = connection.prepareStatement("create table user_jdbc(\n" +
                " user_id int(4) not null primary key auto_increment,\n" +
                " name char(20) not null,\n" +
                " sex int(4) not null default '0',\n" +
                " degree double(16,2));");
        try {
            statement.execute();
        } finally {
            statement.close();

        }
    }
}
