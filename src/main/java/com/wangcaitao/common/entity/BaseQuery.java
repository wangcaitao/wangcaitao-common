package com.wangcaitao.common.entity;

import com.wangcaitao.common.constant.BadRequestMsgConstant;
import com.wangcaitao.common.constant.HttpStatusConstant;
import com.wangcaitao.common.constant.PageConstant;
import com.wangcaitao.common.exception.ResultException;
import lombok.Data;

/**
 * 基础查询
 *
 * @author wangcaitao
 */
@Data
public class BaseQuery {

    /**
     * 当前页码，默认第1页
     */
    private Integer pageNum = PageConstant.DEFAULT_PAGE_NUM;

    /**
     * 每页大小，默认每页10条
     */
    private Integer pageSize = PageConstant.DEFAULT_PAGE_SIZE;

    /**
     * 升序列名
     */
    private String[] orderByAscColumns;

    /**
     * 降序列名
     */
    private String[] orderByDescColumns;

    /**
     * 是否需要分页, 默认分页. 0: 不需要, 1: 需要
     */
    private Boolean pagination;

    /**
     * 参数校验
     */
    public void validate() {
        validate(true);
    }

    /**
     * 参数校验
     *
     * @param isValidatePageSize 是否校验每页大小
     */
    public void validate(boolean isValidatePageSize) {
        if (isValidatePageSize && pageSize > PageConstant.MAX_PAGE_SIZE) {
            throw new ResultException(HttpStatusConstant.BAD_REQUEST_CODE, BadRequestMsgConstant.OVER_MAX_PAGE_SIZE);
        }
    }

    /**
     * set pagination
     *
     * @return pagination
     */
    public Boolean getPagination() {
        return null == pagination ? true : this.pagination;
    }
}
