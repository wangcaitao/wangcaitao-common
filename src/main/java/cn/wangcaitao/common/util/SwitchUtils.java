package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.CharConstant;
import cn.wangcaitao.common.constant.IntegerConstant;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 对象转换工具类
 *
 * @author wangcaitao
 */
public class SwitchUtils {

    /**
     * 英文逗号分割的字符串转 Long[]
     *
     * @param str 英文逗号分割的字符串
     * @return Long[]
     */
    public static Long[] stringToLongArray(String str) {
        if (StringUtils.isEmpty(str)) {
            return new Long[IntegerConstant.ZERO];
        }

        String[] strArray = str.split(CharConstant.COMMA);
        int len = strArray.length;
        Long[] longArray = new Long[len];
        for (int i = 0; i < len; i++) {
            longArray[i] = Long.parseLong(strArray[i]);
        }

        return longArray;
    }

    /**
     * Long[] 转 英文逗号分割的字符串（最后无逗号）
     *
     * @param longArray Long[]
     * @return 英文逗号分割的字符串
     */
    public static String longArrayToString(Long[] longArray) {
        if (null == longArray || IntegerConstant.ZERO == longArray.length) {
            return CharConstant.EMPTY;
        }

        StringBuilder str = new StringBuilder();
        for (Long num : longArray) {
            str.append(num).append(CharConstant.COMMA);
        }

        return str.deleteCharAt(str.length() - 1).toString();
    }

    /**
     * 英文逗号分割的字符串转排序后的字符串（最后无逗号）
     *
     * @param str string
     * @return sorted string
     */
    public static String stringToSortedString(String str) {
        if (StringUtils.isEmpty(str)) {
            return CharConstant.EMPTY;
        }

        String[] strArray = str.split(CharConstant.COMMA);
        Arrays.sort(strArray);

        StringBuilder sortedStr = new StringBuilder();
        for (String s : strArray) {
            sortedStr.append(s).append(CharConstant.COMMA);
        }

        return sortedStr.deleteCharAt(sortedStr.length() - 1).toString();
    }

    /**
     * 英文逗号分割的字符串（纯数字）转排序后的字符串（最后无逗号）
     *
     * @param str string
     * @return sorted string
     */
    public static String longToSortedString(String str) {
        if (StringUtils.isEmpty(str)) {
            return CharConstant.EMPTY;
        }

        Long[] longArray = stringToLongArray(str);
        Arrays.sort(longArray);

        return longArrayToString(longArray);
    }
}
