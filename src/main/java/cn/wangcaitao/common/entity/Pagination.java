package cn.wangcaitao.common.entity;

import cn.wangcaitao.common.constant.PageConstant;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 分页
 *
 * @author wangcaitao
 */
@Getter
@Setter
@NoArgsConstructor
@JSONType(
        orders = {"pageNum", "pageSize", "pages", "rows", "data"}
)
public class Pagination<T> {

    /**
     * 当前页码
     */
    private int pageNum = PageConstant.DEFAULT_PAGE_NUM;

    /**
     * 每页大小
     */
    private int pageSize = PageConstant.DEFAULT_PAGE_SIZE;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 总行数
     */
    private long rows;

    /**
     * 数据
     */
    private List<T> data;

    /**
     * constructor
     *
     * @param rows 总行数
     * @param data 数据
     */
    public Pagination(long rows, List<T> data) {
        this.rows = 0 >= rows ? 0 : rows;
        this.pages = (rows + this.pageSize - 1) / this.pageSize;
        this.data = data;
    }

    /**
     * constructor
     *
     * @param pageNum  当前页码
     * @param pageSize 每页大小
     * @param rows     总行数
     * @param data     数据
     */
    public Pagination(int pageNum, int pageSize, long rows, List<T> data) {
        this.pageNum = 0 >= pageNum ? 1 : pageNum;
        this.pageSize = 0 >= pageSize ? 10 : pageSize;
        this.rows = 0 >= rows ? 0 : rows;
        this.pages = (rows + this.pageSize - 1) / this.pageSize;
        this.data = data;
    }

    /**
     * constructor
     *
     * @param pageNum  当前页码
     * @param pageSize 每页大小
     * @param pages    总页数
     * @param rows     总行数
     * @param data     数据
     */
    public Pagination(int pageNum, int pageSize, long pages, long rows, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = pages;
        this.rows = rows;
        this.data = data;
    }
}
