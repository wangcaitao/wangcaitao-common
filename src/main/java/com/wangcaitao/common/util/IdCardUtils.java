package com.wangcaitao.common.util;

import com.wangcaitao.common.constant.ErrorCodeEnum;
import com.wangcaitao.common.exception.ResultException;
import com.wangcaitao.common.util.validate.StringValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

/**
 * 身份证工具
 *
 * @author wangcaitao
 */
@Slf4j
public class IdCardUtils {

    /**
     * 长度 18
     */
    private static final int LENGTH_18 = 18;

    /**
     * 长度 15
     */
    private static final int LENGTH_15 = 15;

    /**
     * 第一位到第十七位的系数
     */
    private static final int[] COEFFICIENT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     * 第 18 位校验码
     */
    private static final String[] VERIFY_CODE = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    /**
     * 15 位正则表达式
     */
    private static final String PATTERN_15 = "^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$";

    /**
     * 18 位正则表达式
     */
    private static final String PATTERN_18 = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";

    /**
     * 校验身份证号码是否有效
     *
     * @param idCardNo 身份证号码
     */
    public static void validate(String idCardNo) {
        StringValidateUtils.notBlack(idCardNo, "身份证号码");

        int length = idCardNo.length();
        if (length == LENGTH_15) {
            if (!Pattern.matches(PATTERN_15, idCardNo)) {
                throw new ResultException(ErrorCodeEnum.ID_CARD_NO_INVALID.getCode(), ErrorCodeEnum.ID_CARD_NO_INVALID.getMsg());
            }
        } else if (length == LENGTH_18) {
            if (!Pattern.matches(PATTERN_18, idCardNo)) {
                throw new ResultException(ErrorCodeEnum.ID_CARD_NO_INVALID.getCode(), ErrorCodeEnum.ID_CARD_NO_INVALID.getMsg());
            }

            // region 求和
            int sum = 0;
            try {
                for (int i = 0; i < length - 1; i++) {
                    sum += Integer.valueOf(String.valueOf(idCardNo.charAt(i))) * COEFFICIENT[i];
                }
            } catch (NumberFormatException e) {
                throw new ResultException(ErrorCodeEnum.ID_CARD_NO_INVALID.getCode(), ErrorCodeEnum.ID_CARD_NO_INVALID.getMsg());
            }
            // endregion

            if (!VERIFY_CODE[sum % VERIFY_CODE.length].equalsIgnoreCase(String.valueOf(idCardNo.charAt(LENGTH_18 - 1)))) {
                throw new ResultException(ErrorCodeEnum.ID_CARD_NO_INVALID.getCode(), ErrorCodeEnum.ID_CARD_NO_INVALID.getMsg());
            }
        } else {
            throw new ResultException(ErrorCodeEnum.ID_CARD_NO_INVALID.getCode(), ErrorCodeEnum.ID_CARD_NO_INVALID.getMsg());
        }
    }

    /**
     * 获取生日. yyyyMMdd
     *
     * @param idCardNo 身份证号码
     * @return 生日
     */
    public static String getBirthday(String idCardNo) {
        String birthday;
        int length = idCardNo.length();
        if (length == LENGTH_15) {
            birthday = "19" + idCardNo.substring(6, 12);
        } else if (length == LENGTH_18) {
            birthday = idCardNo.substring(6, 14);
        } else {
            birthday = "";
        }

        return birthday;
    }

    /**
     * 获取年龄
     *
     * @param idCardNo 身份证号码
     * @return 年龄. 为 0 未无效
     */
    public static long getAge(String idCardNo) {
        String birthday = getBirthday(idCardNo);
        if (StringUtils.isEmpty(birthday)) {
            return 0L;
        }

        return ChronoUnit.YEARS.between(LocalDate.from(DateTimeFormatter.ofPattern("yyyyMMdd").parse(birthday)), LocalDate.now());
    }

    /**
     * 获取性别. 0: 女, 1: 男, 2: 未知
     *
     * @param idCardNo 身份证号码
     * @return 性别
     */
    public static String getSexCode(String idCardNo) {
        int sex;
        int length = idCardNo.length();
        if (length == LENGTH_15) {
            sex = Integer.valueOf(String.valueOf(idCardNo.charAt(14)));
        } else if (length == LENGTH_18) {
            sex = Integer.valueOf(String.valueOf(idCardNo.charAt(16)));
        } else {
            return "2";
        }

        return sex % 2 == 0 ? "0" : "1";
    }
}
