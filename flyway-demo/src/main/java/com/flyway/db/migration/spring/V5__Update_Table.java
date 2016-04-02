package com.flyway.db.migration.spring;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * Created by didi on 16/3/16.
 */
public class V5__Update_Table implements SpringJdbcMigration {

    private String name;

    public V5__Update_Table()
    {
        this.name="spring5";
    }
    public V5__Update_Table(String name)
    {
        this.name=name;
    }
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        String createTable="create table if not exists user_spring(user_id int(4) not null primary key auto_increment,name char(20) not null);";
        String insertSQL="insert into user_spring(name) value('"+this.name+"')";
        System.out.println("spring migrate before");
        jdbcTemplate.batchUpdate(createTable,insertSQL);
    }
}
