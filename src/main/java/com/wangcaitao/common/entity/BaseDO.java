package com.wangcaitao.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础 DO
 *
 * @author wangcaitao
 */
@Data
public class BaseDO implements Serializable {
    private static final long serialVersionUID = -8664703910405583266L;

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createGmt;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedGmt;
}
