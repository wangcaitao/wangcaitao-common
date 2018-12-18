package cn.wangcaitao.common.constant;

import java.sql.Timestamp;

/**
 * 初始 timestamp 常量
 *
 * @author wangcaitao
 */
public class GmtConstant {

    /**
     * 1970-01-01 00:00:00 对应的 时间戳
     */
    public static final Long DEFAULT_TIME_MILLIS = -28800000L;

    /**
     * 1970-01-01 00:00:00 对应的 时间戳
     */
    public static final Timestamp DEFAULT_GMT_TIMESTAMP = new Timestamp(DEFAULT_TIME_MILLIS);
}
