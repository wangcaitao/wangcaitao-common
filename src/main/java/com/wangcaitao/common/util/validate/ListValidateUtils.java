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
     * 校验列表不能为空 (列表不能为空时校验)
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void notEmpty(List<Object> param, String paramComment) {
        boolean isEmptyList = (null == param || param.isEmpty());
        if (isEmptyList) {
            throw new ResultException(paramComment + " 不能为空");
        }
    }
}
