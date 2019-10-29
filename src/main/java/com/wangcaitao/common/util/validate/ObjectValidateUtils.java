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
     * @param nullObject   是否可以为 null. false: 不可以, true: 可以
     */
    public static void notNull(Object param, String paramComment, boolean nullObject) {
        if (null == param && !nullObject) {
            throw new ResultException(paramComment + " 不能为空");
        }
    }

    /**
     * 不能为 null
     *
     * @param param        param
     * @param paramComment paramComment
     */
    public static void notNull(Object param, String paramComment) {
        notNull(param, paramComment, false);
    }
}
