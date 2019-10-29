package com.wangcaitao.common.util.validate;

import com.wangcaitao.common.exception.ResultException;

/**
 * id 校验工具
 *
 * @author wangcaitao
 */
public class IdValidateUtils {

    /**
     * 不能为 null
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void notNull(Long param, String paramComment) {
        if (null == param) {
            throw new ResultException(paramComment + " 不能为 null");
        }

        if (param < 1) {
            throw new ResultException(paramComment + " 无效");
        }
    }
}
