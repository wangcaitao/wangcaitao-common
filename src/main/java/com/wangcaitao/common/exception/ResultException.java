package com.wangcaitao.common.exception;

import com.wangcaitao.common.constant.ErrorEnum;
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
    private int code;

    /**
     * 说明
     */
    private String msg;

    /**
     * 请求参数
     */
    private String params;

    public ResultException() {
        this.code = HttpStatusConstant.INTERNAL_SERVER_ERROR_CODE;
        this.msg = HttpStatusConstant.INTERNAL_SERVER_ERROR_MSG;
    }

    public ResultException(ErrorEnum errorEnum) {
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
    }

    public ResultException(ErrorEnum errorEnum, String params) {
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
        this.params = params;
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
