package com.wangcaitao.common.constant;

/**
 * 日期格式常量
 *
 * @author wangcaitao
 */
public class DateTimeFormatterConstant {

    /**
     * yyyy-MM-dd
     */
    public static final String DATE_PATTERN_01 = "yyyy-MM-dd";

    /**
     * yyyy/MM/dd
     */
    public static final String DATE_PATTERN_02 = "yyyy/MM/dd";

    /**
     * yyyy.MM.dd
     */
    public static final String DATE_PATTERN_03 = "yyyy.MM.dd";

    /**
     * yyyyMMdd
     */
    public static final String DATE_PATTERN_04 = "yyyyMMdd";


    /**
     * HH:mm:ss
     */
    public static final String TIME_PATTERN_01 = "HH:mm:ss";

    /**
     * HH:mm:ss.SSS
     */
    public static final String TIME_PATTERN_02 = "HH:mm:ss.SSS";

    /**
     * HHmmss
     */
    public static final String TIME_PATTERN_03 = "HHmmss";

    /**
     * HHmmssSSS
     */
    public static final String TIME_PATTERN_04 = "HHmmssSSS";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_TIME_PATTERN_01 = DATE_PATTERN_01 + " " + TIME_PATTERN_01;

    /**
     * yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String DATE_TIME_PATTERN_02 = DATE_PATTERN_01 + " " + TIME_PATTERN_02;

    /**
     * yyyy/MM/dd HH:mm:ss
     */
    public static final String DATE_TIME_PATTERN_03 = DATE_PATTERN_02 + " " + TIME_PATTERN_01;

    /**
     * yyyy/MM/dd HH:mm:ss.SSS
     */
    public static final String DATE_TIME_PATTERN_04 = DATE_PATTERN_02 + " " + TIME_PATTERN_02;

    /**
     * yyyy.MM.dd HH:mm:ss
     */
    public static final String DATE_TIME_PATTERN_05 = DATE_PATTERN_03 + " " + TIME_PATTERN_01;

    /**
     * yyyy.MM.dd HH:mm:ss.SSS
     */
    public static final String DATE_TIME_PATTERN_06 = DATE_PATTERN_03 + " " + TIME_PATTERN_02;

    /**
     * yyyyMMddHHmmss
     */
    public static final String DATE_TIME_PATTERN_07 = DATE_PATTERN_04 + TIME_PATTERN_03;

    /**
     * yyyyMMddHHmmssSSS
     */
    public static final String DATE_TIME_PATTERN_08 = DATE_PATTERN_04 + TIME_PATTERN_04;
}
