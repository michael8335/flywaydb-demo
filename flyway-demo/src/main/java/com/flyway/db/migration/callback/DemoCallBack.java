package com.flyway.db.migration.callback;

import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.callback.FlywayCallback;

import java.sql.Connection;

public class DemoCallBack implements FlywayCallback{

    public void beforeClean(Connection connection) {
        System.out.println("before clean");

    }

    public void afterClean(Connection connection) {
        System.out.println("after clean");
    }

    public void beforeMigrate(Connection connection) {
        System.out.println("before migrate");
    }

    public void afterMigrate(Connection connection) {
        System.out.println("after migrate");
    }

    public void beforeEachMigrate(Connection connection, MigrationInfo migrationInfo) {
        System.out.println("before each migrate");
    }

    public void afterEachMigrate(Connection connection, MigrationInfo migrationInfo) {
        System.out.println("after each migrate");
    }

    public void beforeValidate(Connection connection) {
        System.out.println("before validate");
    }

    public void afterValidate(Connection connection) {
        System.out.println("after validate");
    }

    @Override
    public void beforeBaseline(Connection connection) {
        System.out.println("before baseline");
    }

    @Override
    public void afterBaseline(Connection connection) {
        System.out.println("after base line");
    }

    public void beforeInit(Connection connection) {
        System.out.println("before init");
    }

    public void afterInit(Connection connection) {
        System.out.println("after init");
    }

    public void beforeRepair(Connection connection) {
        System.out.println("before repair");
    }

    public void afterRepair(Connection connection) {
        System.out.println("after repair");
    }

    public void beforeInfo(Connection connection) {
        System.out.println("before info");
    }

    public void afterInfo(Connection connection) {
        System.out.println("after info");
    }
}
