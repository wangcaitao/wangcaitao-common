package cn.wangcaitao.common.exception;

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
