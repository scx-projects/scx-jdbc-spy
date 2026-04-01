package dev.scx.jdbc.spy.listener;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementListener extends StatementListener {

    default void beforeExecuteQuery(PreparedStatement preparedStatement) {

    }

    default void afterExecuteQuery(PreparedStatement preparedStatement, long elapsedNanos, SQLException e) {

    }

    default void beforeExecuteUpdate(PreparedStatement preparedStatement) {

    }

    default void afterExecuteUpdate(PreparedStatement preparedStatement, long elapsedNanos, SQLException e) {

    }

    default void beforeExecute(PreparedStatement preparedStatement) {

    }

    default void afterExecute(PreparedStatement preparedStatement, long elapsedNanos, SQLException e) {

    }

    default void beforeAddBatch(PreparedStatement preparedStatement) {

    }

    default void afterAddBatch(PreparedStatement preparedStatement, long elapsedNanos, SQLException e) {

    }

    default void setParameter(int parameterIndex, Object value) {

    }

    default void clearParameters() {

    }

}
