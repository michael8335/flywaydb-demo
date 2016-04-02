package com.flyway.db.migration.jdbc;

import org.junit.Test;

/**
 * Created by didi on 16/3/16.
 */
public class V3_Alter_TableTest {
    @Test
    public void testAlter() throws Exception {
        V3__Alter_Table alterTable = new V3__Alter_Table();
        alterTable.migrate(JDBCTest.getConnnection());
    }
}