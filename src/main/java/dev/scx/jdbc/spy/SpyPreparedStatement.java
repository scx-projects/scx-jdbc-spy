package dev.scx.jdbc.spy;

import dev.scx.jdbc.spy.listener.PreparedStatementListener;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

/// SpyPreparedStatement
///
/// @author scx567888
/// @version 0.0.1
public class SpyPreparedStatement<D extends PreparedStatement, L extends PreparedStatementListener> extends SpyStatement<D, L> implements PreparedStatement {

    SpyPreparedStatement(D preparedStatement, L preparedStatementListener) {
        super(preparedStatement, preparedStatementListener);
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        l.beforeExecuteQuery(d);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeQuery();
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteQuery(d, System.nanoTime() - start, e);
        }
    }

    @Override
    public int executeUpdate() throws SQLException {
        l.beforeExecuteUpdate(d);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeUpdate();
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteUpdate(d, System.nanoTime() - start, e);
        }
    }

    @Override
    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        d.setNull(parameterIndex, sqlType);
        l.setParameter(parameterIndex, null);
    }

    @Override
    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        d.setBoolean(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setByte(int parameterIndex, byte x) throws SQLException {
        d.setByte(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setShort(int parameterIndex, short x) throws SQLException {
        d.setShort(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setInt(int parameterIndex, int x) throws SQLException {
        d.setInt(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setLong(int parameterIndex, long x) throws SQLException {
        d.setLong(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setFloat(int parameterIndex, float x) throws SQLException {
        d.setFloat(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setDouble(int parameterIndex, double x) throws SQLException {
        d.setDouble(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        d.setBigDecimal(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setString(int parameterIndex, String x) throws SQLException {
        d.setString(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        d.setBytes(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setDate(int parameterIndex, Date x) throws SQLException {
        d.setDate(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setTime(int parameterIndex, Time x) throws SQLException {
        d.setTime(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        d.setTimestamp(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        d.setAsciiStream(parameterIndex, x, length);
        l.setParameter(parameterIndex, x);
    }

    @Deprecated(since = "1.2")
    @Override
    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        d.setUnicodeStream(parameterIndex, x, length);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        d.setBinaryStream(parameterIndex, x, length);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void clearParameters() throws SQLException {
        d.clearParameters();
        l.clearParameters();
    }

    @Override
    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
        d.setObject(parameterIndex, x, targetSqlType);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setObject(int parameterIndex, Object x) throws SQLException {
        d.setObject(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public boolean execute() throws SQLException {
        l.beforeExecute(d);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.execute();
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecute(d, System.nanoTime() - start, e);
        }
    }

    @Override
    public void addBatch() throws SQLException {
        l.beforeAddBatch(d);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            d.addBatch();
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterAddBatch(d, System.nanoTime() - start, e);
        }
    }

    @Override
    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
        d.setCharacterStream(parameterIndex, reader, length);
        l.setParameter(parameterIndex, reader);
    }

    @Override
    public void setRef(int parameterIndex, Ref x) throws SQLException {
        d.setRef(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        d.setBlob(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setClob(int parameterIndex, Clob x) throws SQLException {
        d.setClob(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setArray(int parameterIndex, Array x) throws SQLException {
        d.setArray(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        return d.getMetaData();
    }

    @Override
    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
        d.setDate(parameterIndex, x, cal);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
        d.setTime(parameterIndex, x, cal);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
        d.setTimestamp(parameterIndex, x, cal);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
        d.setNull(parameterIndex, sqlType, typeName);
        l.setParameter(parameterIndex, null);
    }

    @Override
    public void setURL(int parameterIndex, URL x) throws SQLException {
        d.setURL(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public ParameterMetaData getParameterMetaData() throws SQLException {
        return d.getParameterMetaData();
    }

    @Override
    public void setRowId(int parameterIndex, RowId x) throws SQLException {
        d.setRowId(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setNString(int parameterIndex, String value) throws SQLException {
        d.setNString(parameterIndex, value);
        l.setParameter(parameterIndex, value);
    }

    @Override
    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
        d.setNCharacterStream(parameterIndex, value, length);
        l.setParameter(parameterIndex, value);
    }

    @Override
    public void setNClob(int parameterIndex, NClob value) throws SQLException {
        d.setNClob(parameterIndex, value);
        l.setParameter(parameterIndex, value);
    }

    @Override
    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
        d.setClob(parameterIndex, reader, length);
        l.setParameter(parameterIndex, reader);
    }

    @Override
    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
        d.setBlob(parameterIndex, inputStream, length);
        l.setParameter(parameterIndex, inputStream);
    }

    @Override
    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
        d.setNClob(parameterIndex, reader, length);
        l.setParameter(parameterIndex, reader);
    }

    @Override
    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
        d.setSQLXML(parameterIndex, xmlObject);
        l.setParameter(parameterIndex, xmlObject);
    }

    @Override
    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
        d.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
        d.setAsciiStream(parameterIndex, x, length);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
        d.setBinaryStream(parameterIndex, x, length);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
        d.setCharacterStream(parameterIndex, reader, length);
        l.setParameter(parameterIndex, reader);
    }

    @Override
    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
        d.setAsciiStream(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
        d.setBinaryStream(parameterIndex, x);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
        d.setCharacterStream(parameterIndex, reader);
        l.setParameter(parameterIndex, reader);
    }

    @Override
    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
        d.setNCharacterStream(parameterIndex, value);
        l.setParameter(parameterIndex, value);
    }

    @Override
    public void setClob(int parameterIndex, Reader reader) throws SQLException {
        d.setClob(parameterIndex, reader);
        l.setParameter(parameterIndex, reader);
    }

    @Override
    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
        d.setBlob(parameterIndex, inputStream);
        l.setParameter(parameterIndex, inputStream);
    }

    @Override
    public void setNClob(int parameterIndex, Reader reader) throws SQLException {
        d.setNClob(parameterIndex, reader);
        l.setParameter(parameterIndex, reader);
    }

    @Override
    public void setObject(int parameterIndex, Object x, SQLType targetSqlType, int scaleOrLength) throws SQLException {
        d.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public void setObject(int parameterIndex, Object x, SQLType targetSqlType) throws SQLException {
        d.setObject(parameterIndex, x, targetSqlType);
        l.setParameter(parameterIndex, x);
    }

    @Override
    public long executeLargeUpdate() throws SQLException {
        l.beforeExecuteUpdate(d);
        SQLException e = null;
        var start = System.nanoTime();
        try {
            return d.executeLargeUpdate();
        } catch (SQLException ex) {
            e = ex;
            throw e;
        } finally {
            l.afterExecuteUpdate(d, System.nanoTime() - start, e);
        }
    }

}
