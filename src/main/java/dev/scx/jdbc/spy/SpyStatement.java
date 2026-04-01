package dev.scx.jdbc.spy;

import dev.scx.jdbc.spy.listener.StatementListener;

import java.sql.*;

/// SpyStatement
///
/// @author scx567888
/// @version 0.0.1
public class SpyStatement<D extends Statement, L extends StatementListener> extends SpyWrapper<D> implements Statement {

    protected final L l;

    SpyStatement(D statement, L statementListener) {
        super(statement);
        this.l = statementListener;
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        l.beforeExecuteQuery(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeQuery(sql);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteQuery(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        l.beforeExecuteUpdate(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeUpdate(sql);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteUpdate(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public void close() throws SQLException {
        d.close();
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        return d.getMaxFieldSize();
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        d.setMaxFieldSize(max);
    }

    @Override
    public int getMaxRows() throws SQLException {
        return d.getMaxRows();
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        d.setMaxRows(max);
    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        d.setEscapeProcessing(enable);
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        return d.getQueryTimeout();
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        d.setQueryTimeout(seconds);
    }

    @Override
    public void cancel() throws SQLException {
        d.cancel();
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
    public void setCursorName(String name) throws SQLException {
        d.setCursorName(name);
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        l.beforeExecute(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.execute(sql);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecute(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return d.getResultSet();
    }

    @Override
    public int getUpdateCount() throws SQLException {
        return d.getUpdateCount();
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        return d.getMoreResults();
    }

    @Override
    public int getFetchDirection() throws SQLException {
        return d.getFetchDirection();
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        d.setFetchDirection(direction);
    }

    @Override
    public int getFetchSize() throws SQLException {
        return d.getFetchSize();
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        d.setFetchSize(rows);
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return d.getResultSetConcurrency();
    }

    @Override
    public int getResultSetType() throws SQLException {
        return d.getResultSetType();
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        l.beforeAddBatch(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            d.addBatch(sql);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterAddBatch(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public void clearBatch() throws SQLException {
        l.beforeClearBatch(d);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            d.clearBatch();
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterClearBatch(d, System.nanoTime() - start, e);
        }
    }

    @Override
    public int[] executeBatch() throws SQLException {
        l.beforeExecuteBatch(d);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeBatch();
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteBatch(d, System.nanoTime() - start, e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return d.getConnection();
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        return d.getMoreResults(current);
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return d.getGeneratedKeys();
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        l.beforeExecuteUpdate(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeUpdate(sql, autoGeneratedKeys);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteUpdate(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        l.beforeExecuteUpdate(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeUpdate(sql, columnIndexes);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteUpdate(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        l.beforeExecuteUpdate(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeUpdate(sql, columnNames);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteUpdate(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        l.beforeExecute(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.execute(sql, autoGeneratedKeys);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecute(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        l.beforeExecute(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.execute(sql, columnIndexes);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecute(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        l.beforeExecute(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.execute(sql, columnNames);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecute(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return d.getResultSetHoldability();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return d.isClosed();
    }

    @Override
    public boolean isPoolable() throws SQLException {
        return d.isPoolable();
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {
        d.setPoolable(poolable);
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        d.closeOnCompletion();
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return d.isCloseOnCompletion();
    }

    @Override
    public long getLargeUpdateCount() throws SQLException {
        return d.getLargeUpdateCount();
    }

    @Override
    public long getLargeMaxRows() throws SQLException {
        return d.getLargeMaxRows();
    }

    @Override
    public void setLargeMaxRows(long max) throws SQLException {
        d.setLargeMaxRows(max);
    }

    @Override
    public long[] executeLargeBatch() throws SQLException {
        l.beforeExecuteBatch(d);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeLargeBatch();
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteBatch(d, System.nanoTime() - start, e);
        }
    }

    @Override
    public long executeLargeUpdate(String sql) throws SQLException {
        l.beforeExecuteUpdate(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeLargeUpdate(sql);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteUpdate(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        l.beforeExecuteUpdate(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeLargeUpdate(sql, autoGeneratedKeys);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteUpdate(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
        l.beforeExecuteUpdate(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeLargeUpdate(sql, columnIndexes);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteUpdate(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
        l.beforeExecuteUpdate(d, sql);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeLargeUpdate(sql, columnNames);
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteUpdate(d, sql, System.nanoTime() - start, e);
        }
    }

    @Override
    public String enquoteLiteral(String val) throws SQLException {
        return d.enquoteLiteral(val);
    }

    @Override
    public String enquoteIdentifier(String identifier, boolean alwaysQuote) throws SQLException {
        return d.enquoteIdentifier(identifier, alwaysQuote);
    }

    @Override
    public boolean isSimpleIdentifier(String identifier) throws SQLException {
        return d.isSimpleIdentifier(identifier);
    }

    @Override
    public String enquoteNCharLiteral(String val) throws SQLException {
        return d.enquoteNCharLiteral(val);
    }

}
