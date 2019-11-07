package com.wangcaitao.common.constant;

/**
 * @author wangcaitao
 */
public interface ErrorEnum {

    /**
     * get code
     *
     * @return code
     */
    default int getCode() {
        return HttpStatusConstant.INTERNAL_SERVER_ERROR_CODE;
    }

    /**
     * get msg
     *
     * @return mgs
     */
    default String getMsg() {
        return HttpStatusConstant.INTERNAL_SERVER_ERROR_MSG;
    }
}
