package dev.scx.jdbc.spy.listener.logging;

import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Map;

public final class LoggingPreparedStatementListenerHelper {

    public static String getParameterString(Object parameter) {
        return switch (parameter) {
            case null -> "null";
            case String s -> "'" + s + "'";
            case Character c -> "'" + c + "'";
            case Number number -> number.toString();
            case Boolean b -> b.toString();
            case TemporalAccessor temporalAccessor -> "'" + temporalAccessor + "'";
            case byte[] bytes -> "<byte[" + bytes.length + "]>";
            case java.util.Date date -> "'" + date + "'";
            case java.net.URL url -> "'" + url + "'";
            case java.io.InputStream _ -> "<InputStream>";
            case java.io.Reader _ -> "<Reader>";
            case java.sql.Blob _ -> "<Blob>";
            case java.sql.Clob _ -> "<Clob>";
            case java.sql.SQLXML _ -> "<SQLXML>";
            case java.sql.Array _ -> "<Array>";
            case java.sql.Ref _ -> "<Ref>";
            case java.sql.RowId _ -> "<RowId>";
            default -> String.valueOf(parameter);
        };
    }

    public static String getSqlAndParametersLogMessage(String sql, Map<Integer, Object> parameters) {
        var sb = new StringBuilder("SQL and Parameters:\r\n");
        sb.append(sql).append("\r\n");
        sb.append("Parameters: [");

        var first = true;
        for (var e : parameters.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            first = false;

            var key = e.getKey();
            var value = e.getValue();
            var parameterString = getParameterString(value);
            sb.append(key).append("=").append(parameterString);
        }

        return sb.append("]").toString();
    }

    /// 这里只做朴素占位符替换, 不解析 SQL 字符串字面量、注释等结构. 并不代表真实执行 SQL.
    public static String getRenderedSqlLogMessage(String sql, Map<Integer, Object> parameters) {
        var sb = new StringBuilder("Rendered SQL:\r\n");

        if (parameters.isEmpty()) {
            return sb.append(sql).toString();
        }

        var parameterIndex = 1;

        for (var i = 0; i < sql.length(); i = i + 1) {
            var c = sql.charAt(i);

            if (c == '?') {
                if (parameters.containsKey(parameterIndex)) {
                    sb.append(getParameterString(parameters.get(parameterIndex)));
                } else {
                    sb.append('?');
                }
                parameterIndex = parameterIndex + 1;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /// 这里我们不会渲染 所有的 条目, 只渲染第一条 + 剩余条目信息.
    public static String getSqlAndParametersLogMessage(String sql, List<Map<Integer, Object>> batchParameters) {
        if (batchParameters.isEmpty()) {
            return "SQL and Parameters:\r\n" + sql + "\r\nParameters: []";
        }

        var firstSqlAndParameters = getSqlAndParametersLogMessage(sql, batchParameters.get(0));

        if (batchParameters.size() == 1) {
            return firstSqlAndParameters;
        }

        // 展示剩余条目.
        return firstSqlAndParameters + "\r\n... (and " + (batchParameters.size() - 1) + " more batch entries)";
    }

    /// 这里我们不会渲染 所有的 条目, 只渲染第一条 + 剩余条目信息.
    public static String getRenderedSqlLogMessage(String sql, List<Map<Integer, Object>> batchParameters) {
        if (batchParameters.isEmpty()) {
            return "Rendered SQL:\r\n" + sql;
        }

        var firstRenderedSql = getRenderedSqlLogMessage(sql, batchParameters.get(0));

        if (batchParameters.size() == 1) {
            return firstRenderedSql;
        }

        // 展示剩余条目.
        return firstRenderedSql + "\r\n... (and " + (batchParameters.size() - 1) + " more batch entries)";
    }

    public static String getLogMessage(String sql, Map<Integer, Object> parameters, PreparedStatementLogStyle logStyle) {
        return switch (logStyle) {
            case SQL_AND_PARAMETERS -> getSqlAndParametersLogMessage(sql, parameters);
            case RENDERED_SQL -> getRenderedSqlLogMessage(sql, parameters);
        };
    }

    public static String getLogMessage(String sql, List<Map<Integer, Object>> batchParameters, PreparedStatementLogStyle logStyle) {
        return switch (logStyle) {
            case SQL_AND_PARAMETERS -> getSqlAndParametersLogMessage(sql, batchParameters);
            case RENDERED_SQL -> getRenderedSqlLogMessage(sql, batchParameters);
        };
    }

}
