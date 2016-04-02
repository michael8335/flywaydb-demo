package com.flyway.db.resolver;

import org.flywaydb.core.api.MigrationType;
import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.resolver.MigrationExecutor;
import org.flywaydb.core.api.resolver.MigrationResolver;
import org.flywaydb.core.api.resolver.ResolvedMigration;
import org.flywaydb.core.internal.util.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

public class DemoResolver implements MigrationResolver {
    public Collection<ResolvedMigration> resolveMigrations() {
        return Arrays.asList((ResolvedMigration) new ResolvedMigration() {

            public MigrationVersion getVersion() {
                return MigrationVersion.fromVersion("3.0");
            }

            public String getDescription() {
                return "Custom Resolved";
            }

            public String getScript() {
                return "V3__Update_Table";
            }

            public Integer getChecksum() {
                return 1;
            }

            public MigrationType getType() {
                return MigrationType.CUSTOM;
            }

            //需要只需的脚本物理位置
            public String getPhysicalLocation() {
                return null;
            }

            public MigrationExecutor getExecutor() {
                return new MigrationExecutor() {
                    @Override
                    public void execute(Connection connection) throws SQLException {
                        Statement statement = null;
                        try {
                            statement = connection.createStatement();
                            statement.execute("INSERT INTO user_spring (name) VALUES ('Resolvix')");
                        } finally {
                            JdbcUtils.closeStatement(statement);
                        }
                    }

                    @Override
                    public boolean executeInTransaction() {
                        return true;
                    }
                };
            }
        });
    }
}
