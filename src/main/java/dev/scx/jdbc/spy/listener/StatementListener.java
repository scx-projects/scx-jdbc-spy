package dev.scx.jdbc.spy.listener;

import java.sql.SQLException;
import java.sql.Statement;

public interface StatementListener {

    default void beforeExecuteQuery(Statement statement, String sql) {

    }

    default void afterExecuteQuery(Statement statement, String sql, long elapsedNanos, SQLException e) {

    }

    default void beforeExecuteUpdate(Statement statement, String sql) {

    }

    default void afterExecuteUpdate(Statement statement, String sql, long elapsedNanos, SQLException e) {

    }

    default void beforeExecute(Statement statement, String sql) {

    }

    default void afterExecute(Statement statement, String sql, long elapsedNanos, SQLException e) {

    }

    default void beforeAddBatch(Statement statement, String sql) {

    }

    default void afterAddBatch(Statement statement, String sql, long elapsedNanos, SQLException e) {

    }

    default void beforeClearBatch(Statement statement) {

    }

    default void afterClearBatch(Statement statement, long elapsedNanos, SQLException e) {

    }

    default void beforeExecuteBatch(Statement statement) {

    }

    default void afterExecuteBatch(Statement statement, long elapsedNanos, SQLException e) {

    }

}
