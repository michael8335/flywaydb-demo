package com.flyway.db.migration.spring;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by didi on 16/3/16.
 */
public class V1_Create_TableTest {

    @Test
    public void testMigrate() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/flyway_demo");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        new V3__Update_Table("spring").migrate(jdbcTemplate);
    }
}