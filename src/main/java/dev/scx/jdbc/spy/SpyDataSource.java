package dev.scx.jdbc.spy;

import dev.scx.jdbc.spy.listener.DataSourceListener;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

/// SpyDataSource
///
/// @author scx567888
/// @version 0.0.1
public final class SpyDataSource extends SpyWrapper<DataSource> implements DataSource {

    private final DataSourceListener l;

    SpyDataSource(DataSource dataSource, DataSourceListener dataSourceListener) {
        super(dataSource);
        this.l = dataSourceListener;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return new SpyConnection(d.getConnection(), l.createConnectionListener());
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return new SpyConnection(d.getConnection(username, password), l.createConnectionListener());
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return d.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        d.setLogWriter(out);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return d.getLoginTimeout();
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        d.setLoginTimeout(seconds);
    }

    @Override
    public ConnectionBuilder createConnectionBuilder() throws SQLException {
        return d.createConnectionBuilder();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return d.getParentLogger();
    }

    @Override
    public ShardingKeyBuilder createShardingKeyBuilder() throws SQLException {
        return d.createShardingKeyBuilder();
    }

}
