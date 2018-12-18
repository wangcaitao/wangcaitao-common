package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.DateTimeFormatterConstant;
import cn.wangcaitao.common.constant.IntegerConstant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 随机数生成工具类
 *
 * @author wangcaitao
 */
public class RandomUtils {

    /**
     * 生成指定位数的随机数
     *
     * @param digit 位数 [1, 16]
     * @return 随机数
     */
    public static int generateRandomDigit(int digit) {
        return (int) ((Math.random() * 9 + 1) * Math.pow(10, digit - 1));
    }

    /**
     * 生成通用编号 (25 位)
     *
     * @return 编号
     */
    public static String generateCommonNo() {
        return generateCustomNo(DateTimeFormatterConstant.DATE_TIME_PATTERN_08, IntegerConstant.EIGHT);
    }

    /**
     * 自定义生成编号
     *
     * @param pattern 日期格式
     * @param digit   随机数字位数
     * @return 编号
     */
    public static String generateCustomNo(String pattern, Integer digit) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern)) + generateRandomDigit(digit);
    }
}
