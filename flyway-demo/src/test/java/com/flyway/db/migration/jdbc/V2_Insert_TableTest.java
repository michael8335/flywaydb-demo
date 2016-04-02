package com.flyway.db.migration.jdbc;

import org.junit.Test;

/**
 * Created by didi on 16/3/16.
 */
public class V2_Insert_TableTest {
    @Test
    public void testInsert() throws Exception {
        V2__Insert_Table insertTable=new V2__Insert_Table();
        insertTable.migrate(JDBCTest.getConnnection());
    }
}