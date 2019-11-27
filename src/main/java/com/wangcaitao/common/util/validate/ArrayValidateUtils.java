package com.wangcaitao.common.util.validate;

import com.wangcaitao.common.exception.ResultException;

/**
 * 数组校验工具
 *
 * @author wangcaitao
 */
public class ArrayValidateUtils {

    /**
     * 不能为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void notEmpty(Object[] param, String paramComment) {
        boolean isEmptyArray = (null == param || 0 == param.length);
        if (isEmptyArray) {
            throw new ResultException(paramComment + " 不能为空");
        }
    }
}
