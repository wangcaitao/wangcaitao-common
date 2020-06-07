package com.wangcaitao.common.util;

import com.wangcaitao.common.constant.CommonDictCodeConstant;
import com.wangcaitao.common.constant.CommonErrorEnum;
import com.wangcaitao.common.exception.ResultException;

/**
 * 公共条件判断工具
 *
 * @author wangcaitao
 */
public class ConditionUtils {

    /**
     * 对移动编码错误处理
     *
     * @param moveTypeCode moveTypeCode
     */
    public static void judgeMoveTypeCode(int moveTypeCode) {
        switch (moveTypeCode) {
            case CommonDictCodeConstant.MOVE_TYPE_UP:
                throw new ResultException(CommonErrorEnum.FIRST);
            case CommonDictCodeConstant.MOVE_TYPE_DOWN:
                throw new ResultException(CommonErrorEnum.LAST);
            default:
                throw new ResultException(CommonErrorEnum.MOVE_TYPE_CODE_INVALID);
        }
    }
}
