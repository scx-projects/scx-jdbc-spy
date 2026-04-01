package dev.scx.jdbc.spy;

import dev.scx.jdbc.spy.listener.*;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/// ScxJdbcSpy
///
/// @author scx567888
/// @version 0.0.1
public final class ScxJdbcSpy {

    public static final System.Logger SCX_JDBC_SPY_LOGGER = System.getLogger("ScxJdbcSpy");

    public static DataSource spy(DataSource dataSource, DataSourceListener dataSourceListener) {
        // 避免 wrapper 嵌套, 若已包装则替换监听器
        return dataSource instanceof SpyDataSource w ? new SpyDataSource(w.d, dataSourceListener) : new SpyDataSource(dataSource, dataSourceListener);
    }

    public static Connection spy(Connection connection, ConnectionListener connectionListener) {
        // 避免 wrapper 嵌套, 若已包装则替换监听器
        return connection instanceof SpyConnection w ? new SpyConnection(w.d, connectionListener) : new SpyConnection(connection, connectionListener);
    }

    public static Statement spy(Statement statement, StatementListener statementListener) {
        // 避免 wrapper 嵌套, 若已包装则替换监听器
        return statement instanceof SpyStatement<?, ?> w ? new SpyStatement<>(w.d, statementListener) : new SpyStatement<>(statement, statementListener);
    }

    public static PreparedStatement spy(PreparedStatement preparedStatement, PreparedStatementListener preparedStatementListener) {
        // 避免 wrapper 嵌套, 若已包装则替换监听器
        return preparedStatement instanceof SpyPreparedStatement<?, ?> w ? new SpyPreparedStatement<>(w.d, preparedStatementListener) : new SpyPreparedStatement<>(preparedStatement, preparedStatementListener);
    }

    public static CallableStatement spy(CallableStatement callableStatement, CallableStatementListener callableStatementListener) {
        // 避免 wrapper 嵌套, 若已包装则替换监听器
        return callableStatement instanceof SpyCallableStatement w ? new SpyCallableStatement(w.d, callableStatementListener) : new SpyCallableStatement(callableStatement, callableStatementListener);
    }

}
