package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.DictCodeConstant;
import cn.wangcaitao.common.constant.ErrorCodeEnum;
import cn.wangcaitao.common.entity.Result;

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
    public static Result judgeMoveTypeCode(String typeCode) {
        switch (typeCode) {
            case DictCodeConstant.MOVE_TYPE_UP:
                return ResultUtils.error(ErrorCodeEnum.FISRT.getCode(), ErrorCodeEnum.FISRT.getMsg());
            case DictCodeConstant.MOVE_TYPE_DOWN:
                return ResultUtils.error(ErrorCodeEnum.LAST.getCode(), ErrorCodeEnum.LAST.getMsg());
            default:
                return ResultUtils.error(ErrorCodeEnum.MOVE_TYPE_CODE_INVALID.getCode(), ErrorCodeEnum.MOVE_TYPE_CODE_INVALID.getMsg());
        }
    }
}
