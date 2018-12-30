package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.ResultConstant;
import cn.wangcaitao.common.exception.ResultException;
import org.apache.commons.lang3.StringUtils;

/**
 * 基本参数校验
 *
 * @author wangcaitao
 */
public class ParamValidateUtils {

    /**
     * 验证 id
     *
     * @param id id
     */
    public static void validateId(Long id) {
        if (null == id) {
            throw new ResultException(ResultConstant.BAD_REQUEST_CODE, "id 不能为空");
        }

        if (1 > id) {
            throw new ResultException(ResultConstant.BAD_REQUEST_CODE, "id 无效");
        }
    }

    /**
     * 校验字符串
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     */
    public static void validateStringEmpty(String param, String paramComment, int maxLength) {
        if (StringUtils.isEmpty(param)) {
            throw new ResultException(ResultConstant.BAD_REQUEST_CODE, paramComment + " 不能为空");
        }

        if (maxLength < param.length()) {
            throw new ResultException(ResultConstant.BAD_REQUEST_CODE, paramComment + " 最大 " + maxLength + " 个字符");
        }
    }

    /**
     * 校验字符串
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     */
    public static void validateStringBlank(String param, String paramComment, int maxLength) {
        if (StringUtils.isBlank(param)) {
            throw new ResultException(ResultConstant.BAD_REQUEST_CODE, paramComment + " 不能为空");
        }

        if (maxLength < param.length()) {
            throw new ResultException(ResultConstant.BAD_REQUEST_CODE, paramComment + " 最大 " + maxLength + " 个字符");
        }
    }

    /**
     * 校验 Object 是否为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateObjectNull(Object param, String paramComment) {
        if (null == param) {
            throw new ResultException(ResultConstant.BAD_REQUEST_CODE, paramComment + " 不能为空");
        }
    }
}
