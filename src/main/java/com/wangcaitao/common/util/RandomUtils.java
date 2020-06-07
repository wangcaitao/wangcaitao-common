package com.wangcaitao.common.util;

import com.wangcaitao.common.constant.DateTimeFormatterConstant;
import com.wangcaitao.common.constant.IntegerConstant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * 随机数生成工具类
 *
 * @author wangcaitao
 */
public class RandomUtils {

    /**
     * Random instance
     */
    private static final Random RANDOM = new Random();

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
     * 随机指定区间. [MIN, MAX]
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机数
     */
    public static int generateInterval(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    /**
     * 随机指定区间. [MIN, MAX)
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机数
     */
    public static double generateInterval(double min, double max) {
        return Math.random() * max % (max - min) + min;
    }

    /**
     * 生成通用编号 (25 位) yyyyMMddHHmmssSSS + 8 位随机数
     *
     * @return 编号
     */
    public static String generateCommonNo() {
        return generateCustomNo(DateTimeFormatterConstant.DATE_TIME_PATTERN_08, IntegerConstant.EIGHT);
    }

    /**
     * 生成通用编号 (前缀位数 + 25 位) 前缀 + yyyyMMddHHmmssSSS + 8 位随机数
     *
     * @param prefix 前缀
     * @return 编号
     */
    public static String generateCommonNo(String prefix) {
        return prefix + generateCommonNo();
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

    /**
     * 自定义生成编号
     *
     * @param prefix  前缀
     * @param pattern 日期格式
     * @param digit   随机数字位数
     * @return 编号
     */
    public static String generateCustomNo(String prefix, String pattern, Integer digit) {
        return prefix + generateCustomNo(pattern, digit);
    }

    /**
     * 验证码. 6 位
     *
     * @return 验证码
     */
    public static String generateCaptcha() {
        return String.valueOf(generateRandomDigit(IntegerConstant.SIX));
    }
}
