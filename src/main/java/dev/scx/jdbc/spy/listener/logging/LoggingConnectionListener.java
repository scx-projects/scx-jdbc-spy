package dev.scx.jdbc.spy.listener.logging;

import dev.scx.jdbc.spy.listener.ConnectionListener;

import static dev.scx.jdbc.spy.ScxJdbcSpy.SCX_JDBC_SPY_LOGGER;

public final class LoggingConnectionListener implements ConnectionListener {

    private final System.Logger logger;
    private final PreparedStatementLogStyle logStyle;

    public LoggingConnectionListener(PreparedStatementLogStyle logStyle) {
        this(SCX_JDBC_SPY_LOGGER, logStyle);
    }

    public LoggingConnectionListener(System.Logger logger, PreparedStatementLogStyle logStyle) {
        this.logger = logger;
        this.logStyle = logStyle;
    }

    @Override
    public LoggingStatementListener createStatementListener() {
        return new LoggingStatementListener(logger);
    }

    @Override
    public LoggingPreparedStatementListener createPreparedStatementListener(String sql) {
        return new LoggingPreparedStatementListener(logger, sql, logStyle);
    }

    @Override
    public LoggingCallableStatementListener createCallableStatementListener(String sql) {
        return new LoggingCallableStatementListener(logger, sql, logStyle);
    }

}
