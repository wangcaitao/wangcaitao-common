package cn.wangcaitao.common.entity;

import cn.wangcaitao.common.constant.BadRequestMsgConstant;
import cn.wangcaitao.common.constant.PageConstant;
import cn.wangcaitao.common.constant.ResultConstant;
import cn.wangcaitao.common.exception.ResultException;
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
            throw new ResultException(ResultConstant.BAD_REQUEST_CODE, BadRequestMsgConstant.OVER_MAX_PAGE_SIZE);
        }
    }
}