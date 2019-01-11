package cn.wangcaitao.common.service;

import cn.wangcaitao.common.entity.BaseQuery;
import cn.wangcaitao.common.entity.Pagination;
import cn.wangcaitao.common.entity.Result;

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
     * 查询全部列表
     *
     * @param query 查询实体
     * @return Result
     */
    Result<List<BO>> list(Q query);

    /**
     * 根据 ids 获取列表
     *
     * @param ids ids
     * @return Result
     */
    Result<List<BO>> list(List<Long> ids);

    /**
     * 分页查询
     *
     * @param query 查询实体
     * @return Result
     */
    Result<Pagination<BO>> pagination(Q query);

    /**
     * 保存
     *
     * @param entity dto entity
     * @return Result
     */
    Result save(SAVE_DTO entity);

    /**
     * 批量保存
     *
     * @param entities entities
     * @return Result
     */
    Result save(List<SAVE_DTO> entities);

    /**
     * 修改
     *
     * @param entity dto entity
     * @return Result
     */
    Result update(UPDATE_DTO entity);

    /**
     * 批量修改
     *
     * @param entities entities
     * @return Result
     */
    Result update(List<UPDATE_DTO> entities);

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
    Result delete(List<Long> ids);
}
