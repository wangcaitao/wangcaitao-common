package com.wangcaitao.common.entity;

import com.wangcaitao.common.constant.CommonErrorEnum;
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
    private Integer pageNum;

    /**
     * 每页大小，默认每页10条
     */
    private Integer pageSize;

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
        if (isValidatePageSize && this.getPageSize() > PageConstant.MAX_PAGE_SIZE) {
            throw new ResultException(CommonErrorEnum.PAGE_SIZE_OVER_MAX);
        }
    }

    /**
     * get pagination
     *
     * @return 如果为 NULL, 返回默认值 true
     */
    public Boolean getPagination() {
        return null == this.pagination ? true : this.pagination;
    }

    /**
     * get pageNum
     *
     * @return 如果为 NULL, 返回默认值 1
     */
    public Integer getPageNum() {
        return null == this.pageNum ? PageConstant.DEFAULT_PAGE_NUM : this.pageNum;
    }

    /**
     * get pageSize
     *
     * @return 如果为 NULL, 返回默认值 10
     */
    public Integer getPageSize() {
        return null == this.pageSize ? PageConstant.DEFAULT_PAGE_SIZE : this.pageSize;
    }
}
