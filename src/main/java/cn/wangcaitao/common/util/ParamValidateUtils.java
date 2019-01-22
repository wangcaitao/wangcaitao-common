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
     * 校验 id. 即: 不能为 null, 大于 0
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
     * 校验字符串不能为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateStringEmpty(String param, String paramComment) {
        validateStringEmpty(param, paramComment, true);
    }

    /**
     * 校验字符串不能为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param blank        是否可以为 blank 字符串. 0: 不可以, 1: 可以
     */
    public static void validateStringEmpty(String param, String paramComment, boolean blank) {
        boolean isEmptyString = blank ? StringUtils.isBlank(param) : StringUtils.isEmpty(param);
        if (isEmptyString) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, paramComment + " 不能为空");
        }
    }

    /**
     * 校验字符串长度不能大于指定值
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     */
    public static void validateStringLength(String param, String paramComment, int maxLength) {
        validateStringLength(param, paramComment, maxLength, true);
    }

    /**
     * 校验字符串长度不能大于指定值
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     * @param blank        是否可以为 blank 字符串. 0: 不可以, 1: 可以
     */
    public static void validateStringLength(String param, String paramComment, int maxLength, boolean blank) {
        boolean isEmptyString = blank ? StringUtils.isNotBlank(param) : StringUtils.isNotEmpty(param);
        if (isEmptyString && maxLength < param.length()) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, paramComment + " 最大 " + maxLength + " 个字符");
        }
    }

    /**
     * 校验保存操作字符串. 即: 不能为空, 长度不能大于指定值
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     */
    public static void validateStringWhenSave(String param, String paramComment, int maxLength) {
        validateStringEmpty(param, paramComment);
        validateStringLength(param, paramComment, maxLength);
    }

    /**
     * 校验保存操作字符串. 即: 不能为空, 长度不能大于指定值
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     * @param blank        是否可以为 blank 字符串. 0: 不可以, 1: 可以
     */
    public static void validateStringWhenSave(String param, String paramComment, int maxLength, boolean blank) {
        validateStringEmpty(param, paramComment);
        validateStringLength(param, paramComment, maxLength, blank);
    }

    /**
     * 校验字符串不能为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @return param
     */
    public static String validateString(String param, String paramComment) {
        return validateString(param, paramComment, false);
    }

    /**
     * 校验字符串不能为空. 字符串可以为空, 为空返回 null
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param emptyString  是否可以为空字符串. 0: 不可以, 1: 可以
     * @return param
     */
    public static String validateString(String param, String paramComment, boolean emptyString) {
        return validateString(param, paramComment, emptyString, true);
    }

    /**
     * 校验字符串不能为空. 字符串可以为空, 为空返回 null
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param emptyString  是否可以为空字符串. 0: 不可以, 1: 可以
     * @param blank        是否可以为 blank 字符串. 0: 不可以, 1: 可以
     * @return param
     */
    public static String validateString(String param, String paramComment, boolean emptyString, boolean blank) {
        boolean isEmptyString = blank ? StringUtils.isBlank(param) : StringUtils.isEmpty(param);
        if (isEmptyString) {
            if (emptyString) {
                param = null;
            } else {
                throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, paramComment + " 不能为空");
            }
        }

        return param;
    }

    /**
     * 校验字符串长度不能大于指定值. 字符串可以为空, 为空返回 null
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     * @return param
     */
    public static String validateString(String param, String paramComment, int maxLength) {
        return validateString(param, paramComment, maxLength, false, true);
    }

    /**
     * 校验字符串长度不能大于指定值. 字符串可以为空, 当不可以为空返回 null, 否则返回原始值
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     * @param emptyString  是否可以为空字符串. 0: 不可以, 1: 可以
     * @return param
     */
    public static String validateString(String param, String paramComment, int maxLength, boolean emptyString) {
        return validateString(param, paramComment, maxLength, emptyString, true);
    }

    /**
     * 校验字符串长度不能大于指定值. 字符串可以为空, 当不可以为空返回 null, 否则返回原始值
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param maxLength    最大字符长度
     * @param emptyString  是否可以为空字符串. 0: 不可以, 1: 可以
     * @param blank        是否可以为 blank 字符串. 0: 不可以, 1: 可以
     */
    public static String validateString(String param, String paramComment, int maxLength, boolean emptyString, boolean blank) {
        boolean isEmptyString = blank ? StringUtils.isNotBlank(param) : StringUtils.isNotEmpty(param);
        if (isEmptyString) {
            validateStringLength(param, paramComment, maxLength, blank);
        } else {
            if (!emptyString) {
                param = null;
            }
        }

        return param;
    }

    /**
     * 校验 Object 不能为 null
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateObjectNull(Object param, String paramComment) {
        validateObjectNull(param, paramComment, false);
    }

    /**
     * 校验 Object 不能为 null (Object 不为 null 时校验)
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
     * 校验列表不能为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateListEmpty(List param, String paramComment) {
        validateListEmpty(param, paramComment, false);
    }

    /**
     * 校验列表不能为空 (列表不能为空时校验)
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
     * 校验数组不能为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void validateArrayEmpty(Object[] param, String paramComment) {
        validateArrayEmpty(param, paramComment, false);
    }

    /**
     * 校验数组不能为空 (数组不为空时校验)
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
