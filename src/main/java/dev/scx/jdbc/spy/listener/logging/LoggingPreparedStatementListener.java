package dev.scx.jdbc.spy.listener.logging;

import dev.scx.jdbc.spy.listener.PreparedStatementListener;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static dev.scx.jdbc.spy.ScxJdbcSpy.SCX_JDBC_SPY_LOGGER;
import static dev.scx.jdbc.spy.listener.logging.LoggingPreparedStatementListenerHelper.getLogMessage;
import static java.lang.System.Logger.Level.DEBUG;

public class LoggingPreparedStatementListener extends LoggingStatementListener implements PreparedStatementListener {

    protected final String sql;
    protected final Map<Integer, Object> parameters;
    protected final List<Map<Integer, Object>> batchParameters;
    protected final PreparedStatementLogStyle logStyle;

    public LoggingPreparedStatementListener(String sql, PreparedStatementLogStyle logStyle) {
        this(SCX_JDBC_SPY_LOGGER, sql, logStyle);
    }

    public LoggingPreparedStatementListener(System.Logger logger, String sql, PreparedStatementLogStyle logStyle) {
        super(logger);
        this.sql = sql;
        this.parameters = new TreeMap<>();
        this.batchParameters = new ArrayList<>();
        this.logStyle = logStyle;
    }

    public void beforeAnyExecute(PreparedStatement preparedStatement) {
        // 这里我们打印 sql + parameters.
        if (logger.isLoggable(DEBUG)) {
            var logMessage = getLogMessage(sql, parameters, logStyle);
            logger.log(DEBUG, logMessage);
        }
    }

    public void afterAnyExecute(PreparedStatement preparedStatement, long elapsedNanos, SQLException e) {
        // 我们不关心这个阶段
    }

    @Override
    public void beforeExecuteQuery(PreparedStatement preparedStatement) {
        beforeAnyExecute(preparedStatement);
    }

    @Override
    public void afterExecuteQuery(PreparedStatement preparedStatement, long elapsedNanos, SQLException e) {
        afterAnyExecute(preparedStatement, elapsedNanos, e);
    }

    @Override
    public void beforeExecuteUpdate(PreparedStatement preparedStatement) {
        beforeAnyExecute(preparedStatement);
    }

    @Override
    public void afterExecuteUpdate(PreparedStatement preparedStatement, long elapsedNanos, SQLException e) {
        afterAnyExecute(preparedStatement, elapsedNanos, e);
    }

    @Override
    public void beforeExecute(PreparedStatement preparedStatement) {
        beforeAnyExecute(preparedStatement);
    }

    @Override
    public void afterExecute(PreparedStatement preparedStatement, long elapsedNanos, SQLException e) {
        afterAnyExecute(preparedStatement, elapsedNanos, e);
    }

    @Override
    public void beforeAddBatch(PreparedStatement preparedStatement) {
        // 我们不关心这个阶段
    }

    @Override
    public void afterAddBatch(PreparedStatement preparedStatement, long elapsedNanos, SQLException e) {
        if (e == null) {
            batchParameters.add(new TreeMap<>(parameters));
        }
    }

    @Override
    public void setParameter(int parameterIndex, Object value) {
        parameters.put(parameterIndex, value);
    }

    @Override
    public void clearParameters() {
        parameters.clear();
    }

    // ****** 重写 Batch 操作, 因为 PreparedStatement 和 Statement 在 Batch 上的心智模型是不同的 ******

    @Override
    public void beforeClearBatch(Statement statement) {
        // 我们不关心这个阶段
    }

    @Override
    public void afterClearBatch(Statement statement, long elapsedNanos, SQLException e) {
        // 这里 PreparedStatement 和 Statement 的心智模型是不同的.
        // 对 PreparedStatement 而言, batch 的内容不是多条 SQL,
        // 而是同一条 SQL 模板对应的多组参数快照.
        // 所以这里我们无需调用 super.afterClearBatch.
        if (e == null) {
            batchParameters.clear();
        }
    }

    @Override
    public void beforeExecuteBatch(Statement statement) {
        // 这里 PreparedStatement 和 Statement 的心智模型是不同的.
        // 对 PreparedStatement 而言, batch 的内容不是多条 SQL,
        // 而是同一条 SQL 模板对应的多组参数快照.
        // 所以这里我们应该 打印的是 sql + batchParameters.
        if (logger.isLoggable(DEBUG)) {
            var logMessage = getLogMessage(sql, batchParameters, logStyle);
            logger.log(DEBUG, logMessage);
        }
    }

    @Override
    public void afterExecuteBatch(Statement statement, long elapsedNanos, SQLException e) {
        // 这里 PreparedStatement 和 Statement 的心智模型是不同的.
        // 对 PreparedStatement 而言, batch 的内容不是多条 SQL,
        // 而是同一条 SQL 模板对应的多组参数快照.
        // 所以这里我们无需调用 super.afterExecuteBatch.
        // 这里无论是否执行成功都清空 batchParameters
        batchParameters.clear();
    }

}
