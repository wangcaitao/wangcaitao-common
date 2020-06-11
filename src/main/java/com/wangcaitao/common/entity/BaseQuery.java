package com.wangcaitao.common.entity;

import com.wangcaitao.common.constant.PageConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * 基础查询
 *
 * @author wangcaitao
 */
@Data
public class BaseQuery implements Serializable {
    private static final long serialVersionUID = 7718625033381773834L;

    /**
     * 当前页码，默认第 1 页
     */
    private Integer pageNum;

    /**
     * 每页大小，默认每页 10 条
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
