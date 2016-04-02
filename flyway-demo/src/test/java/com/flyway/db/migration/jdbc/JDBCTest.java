package com.flyway.db.migration.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by didi on 16/3/16.
 */
public class JDBCTest {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/flyway_demo";
    public static Connection getConnnection() throws Exception {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(JDBC_URL, "root", "");
        return connection;
    }

    public static void closeConnection(Connection connection) throws Exception{
        if (connection!=null)
        {
            connection.close();
        }
    }
}
