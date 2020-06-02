package com.wangcaitao.common.entity;

import com.wangcaitao.common.constant.HttpStatusConstant;
import com.wangcaitao.common.constant.PageConstant;
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
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页大小
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Long pages;

    /**
     * 总行数
     */
    private Long rows;

    /**
     * 数据
     */
    private T data;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Long rows, T data) {
        this.code = HttpStatusConstant.OK_CODE;
        this.msg = HttpStatusConstant.OK_MSG;
        this.pageNum = PageConstant.DEFAULT_PAGE_NUM;
        this.pageSize = PageConstant.DEFAULT_PAGE_SIZE;
        this.rows = 0 >= rows ? 0 : rows;
        this.pages = (rows + this.pageSize - 1) / this.pageSize;
        this.data = data;
    }

    public Result(Integer pageNum, Integer pageSize, Long rows, T data) {
        this.code = HttpStatusConstant.OK_CODE;
        this.msg = HttpStatusConstant.OK_MSG;
        this.pageNum = 0 >= pageNum ? 1 : pageNum;
        this.pageSize = 0 >= pageSize ? 10 : pageSize;
        this.rows = 0 >= rows ? 0 : rows;
        this.pages = (rows + this.pageSize - 1) / this.pageSize;
        this.data = data;
    }

    public Result(Integer pageNum, Integer pageSize, Long pages, Long rows, T data) {
        this.code = HttpStatusConstant.OK_CODE;
        this.msg = HttpStatusConstant.OK_MSG;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = pages;
        this.rows = rows;
        this.data = data;
    }
}
