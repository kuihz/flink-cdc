package org.apache.flink.cdc.connectors.mysql.utils;

import io.debezium.data.Envelope;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.cdc.debezium.table.DebeziumChangelogMode;
import org.apache.flink.table.data.GenericRowData;
import org.apache.flink.types.RowKind;

public class OpTypeConv {
    public static String convMysqlOpTypeToFlinkOpType(String op) {
        if (StringUtils.isBlank(op)) {
            return null;
        }
        switch (op) {
            case "c":
            case "r":
                return RowKind.INSERT.shortString();
            case "u":
                return RowKind.UPDATE_AFTER.shortString();
            case "d":
                return RowKind.DELETE.shortString();
            default:
                return null;
        }
    }
}
