package com.wangcaitao.common.exception;

import com.wangcaitao.common.constant.HttpStatusConstant;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回结果异常
 *
 * @author wangcaitao
 */
@Getter
@Setter
public class ResultException extends RuntimeException {

    /**
     * 状态码
     */
    private int code = HttpStatusConstant.INTERNAL_SERVER_ERROR_CODE;

    /**
     * 说明
     */
    private String msg = HttpStatusConstant.INTERNAL_SERVER_ERROR_MSG;

    /**
     * 请求参数
     */
    private String params;

    public ResultException() {
    }

    public ResultException(String msg) {
        this.code = HttpStatusConstant.BAD_REQUEST_CODE;
        this.msg = msg;
    }

    public ResultException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultException(int code, String msg, String params) {
        this.code = code;
        this.msg = msg;
        this.params = params;
    }
}
