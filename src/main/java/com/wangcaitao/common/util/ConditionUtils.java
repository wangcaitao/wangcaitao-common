package com.wangcaitao.common.util;

import com.wangcaitao.common.constant.CommonErrorEnum;
import com.wangcaitao.common.constant.DictCodeConstant;
import com.wangcaitao.common.entity.Result;

import java.io.Serializable;

/**
 * 公共条件判断工具
 *
 * @author wangcaitao
 */
public class ConditionUtils {

    /**
     * 对移动编码错误处理
     *
     * @param typeCode typeCode
     * @return Result
     */
    public static Result<Serializable> judgeMoveTypeCode(String typeCode) {
        switch (typeCode) {
            case DictCodeConstant.MOVE_TYPE_UP:
                return ResultUtils.error(CommonErrorEnum.FIRST);
            case DictCodeConstant.MOVE_TYPE_DOWN:
                return ResultUtils.error(CommonErrorEnum.LAST);
            default:
                return ResultUtils.error(CommonErrorEnum.MOVE_TYPE_CODE_INVALID);
        }
    }
}
