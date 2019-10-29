package com.wangcaitao.common.util.validate;

import com.wangcaitao.common.exception.ResultException;

import java.util.List;

/**
 * 列表校验工具
 *
 * @author wangcaitao
 */
public class ListValidateUtils {

    /**
     * 校验列表不能为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void notEmpty(List param, String paramComment) {
        notEmpty(param, paramComment, false);
    }

    /**
     * 校验列表不能为空 (列表不能为空时校验)
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param emptyList    是否可以为空. false: 不可以, true: 可以
     */
    public static void notEmpty(List param, String paramComment, boolean emptyList) {
        boolean isEmptyList = (null == param || param.isEmpty());
        if (isEmptyList && !emptyList) {
            throw new ResultException(paramComment + " 不能为空");
        }
    }
}
