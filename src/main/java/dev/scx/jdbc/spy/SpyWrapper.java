package dev.scx.jdbc.spy;

import java.sql.SQLException;
import java.sql.Wrapper;

/// SpyWrapper
///
/// @author scx567888
/// @version 0.0.1
public class SpyWrapper<D extends Wrapper> implements Wrapper {

    protected final D d;

    SpyWrapper(D wrapper) {
        this.d = wrapper;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (iface.isInstance(this)) {
            return (T) this;
        }
        // 某些 Wrapper 实现即使自身已经是目标类型, 也未必会直接返回自身,
        // 所以这里先显式判断底层对象 d 是否已是目标类型.
        if (iface.isInstance(d)) {
            return (T) d;
        }
        return d.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        if (iface.isInstance(this)) {
            return true;
        }
        // 某些 Wrapper 实现即使自身已经是目标类型, 也未必会直接判断为 true,
        // 所以这里先显式判断底层对象 d 是否已是目标类型.
        if (iface.isInstance(d)) {
            return true;
        }
        return d.isWrapperFor(iface);
    }

}
