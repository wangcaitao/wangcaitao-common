package cn.wangcaitao.common.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 基础 DO
 *
 * @author wangcaitao
 */
@Data
public class BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    private Timestamp gmtModified;
}
