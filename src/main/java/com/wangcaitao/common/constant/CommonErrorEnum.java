package com.wangcaitao.common.constant;

/**
 * 错误编码
 *
 * @author wangcaitao
 */
public enum CommonErrorEnum implements ErrorEnum {

    /**
     * 最大每页大小 100
     */
    PAGE_SIZE_OVER_MAX("最大每页大小 100"),

    /**
     * typeCode 无效
     */
    MOVE_TYPE_CODE_INVALID("typeCode 无效"),

    /**
     * 已经是第一个了
     */
    FIRST("已经是第一个了"),

    /**
     * 已经是最后一个了
     */
    LAST("已经是最后一个了"),

    /**
     * 暂不支持分页查询
     */
    NOT_SUPPORT_PAGINATION_QUERY("暂不支持分页查询"),

    /**
     * 暂不支持列表查询
     */
    NOT_SUPPORT_LIST_QUERY("暂不支持列表查询"),

    /**
     * 该资源不能修改
     */
    NOT_SUPPORT_UPDATE("该资源不能修改"),

    /**
     * 该资源不能删除
     */
    NOT_SUPPORT_DELETE("该资源不能删除"),

    /**
     * 不支持移动
     */
    NOT_SUPPORT_MOVE("不支持移动"),

    /**
     * 身份证号码无效, 请核对
     */
    ID_CARD_NO_INVALID("身份证号码无效, 请核对"),
    ;

    /**
     * 编码
     */
    private int code;

    /**
     * 说明
     */
    private String msg;

    CommonErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    CommonErrorEnum(String msg) {
        this.code = 400;
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
