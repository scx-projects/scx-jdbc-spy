package dev.scx.jdbc.spy.listener;

public interface DataSourceListener {

    ConnectionListener createConnectionListener();

}
