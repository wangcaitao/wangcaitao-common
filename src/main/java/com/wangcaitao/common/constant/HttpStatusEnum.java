package com.wangcaitao.common.constant;

/**
 * @author wangcaitao
 */
public enum HttpStatusEnum implements ErrorEnum {

    /**
     * 200: 请求成功
     */
    OK(200, "请求成功"),

    /**
     * 400: 请求错误
     */
    BAD_REQUEST(400, "请求错误"),

    /**
     * 401: 请登录
     */
    UNAUTHORIZED(401, "请登录"),

    /**
     * 403: 权限不足
     */
    FORBIDDEN(403, "权限不足"),

    /**
     * 404: 资源不存在
     */
    NOT_FOUND(404, "资源不存在"),

    /**
     * 405: 请求方式错误
     */
    METHOD_NOT_ALLOWED(405, "请求方式错误"),

    /**
     * 415: Content-Type 错误
     */
    UNSUPPORTED_MEDIA_TYPE(415, "Content-Type 错误"),

    /**
     * 500: 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    ;

    /**
     * 编码
     */
    private int code;

    /**
     * 说明
     */
    private String msg;

    HttpStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
