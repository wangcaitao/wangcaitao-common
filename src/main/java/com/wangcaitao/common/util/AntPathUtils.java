package com.wangcaitao.common.util;

import com.wangcaitao.common.constant.CharConstant;

import java.util.Objects;

/**
 * ant path util
 *
 * @author wangcaitao
 */
public class AntPathUtils {

    /**
     * 是否匹配
     *
     * @param pattern 表达式
     * @param path    匹配项
     * @return 是否匹配
     */
    public static boolean match(String pattern, String path) {
        String[] patternArray = pattern.split(CharConstant.SLASH);
        String[] pathArray = path.split(CharConstant.SLASH);

        int patternArrayLength = patternArray.length;
        int pathArrayLength = pathArray.length;
        if (patternArrayLength != pathArrayLength) {
            return false;
        }

        boolean match = true;
        for (int i = 0; i < patternArrayLength; i++) {
            String patternValue = patternArray[i];
            if (patternValue.contains(CharConstant.OPEN_BRACE) && patternValue.contains(CharConstant.CLOSE_BRACE)) {
                continue;
            }

            if (!Objects.equals(patternValue, pathArray[i])) {
                match = false;

                break;
            }
        }

        return match;
    }
}
