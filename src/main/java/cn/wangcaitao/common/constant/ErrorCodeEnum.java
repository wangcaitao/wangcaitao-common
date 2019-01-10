package cn.wangcaitao.common.constant;

/**
 * 公共错误编码: [1000, 1099]
 *
 * @author wangcaitao
 */
public enum ErrorCodeEnum {

    /**
     * 1000 - 移动类型编码无效
     */
    MOVE_TYPE_CODE_INVALID(1000, "移动类型编码无效"),

    /**
     * 1001 - 已经是第一个了
     */
    FISRT(1001, "已经是第一个了"),

    /**
     * 1002 - 已经是最后一个了
     */
    LAST(1002, "已经是最后一个了"),;

    /**
     * 编码
     */
    private int code;

    /**
     * 说明
     */
    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
