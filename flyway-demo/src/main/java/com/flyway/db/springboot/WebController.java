package com.flyway.db.springboot;

import com.flyway.db.migration.callback.DemoCallBack;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class WebController {

    @Autowired
    private Flyway flyway;

    @RequestMapping(value = "/migrate", method = RequestMethod.GET)
    @ResponseBody
    public String migrate() throws SQLException
    {
        flyway.setLocations("com.didi.ep.flyway.db.migration.spring");
        flyway.setCallbacks(new DemoCallBack());
        flyway.setBaselineOnMigrate(true);
        int count=flyway.migrate();
        return "migrate count:"+count;
    }
}
