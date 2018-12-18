package cn.wangcaitao.common.service;

import cn.wangcaitao.common.entity.BaseBO;
import cn.wangcaitao.common.entity.BaseDTO;
import cn.wangcaitao.common.entity.BaseQuery;
import cn.wangcaitao.common.entity.Pagination;
import cn.wangcaitao.common.entity.Result;

import java.util.List;

/**
 * 基础 service 接口
 *
 * @author wangcaitao
 */
public interface BaseService<B extends BaseBO, D extends BaseDTO, Q extends BaseQuery> {

    /**
     * 根据 id 查询
     *
     * @param id id
     * @return Result
     */
    Result<B> getById(Long id);

    /**
     * 查询全部列表
     *
     * @param query 查询实体
     * @return Result
     */
    Result<List<B>> list(Q query);

    /**
     * 根据 ids 获取列表
     *
     * @param ids ids
     * @return Result
     */
    Result<List<B>> listByIds(Long[] ids);

    /**
     * 分页查询
     *
     * @param query 查询实体
     * @return Result
     */
    Result<Pagination<B>> pagination(Q query);

    /**
     * 保存
     *
     * @param entity dto entity
     * @return Result
     */
    Result save(D entity);

    /**
     * 批量保存
     *
     * @param entities entities
     * @return Result
     */
    Result batchSave(List<D> entities);

    /**
     * 修改
     *
     * @param entity dto entity
     * @return Result
     */
    Result update(D entity);

    /**
     * 批量修改
     *
     * @param entities entities
     * @return Result
     */
    Result batchUpdate(List<D> entities);

    /**
     * 删除
     *
     * @param id id
     * @return Result
     */
    Result delete(Long id);

    /**
     * 批量删除
     *
     * @param ids ids
     * @return Result
     */
    Result deleteByIds(Long[] ids);
}
