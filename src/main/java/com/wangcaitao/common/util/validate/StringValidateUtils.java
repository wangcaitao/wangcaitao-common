package com.wangcaitao.common.util.validate;

import com.wangcaitao.common.exception.ResultException;
import org.apache.commons.lang3.StringUtils;

/**
 * 字符串校验工具
 *
 * @author wangcaitao
 */
public class StringValidateUtils {

    /**
     * 不能为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void notEmpty(String param, String paramComment) {
        if (StringUtils.isEmpty(param)) {
            throw new ResultException(paramComment + " 不能为空");
        }
    }

    /**
     * 不能为空
     *
     * @param param        参数
     * @param paramComment 参数描述
     */
    public static void notBlack(String param, String paramComment) {
        if (StringUtils.isBlank(param)) {
            throw new ResultException(paramComment + " 不能为空");
        }
    }

    /**
     * 不能为空<br>
     * 长度不能大于指定值<br>
     * 使用场景: 保存入库时
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param blank        是否以 blank 标准判断为空. false: 不是, true: 是
     * @param emptyString  是否可以为空字符串. false: 不可以, true: 可以
     * @param maxLength    最大字符长度. 只有大于 0 才会判断生效
     */
    public static void notEmptyAndLength(String param, String paramComment, boolean blank, boolean emptyString, int maxLength) {
        boolean isEmpty = blank ? StringUtils.isBlank(param) : StringUtils.isEmpty(param);
        if (isEmpty) {
            if (!emptyString) {
                throw new ResultException(paramComment + " 不能为空");
            }
        } else {
            if (maxLength > 0 && param.length() > maxLength) {
                throw new ResultException(paramComment + " 最大 " + maxLength + " 个字符");
            }
        }
    }

    /**
     * 长度不能大于指定值<br>
     * 使用场景: 修改入库时
     *
     * @param param        参数
     * @param paramComment 参数描述
     * @param blank        是否以 blank 标准判断为空. false: 不是, true: 是
     * @param emptyString  是否可以为空字符串. false: 不可以, true: 可以
     * @param maxLength    最大字符长度. 只有大于 0 才会判断生效
     * @return 原参数. 当字符串为空, 且 emptyString = false 时, 返回 null
     */
    public static String length(String param, String paramComment, boolean blank, boolean emptyString, int maxLength) {
        boolean isEmpty = blank ? StringUtils.isBlank(param) : StringUtils.isEmpty(param);
        if (isEmpty) {
            if (!emptyString) {
                param = null;
            }
        } else {
            if (maxLength > 0 && param.length() > maxLength) {
                throw new ResultException(paramComment + " 最大 " + maxLength + " 个字符");
            }
        }

        return param;
    }
}
