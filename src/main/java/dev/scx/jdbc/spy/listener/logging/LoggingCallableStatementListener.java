package dev.scx.jdbc.spy.listener.logging;

import dev.scx.jdbc.spy.listener.CallableStatementListener;

import static dev.scx.jdbc.spy.ScxJdbcSpy.SCX_JDBC_SPY_LOGGER;

public final class LoggingCallableStatementListener extends LoggingPreparedStatementListener implements CallableStatementListener {

    public LoggingCallableStatementListener(String sql, PreparedStatementLogStyle logStyle) {
        this(SCX_JDBC_SPY_LOGGER, sql, logStyle);
    }

    public LoggingCallableStatementListener(System.Logger logger, String sql, PreparedStatementLogStyle logStyle) {
        super(logger, sql, logStyle);
    }

}
