package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.HttpStatusConstant;
import cn.wangcaitao.common.constant.PageConstant;
import cn.wangcaitao.common.entity.Pagination;
import cn.wangcaitao.common.entity.Result;
import cn.wangcaitao.common.exception.ResultException;
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
        Assert.assertEquals(HttpStatusConstant.OK_CODE, defaultResult.getCode());
        Assert.assertEquals(HttpStatusConstant.OK_MSG, defaultResult.getMsg());
        Assert.assertNull(defaultResult.getData());

        String data = "hello world";
        Result<String> customizeDataResult = ResultUtils.success(data);
        Assert.assertEquals(HttpStatusConstant.OK_CODE, customizeDataResult.getCode());
        Assert.assertEquals(HttpStatusConstant.OK_MSG, customizeDataResult.getMsg());
        Assert.assertEquals(data, customizeDataResult.getData());

        String msg = "pass success";
        Result<String> customizeMsgAndDataResult = ResultUtils.success(msg, data);
        Assert.assertEquals(HttpStatusConstant.OK_CODE, customizeMsgAndDataResult.getCode());
        Assert.assertEquals(msg, customizeMsgAndDataResult.getMsg());
        Assert.assertEquals(data, customizeMsgAndDataResult.getData());
    }

    /**
     * 返回失败
     */
    @Test
    public void shouldErrorWhenReturn() {
        Result<Object> defaultResult = ResultUtils.error();
        Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_CODE, defaultResult.getCode());
        Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_MSG, defaultResult.getMsg());
        Assert.assertNull(defaultResult.getData());

        String msg = "pass error";
        Result<Object> customizeMsgResult = ResultUtils.error(msg);
        Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_CODE, customizeMsgResult.getCode());
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
        Assert.assertEquals(HttpStatusConstant.OK_CODE, defaultPaginationResult.getCode());
        Assert.assertEquals(HttpStatusConstant.OK_MSG, defaultPaginationResult.getMsg());
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
        Assert.assertEquals(HttpStatusConstant.OK_CODE, defaultPaginationWithDataResult.getCode());
        Assert.assertEquals(HttpStatusConstant.OK_MSG, defaultPaginationWithDataResult.getMsg());
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
        Assert.assertEquals(HttpStatusConstant.OK_CODE, customizePaginationResult.getCode());
        Assert.assertEquals(HttpStatusConstant.OK_MSG, customizePaginationResult.getMsg());
        Pagination<String> customizePagination = customizePaginationResult.getData();
        Assert.assertEquals(pageNum, customizePagination.getPageNum());
        Assert.assertEquals(pageSize, customizePagination.getPageSize());
        Assert.assertEquals(listSize / pageSize + 1, customizePagination.getPages());
        Assert.assertEquals(listSize, customizePagination.getRows());
        List<String> customizePaginationData = customizePagination.getData();
        Assert.assertEquals(data, customizePaginationData.get(0));
    }

    @Test
    public void shouldSuccessWhenGetData() {
        try {
            ResultUtils.getData(null);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_CODE, e.getCode());
            Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_MSG, e.getMsg());
        }

        String data = "test";
        Result<String> result = ResultUtils.success(data);
        Assert.assertEquals(data, ResultUtils.getData(result));

        result = ResultUtils.error();
        try {
            ResultUtils.getData(result);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_CODE, e.getCode());
            Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_MSG, e.getMsg());
        }
    }

    @Test
    public void shouldSuccessWhenGetPaginationData() {
        try {
            ResultUtils.getPaginationData(null);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_CODE, e.getCode());
            Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_MSG, e.getMsg());
        }

        try {
            Pagination<String> defaultPagination = ResultUtils.getPagination(ResultUtils.success(null));
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_CODE, e.getCode());
            Assert.assertEquals(HttpStatusConstant.INTERNAL_SERVER_ERROR_MSG, e.getMsg());
        }

        List<String> list = new ArrayList<>();
        String data = "first";
        list.add(data);
        int listSize = list.size();
        List<String> defaultPaginationData = ResultUtils.getPaginationData(ResultUtils.success(new Pagination<>(listSize, list)));
        Assert.assertEquals(data, defaultPaginationData.get(0));
    }

    @Test
    public void shouldSuccessWhenReturnPagination() {
        int pageNum = 1;
        int pageSize = 10;
        long pages = 2;
        long rows = 11;
        List<String> list = new ArrayList<>();
        String data = "first";
        list.add(data);
        Result<List<String>> paginationResult = ResultUtils.pagination(rows, list);
        Assert.assertEquals(HttpStatusConstant.OK_CODE, paginationResult.getCode());
        Assert.assertEquals(HttpStatusConstant.OK_MSG, paginationResult.getMsg());
        Assert.assertEquals(pageNum, paginationResult.getPageNum().intValue());
        Assert.assertEquals(pageSize, paginationResult.getPageSize().intValue());
        Assert.assertEquals(pages, paginationResult.getPages().longValue());
        Assert.assertEquals(rows, paginationResult.getRows().longValue());
        Assert.assertEquals(data, paginationResult.getData().get(0));

        Result<List<String>> paginationResult2 = ResultUtils.pagination(pageNum, pageSize, rows, list);
        Assert.assertEquals(HttpStatusConstant.OK_CODE, paginationResult2.getCode());
        Assert.assertEquals(HttpStatusConstant.OK_MSG, paginationResult2.getMsg());
        Assert.assertEquals(pageNum, paginationResult2.getPageNum().intValue());
        Assert.assertEquals(pageSize, paginationResult2.getPageSize().intValue());
        Assert.assertEquals(pages, paginationResult2.getPages().longValue());
        Assert.assertEquals(rows, paginationResult2.getRows().longValue());
        Assert.assertEquals(data, paginationResult2.getData().get(0));

        Result<List<String>> paginationResult3 = ResultUtils.pagination(pageNum, pageSize, pages, rows, list);
        Assert.assertEquals(HttpStatusConstant.OK_CODE, paginationResult3.getCode());
        Assert.assertEquals(HttpStatusConstant.OK_MSG, paginationResult3.getMsg());
        Assert.assertEquals(pageNum, paginationResult3.getPageNum().intValue());
        Assert.assertEquals(pageSize, paginationResult3.getPageSize().intValue());
        Assert.assertEquals(pages, paginationResult3.getPages().longValue());
        Assert.assertEquals(rows, paginationResult3.getRows().longValue());
        Assert.assertEquals(data, paginationResult3.getData().get(0));

    }
}