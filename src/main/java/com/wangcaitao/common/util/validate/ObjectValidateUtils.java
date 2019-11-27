package com.wangcaitao.common.util.validate;

import com.wangcaitao.common.exception.ResultException;

/**
 * 对象校验工具
 *
 * @author wangcaitao
 */
public class ObjectValidateUtils {

    /**
     * 不能为 null
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void notNull(Object param, String paramComment) {
        if (null == param) {
            throw new ResultException(paramComment + " 不能为空");
        }
    }
}
