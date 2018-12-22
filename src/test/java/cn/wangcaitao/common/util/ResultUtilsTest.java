package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.PageConstant;
import cn.wangcaitao.common.constant.ResultConstant;
import cn.wangcaitao.common.entity.Pagination;
import cn.wangcaitao.common.entity.Result;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * result 工具测试
 *
 * @author wangcaitao
 */
public class ResultUtilsTest {
    /**
     * 返回成功
     */
    @Test
    public void shouldSuccessWhenReturn() {
        Result<Object> defaultResult = ResultUtils.success();
        Assert.assertEquals(ResultConstant.OK_CODE, defaultResult.getCode());
        Assert.assertEquals(ResultConstant.OK_MSG, defaultResult.getMsg());
        Assert.assertNull(defaultResult.getData());

        String data = "hello world";
        Result<String> customizeDataResult = ResultUtils.success(data);
        Assert.assertEquals(ResultConstant.OK_CODE, customizeDataResult.getCode());
        Assert.assertEquals(ResultConstant.OK_MSG, customizeDataResult.getMsg());
        Assert.assertEquals(data, customizeDataResult.getData());

        String msg = "pass success";
        Result<String> customizeMsgAndDataResult = ResultUtils.success(msg, data);
        Assert.assertEquals(ResultConstant.OK_CODE, customizeMsgAndDataResult.getCode());
        Assert.assertEquals(msg, customizeMsgAndDataResult.getMsg());
        Assert.assertEquals(data, customizeMsgAndDataResult.getData());
    }

    /**
     * 返回失败
     */
    @Test
    public void shouldErrorWhenReturn() {
        Result<Object> defaultResult = ResultUtils.error();
        Assert.assertEquals(ResultConstant.BAD_REQUEST_CODE, defaultResult.getCode());
        Assert.assertEquals(ResultConstant.BAD_REQUEST_MSG, defaultResult.getMsg());
        Assert.assertNull(defaultResult.getData());

        String msg = "pass error";
        Result<Object> customizeMsgResult = ResultUtils.error(msg);
        Assert.assertEquals(ResultConstant.BAD_REQUEST_CODE, customizeMsgResult.getCode());
        Assert.assertEquals(msg, customizeMsgResult.getMsg());
        Assert.assertNull(customizeMsgResult.getData());

        int code = 4001;
        Result<Object> customizeCodeAndMsgResult = ResultUtils.error(code, msg);
        Assert.assertEquals(code, customizeCodeAndMsgResult.getCode());
        Assert.assertEquals(msg, customizeCodeAndMsgResult.getMsg());
        Assert.assertNull(customizeCodeAndMsgResult.getData());

        String data = "hello world";
        Result<String> customizeCodeAndMsgAndDataResult = ResultUtils.error(code, msg, data);
        Assert.assertEquals(code, customizeCodeAndMsgAndDataResult.getCode());
        Assert.assertEquals(msg, customizeCodeAndMsgAndDataResult.getMsg());
        Assert.assertEquals(data, customizeCodeAndMsgAndDataResult.getData());
    }

    /**
     * 返回分页
     */
    @Test
    public void shouldSuccessWhenPagination() {
        Result<Pagination<Object>> defaultPaginationResult = ResultUtils.success(new Pagination<>());
        Assert.assertEquals(ResultConstant.OK_CODE, defaultPaginationResult.getCode());
        Assert.assertEquals(ResultConstant.OK_MSG, defaultPaginationResult.getMsg());
        Pagination<Object> defaultPagination = defaultPaginationResult.getData();
        Assert.assertEquals(PageConstant.DEFAULT_PAGE_NUM, defaultPagination.getPageNum());
        Assert.assertEquals(PageConstant.DEFAULT_PAGE_SIZE, defaultPagination.getPageSize());
        Assert.assertEquals(0L, defaultPagination.getPages());
        Assert.assertEquals(0L, defaultPagination.getRows());
        Assert.assertNull(defaultPagination.getData());

        List<String> list = new ArrayList<>();
        String data = "first";
        list.add(data);
        int listSize = list.size();

        Result<Pagination<String>> defaultPaginationWithDataResult = ResultUtils.success(new Pagination<>(listSize, list));
        Assert.assertEquals(ResultConstant.OK_CODE, defaultPaginationWithDataResult.getCode());
        Assert.assertEquals(ResultConstant.OK_MSG, defaultPaginationWithDataResult.getMsg());
        Pagination<String> defaultPaginationWithData = defaultPaginationWithDataResult.getData();
        Assert.assertEquals(PageConstant.DEFAULT_PAGE_NUM, defaultPaginationWithData.getPageNum());
        Assert.assertEquals(PageConstant.DEFAULT_PAGE_SIZE, defaultPaginationWithData.getPageSize());
        Assert.assertEquals(listSize / PageConstant.DEFAULT_PAGE_SIZE + 1, defaultPaginationWithData.getPages());
        Assert.assertEquals(listSize, defaultPaginationWithData.getRows());
        List<String> defaultPaginationData = defaultPaginationWithData.getData();
        Assert.assertEquals(data, defaultPaginationData.get(0));

        int pageNum = 2;
        int pageSize = 20;

        Result<Pagination<String>> customizePaginationResult = ResultUtils.success(new Pagination<>(pageNum, pageSize, listSize, list));
        Assert.assertEquals(ResultConstant.OK_CODE, customizePaginationResult.getCode());
        Assert.assertEquals(ResultConstant.OK_MSG, customizePaginationResult.getMsg());
        Pagination<String> customizePagination = customizePaginationResult.getData();
        Assert.assertEquals(pageNum, customizePagination.getPageNum());
        Assert.assertEquals(pageSize, customizePagination.getPageSize());
        Assert.assertEquals(listSize / pageSize + 1, customizePagination.getPages());
        Assert.assertEquals(listSize, customizePagination.getRows());
        List<String> customizePaginationData = customizePagination.getData();
        Assert.assertEquals(data, customizePaginationData.get(0));
    }
}