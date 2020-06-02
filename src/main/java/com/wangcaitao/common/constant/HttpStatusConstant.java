package com.wangcaitao.common.constant;

/**
 * 状态码常量
 *
 * @author wangcaitao
 */
public class HttpStatusConstant {

    /**
     * 成功编码
     */
    public static final int OK_CODE = 200;

    /**
     * 成功消息
     */
    public static final String OK_MSG = "请求成功";

    /**
     * 错误请求编码
     */
    public static final int BAD_REQUEST_CODE = 400;

    /**
     * 参数请求消息
     */
    public static final String BAD_REQUEST_MSG = "参数错误";

    /**
     * 未登录编码
     */
    public static final int UNAUTHORIZED_CODE = 401;

    /**
     * 未认证消息
     */
    public static final String UNAUTHORIZED_MSG = "未认证";

    /**
     * 未授权编码
     */
    public static final int FORBIDDEN_CODE = 403;

    /**
     * 未授权消息
     */
    public static final String FORBIDDEN_MSG = "权限不足";

    /**
     * 资源不存在编码
     */
    public static final int NOT_FOUND_CODE = 404;

    /**
     * 资源不存在消息
     */
    public static final String NOT_FOUND_MSG = "资源不存在";

    /**
     * 请求方式编码
     */
    public static final int METHOD_NOT_ALLOWED_CODE = 405;

    /**
     * 请求方式消息
     */
    public static final String METHOD_NOT_ALLOWED_MSG = "请求方式错误";

    /**
     * Content-Type 错误编码
     */
    public static final int UNSUPPORTED_MEDIA_TYPE_CODE = 415;

    /**
     * Content-Type 错误消息
     */
    public static final String UNSUPPORTED_MEDIA_TYPE_MSG = "Content-Type 错误";

    /**
     * 服务器内部错误编码
     */
    public static final int INTERNAL_SERVER_ERROR_CODE = 500;

    /**
     * 服务器内部错误消息
     */
    public static final String INTERNAL_SERVER_ERROR_MSG = "服务器内部错误";
}
