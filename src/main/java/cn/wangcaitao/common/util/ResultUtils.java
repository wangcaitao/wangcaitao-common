package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.HttpStatusConstant;
import cn.wangcaitao.common.entity.Pagination;
import cn.wangcaitao.common.entity.Result;
import cn.wangcaitao.common.exception.ResultException;

import java.util.List;

/**
 * 统一返回结果工具类
 *
 * @author wangcaitao
 */
public class ResultUtils {

    /**
     * 请求成功<br>
     * default code: 200<br>
     * default msg: 请求成功<br>
     * default data: null
     *
     * @return Result
     */
    public static <T> Result<T> success() {
        return success(null);
    }

    /**
     * 请求成功<br>
     * default code: 200<br>
     * default msg: 请求成功
     *
     * @param data 数据集合
     * @return Result
     */
    public static <T> Result<T> success(T data) {
        return success(HttpStatusConstant.OK_MSG, data);
    }

    /**
     * 请求成功<br>
     * default code: 200
     *
     * @param msg  消息
     * @param data 数据集合
     * @return Result
     */
    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(HttpStatusConstant.OK_CODE, msg, data);
    }

    /**
     * 请求错误<br>
     * default code: 500<br>
     * default msg: 请求错误
     *
     * @return Result
     */
    public static <T> Result<T> error() {
        return error(HttpStatusConstant.INTERNAL_SERVER_ERROR_MSG);
    }

    /**
     * 请求错误<br>
     * default code: 500<br>
     *
     * @param msg 错误消息
     * @return Result
     */
    public static <T> Result<T> error(String msg) {
        return error(HttpStatusConstant.INTERNAL_SERVER_ERROR_CODE, msg);
    }

    /**
     * 请求错误
     *
     * @param code 返回码
     * @param msg  消息
     * @return Result
     */
    public static <T> Result<T> error(int code, String msg) {
        return error(code, msg, null);
    }

    /**
     * 请求错误
     *
     * @param code 返回码
     * @param msg  消息
     * @param data 数据集合
     * @return Result
     */
    public static <T> Result<T> error(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    /**
     * 返回结果数据
     *
     * @param result Result
     * @return 结果数据
     */
    public static <T> T getData(Result<T> result) {
        if (null == result) {
            throw new ResultException();
        }

        if (HttpStatusConstant.OK_CODE == result.getCode()) {
            return result.getData();
        } else {
            throw new ResultException(result.getCode(), result.getMsg());
        }
    }

    /**
     * 返回分页数据
     *
     * @param result Result
     * @param <T>    T
     * @return List
     */
    public static <T> Pagination<T> getPagination(Result<Pagination<T>> result) {
        Pagination<T> pagination = getData(result);
        if (null == pagination) {
            throw new ResultException();
        }

        return pagination;
    }

    /**
     * 返回分页结果数据
     *
     * @param result Result
     * @param <T>    T
     * @return List
     */
    public static <T> List<T> getPaginationData(Result<Pagination<T>> result) {
        return getPagination(result).getData();
    }
}
