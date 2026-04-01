package dev.scx.jdbc.spy.listener;

public interface ConnectionListener {

    StatementListener createStatementListener();

    PreparedStatementListener createPreparedStatementListener(String sql);

    CallableStatementListener createCallableStatementListener(String sql);

}
