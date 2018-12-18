package cn.wangcaitao.common.entity;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 统一返回结果
 *
 * @author wangcaitao
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JSONType(
        orders = {"code", "msg", "data"}
)
public class Result<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 说明
     */
    private String msg;

    /**
     * 数据
     */
    private T data;
}
