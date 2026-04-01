package dev.scx.jdbc.spy;

import dev.scx.jdbc.spy.listener.ConnectionListener;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/// SpyConnection
///
/// @author scx567888
/// @version 0.0.1
public final class SpyConnection extends SpyWrapper<Connection> implements Connection {

    private final ConnectionListener l;

    SpyConnection(Connection connection, ConnectionListener connectionListener) {
        super(connection);
        this.l = connectionListener;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return new SpyStatement<>(d.createStatement(), l.createStatementListener());
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return new SpyPreparedStatement<>(d.prepareStatement(sql), l.createPreparedStatementListener(sql));
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return new SpyCallableStatement(d.prepareCall(sql), l.createCallableStatementListener(sql));
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return d.nativeSQL(sql);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return d.getAutoCommit();
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        d.setAutoCommit(autoCommit);
    }

    @Override
    public void commit() throws SQLException {
        d.commit();
    }

    @Override
    public void rollback() throws SQLException {
        d.rollback();
    }

    @Override
    public void close() throws SQLException {
        d.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return d.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return d.getMetaData();
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return d.isReadOnly();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        d.setReadOnly(readOnly);
    }

    @Override
    public String getCatalog() throws SQLException {
        return d.getCatalog();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        d.setCatalog(catalog);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return d.getTransactionIsolation();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        d.setTransactionIsolation(level);
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return d.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        d.clearWarnings();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return new SpyStatement<>(d.createStatement(resultSetType, resultSetConcurrency), l.createStatementListener());
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return new SpyPreparedStatement<>(d.prepareStatement(sql, resultSetType, resultSetConcurrency), l.createPreparedStatementListener(sql));
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return new SpyCallableStatement(d.prepareCall(sql, resultSetType, resultSetConcurrency), l.createCallableStatementListener(sql));
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return d.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        d.setTypeMap(map);
    }

    @Override
    public int getHoldability() throws SQLException {
        return d.getHoldability();
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        d.setHoldability(holdability);
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return d.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return d.setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        d.rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        d.releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return new SpyStatement<>(d.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability), l.createStatementListener());
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return new SpyPreparedStatement<>(d.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability), l.createPreparedStatementListener(sql));
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return new SpyCallableStatement(d.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability), l.createCallableStatementListener(sql));
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return new SpyPreparedStatement<>(d.prepareStatement(sql, autoGeneratedKeys), l.createPreparedStatementListener(sql));
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return new SpyPreparedStatement<>(d.prepareStatement(sql, columnIndexes), l.createPreparedStatementListener(sql));
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return new SpyPreparedStatement<>(d.prepareStatement(sql, columnNames), l.createPreparedStatementListener(sql));
    }

    @Override
    public Clob createClob() throws SQLException {
        return d.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return d.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return d.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return d.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return d.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        d.setClientInfo(name, value);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return d.getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return d.getClientInfo();
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        d.setClientInfo(properties);
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return d.createArrayOf(typeName, elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return d.createStruct(typeName, attributes);
    }

    @Override
    public String getSchema() throws SQLException {
        return d.getSchema();
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        d.setSchema(schema);
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        d.abort(executor);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        d.setNetworkTimeout(executor, milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return d.getNetworkTimeout();
    }

    @Override
    public void beginRequest() throws SQLException {
        d.beginRequest();
    }

    @Override
    public void endRequest() throws SQLException {
        d.endRequest();
    }

    @Override
    public boolean setShardingKeyIfValid(ShardingKey shardingKey, ShardingKey superShardingKey, int timeout) throws SQLException {
        return d.setShardingKeyIfValid(shardingKey, superShardingKey, timeout);
    }

    @Override
    public boolean setShardingKeyIfValid(ShardingKey shardingKey, int timeout) throws SQLException {
        return d.setShardingKeyIfValid(shardingKey, timeout);
    }

    @Override
    public void setShardingKey(ShardingKey shardingKey, ShardingKey superShardingKey) throws SQLException {
        d.setShardingKey(shardingKey, superShardingKey);
    }

    @Override
    public void setShardingKey(ShardingKey shardingKey) throws SQLException {
        d.setShardingKey(shardingKey);
    }

}
