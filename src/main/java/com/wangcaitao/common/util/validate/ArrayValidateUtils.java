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
     * @param emptyArray   是否可以为空. false: 不可以, true: 可以
     */
    public static void notEmpty(Object[] param, String paramComment, boolean emptyArray) {
        boolean isEmptyArray = (null == param || 0 == param.length);
        if (isEmptyArray && !emptyArray) {
            throw new ResultException(paramComment + " 不能为空");
        }
    }

    /**
     * 不能为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void notEmpty(Object[] param, String paramComment) {
        notEmpty(param, paramComment, false);
    }
}
