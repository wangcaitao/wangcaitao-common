package com.wangcaitao.common.service;

import com.wangcaitao.common.entity.BaseQuery;
import com.wangcaitao.common.entity.Result;

import java.io.Serializable;
import java.util.List;

/**
 * 基础 service 接口
 *
 * @author wangcaitao
 */
public interface BaseService<BO, SAVE_DTO, UPDATE_DTO, Q extends BaseQuery> {

    /**
     * 根据 id 查询
     *
     * @param id id
     * @return Result
     */
    Result<BO> getById(Long id);

    /**
     * 列表查询
     *
     * @param query 查询实体
     * @return Result
     */
    Result<List<BO>> list(Q query);

    /**
     * 保存
     *
     * @param entity dto entity
     * @return Result
     */
    Result<Serializable> save(SAVE_DTO entity);

    /**
     * 批量保存
     *
     * @param entities entities
     * @return Result
     */
    Result<Serializable> save(List<SAVE_DTO> entities);

    /**
     * 修改
     *
     * @param entity dto entity
     * @return Result
     */
    Result<Serializable> update(UPDATE_DTO entity);

    /**
     * 批量修改
     *
     * @param entities entities
     * @return Result
     */
    Result<Serializable> update(List<UPDATE_DTO> entities);

    /**
     * 删除
     *
     * @param id id
     * @return Result
     */
    Result<Serializable> delete(Long id);

    /**
     * 批量删除
     *
     * @param ids ids
     * @return Result
     */
    Result<Serializable> delete(List<Long> ids);
}
