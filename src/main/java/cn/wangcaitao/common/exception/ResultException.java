package cn.wangcaitao.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 统一返回结果异常
 *
 * @author wangcaitao
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultException extends RuntimeException {

    /**
     * 状态码
     */
    private int code;

    /**
     * 说明
     */
    private String msg;
}
