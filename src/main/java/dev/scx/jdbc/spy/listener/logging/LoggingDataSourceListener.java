package dev.scx.jdbc.spy.listener.logging;

import dev.scx.jdbc.spy.listener.DataSourceListener;

import static dev.scx.jdbc.spy.ScxJdbcSpy.SCX_JDBC_SPY_LOGGER;

public final class LoggingDataSourceListener implements DataSourceListener {

    private final System.Logger logger;
    private final PreparedStatementLogStyle logStyle;

    public LoggingDataSourceListener(PreparedStatementLogStyle logStyle) {
        this(SCX_JDBC_SPY_LOGGER, logStyle);
    }

    public LoggingDataSourceListener(System.Logger logger, PreparedStatementLogStyle logStyle) {
        this.logger = logger;
        this.logStyle = logStyle;
    }

    @Override
    public LoggingConnectionListener createConnectionListener() {
        return new LoggingConnectionListener(logger, logStyle);
    }

}
