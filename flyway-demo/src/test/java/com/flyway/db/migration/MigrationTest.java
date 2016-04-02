package com.flyway.db.migration;

import com.flyway.db.migration.callback.DemoCallBack;
import org.flywaydb.core.Flyway;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by didi on 16/3/16.
 */
public class MigrationTest {

    @Test
    public void testMigration()
    {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://127.0.0.1:3306/flyway_demo", "root", "");
        flyway.setLocations("com.didi.ep.flyway.db.migration.spring");
        //自定义执行规则
        //flyway.setResolvers(new DemoResolver());
        flyway.setCallbacks(new DemoCallBack());
        flyway.setBaselineOnMigrate(true);
        int count=flyway.migrate();
        System.out.println("migrate count:"+count);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(flyway.getDataSource());
        List<Map<String, Object>> results = jdbcTemplate.queryForList("select name from user_spring");
        for (Map<String, Object> result : results) {
            System.out.println("Name: " + result.get("NAME"));
        }
    }
}
