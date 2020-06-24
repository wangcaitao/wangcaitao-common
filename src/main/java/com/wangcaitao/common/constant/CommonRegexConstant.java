package com.wangcaitao.common.constant;

/**
 * 公共正则表达式
 *
 * @author wangcaitao
 */
public class CommonRegexConstant {

    /**
     * 手机号码
     */
    public static final String PHONE_NUMBER = "^1[3456789]\\d{9}$";

    /**
     * 邮箱
     */
    public static final String EMAIL = "^([a-zA-Z0-9\\_\\-\\.]+)\\@([a-zA-Z0-9\\_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
}
