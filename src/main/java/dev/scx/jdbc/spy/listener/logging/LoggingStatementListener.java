package dev.scx.jdbc.spy.listener.logging;

import dev.scx.jdbc.spy.listener.StatementListener;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static dev.scx.jdbc.spy.ScxJdbcSpy.SCX_JDBC_SPY_LOGGER;
import static java.lang.System.Logger.Level.DEBUG;

public class LoggingStatementListener implements StatementListener {

    protected final System.Logger logger;
    private final List<String> batchSqls;

    public LoggingStatementListener() {
        this(SCX_JDBC_SPY_LOGGER);
    }

    public LoggingStatementListener(System.Logger logger) {
        this.logger = logger;
        this.batchSqls = new ArrayList<>();
    }

    public void beforeAnyExecute(Statement statement, String sql) {
        if (logger.isLoggable(DEBUG)) {
            logger.log(DEBUG, sql);
        }
    }

    public void afterAnyExecute(Statement statement, String sql, long elapsedNanos, SQLException e) {
        // 我们不关心这个阶段
    }

    @Override
    public void beforeExecuteQuery(Statement statement, String sql) {
        beforeAnyExecute(statement, sql);
    }

    @Override
    public void afterExecuteQuery(Statement statement, String sql, long elapsedNanos, SQLException e) {
        afterAnyExecute(statement, sql, elapsedNanos, e);
    }

    @Override
    public void beforeExecuteUpdate(Statement statement, String sql) {
        beforeAnyExecute(statement, sql);
    }

    @Override
    public void afterExecuteUpdate(Statement statement, String sql, long elapsedNanos, SQLException e) {
        afterAnyExecute(statement, sql, elapsedNanos, e);
    }

    @Override
    public void beforeExecute(Statement statement, String sql) {
        beforeAnyExecute(statement, sql);
    }

    @Override
    public void afterExecute(Statement statement, String sql, long elapsedNanos, SQLException e) {
        afterAnyExecute(statement, sql, elapsedNanos, e);
    }

    @Override
    public void beforeAddBatch(Statement statement, String sql) {
        // 我们不关心这个阶段
    }

    @Override
    public void afterAddBatch(Statement statement, String sql, long elapsedNanos, SQLException e) {
        if (e == null) {
            batchSqls.add(sql);
        }
    }

    @Override
    public void beforeClearBatch(Statement statement) {
        // 我们不关心这个阶段
    }

    @Override
    public void afterClearBatch(Statement statement, long elapsedNanos, SQLException e) {
        if (e == null) {
            batchSqls.clear();
        }
    }

    @Override
    public void beforeExecuteBatch(Statement statement) {
        if (logger.isLoggable(DEBUG)) {
            // 这里采取最简单的 循环 log 方式.
            for (var batchSql : batchSqls) {
                logger.log(DEBUG, batchSql);
            }
        }
    }

    @Override
    public void afterExecuteBatch(Statement statement, long elapsedNanos, SQLException e) {
        // 这里无论是否执行成功都清空 batchSqls
        batchSqls.clear();
    }

}
