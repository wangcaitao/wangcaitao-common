package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.HttpStatusConstant;
import cn.wangcaitao.common.exception.ResultException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

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
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, "id 不能为空");
        }

        if (1 > id) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, "id 无效");
        }
    }

    /**
     * 校验字符串
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateStringEmpty(String param, String paramComment) {
        validateStringEmpty(param, paramComment, false);
    }

    /**
     * 校验字符串
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param emptyString  是否可以为空字符串. 0: 不可以, 1: 可以
     */
    public static void validateStringEmpty(String param, String paramComment, boolean emptyString) {
        if (StringUtils.isEmpty(param) && !emptyString) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, paramComment + " 不能为空");
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
        validateStringEmpty(param, paramComment, maxLength, false);
    }

    /**
     * 校验字符串
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     * @param emptyString  是否可以为空字符串. 0: 不可以, 1: 可以
     */
    public static void validateStringEmpty(String param, String paramComment, int maxLength, boolean emptyString) {
        validateStringEmpty(param, paramComment, emptyString);

        if (StringUtils.isNotEmpty(param) && maxLength < param.length()) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, paramComment + " 最大 " + maxLength + " 个字符");
        }
    }

    /**
     * 校验字符串
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateStringBlank(String param, String paramComment) {
        validateStringBlank(param, paramComment, false);
    }

    /**
     * 校验字符串
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param emptyString  是否可以为空字符串. 0: 不可以, 1: 可以
     */
    public static void validateStringBlank(String param, String paramComment, boolean emptyString) {
        if (StringUtils.isBlank(param) && !emptyString) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, paramComment + " 不能为空");
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
        validateStringBlank(param, paramComment, maxLength, false);
    }

    /**
     * 校验字符串
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     * @param emptyString  是否可以为空字符串. 0: 不可以, 1: 可以
     */
    public static void validateStringBlank(String param, String paramComment, int maxLength, boolean emptyString) {
        validateStringBlank(param, paramComment, emptyString);

        if (StringUtils.isNotBlank(param) && maxLength < param.length()) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, paramComment + " 最大 " + maxLength + " 个字符");
        }
    }

    /**
     * 校验 Object 是否为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateObjectNull(Object param, String paramComment) {
        validateObjectNull(param, paramComment, false);
    }

    /**
     * 校验 Object 是否为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param nullObject   是否可以为 null. 0: 不可以, 1: 可以
     */
    public static void validateObjectNull(Object param, String paramComment, boolean nullObject) {
        if (null == param && !nullObject) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, paramComment + " 不能为空");
        }
    }

    /**
     * 校验列表是否为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateListEmpty(List param, String paramComment) {
        validateListEmpty(param, paramComment, false);
    }

    /**
     * 校验列表是否为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param emptyList    是否可以为空. 0: 不可以, 1: 可以
     */
    public static void validateListEmpty(List param, String paramComment, boolean emptyList) {
        boolean isEmptyList = (null == param || param.isEmpty());
        if (isEmptyList && !emptyList) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, paramComment + " 不能为空");
        }
    }

    /**
     * 校验数组是否为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateArrayEmpty(Object[] param, String paramComment) {
        validateArrayEmpty(param, paramComment, false);
    }

    /**
     * 校验数组是否为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateArrayEmpty(Object[] param, String paramComment, boolean emptyArray) {
        boolean isEmptyArray = (null == param || 0 == param.length);
        if (isEmptyArray && !emptyArray) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, paramComment + " 不能为空");
        }
    }
}
