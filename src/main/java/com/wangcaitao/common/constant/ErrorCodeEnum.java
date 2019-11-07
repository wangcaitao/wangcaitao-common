package com.wangcaitao.common.constant;

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
    LAST(1002, "已经是最后一个了"),

    /**
     * 1003 - 暂不支持分页查询
     */
    NOT_SUPPORT_PAGINATION_QUERY(1003, "暂不支持分页查询"),

    /**
     * 1004 - 暂不支持列表查询
     */
    NOT_SUPPORT_LIST_QUERY(1004, "暂不支持列表查询"),

    /**
     * 100403 - 该资源不能修改
     */
    NOT_SUPPORT_UPDATE(1005, "该资源不能修改"),

    /**
     * 1006 - 该资源不能删除
     */
    NOT_SUPPORT_DELETE(1006, "该资源不能删除"),

    /**
     * 1007 - 不支持移动
     */
    NOT_SUPPORT_MOVE(1007, "不支持移动"),

    /**
     * 1008 - 身份证号码无效, 请核对
     */
    ID_CARD_NO_INVALID(1008, "身份证号码无效, 请核对"),
    ;

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
