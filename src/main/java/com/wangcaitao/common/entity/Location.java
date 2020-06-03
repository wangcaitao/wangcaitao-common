package com.wangcaitao.common.entity;

import lombok.Data;

/**
 * @author wangcaitao
 */
@Data
public class Location {

    /**
     * ip
     */
    private String ip;

    /**
     * 省
     */
    private String pro;

    /**
     * 省编码
     */
    private String proCode;

    /**
     * 城市
     */
    private String city;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 区
     */
    private String region;

    /**
     * 区编码
     */
    private String regionCode;

    /**
     * 全地址
     */
    private String addr;

    /**
     * regionNames
     */
    private String regionNames;

    /**
     * err
     */
    private String err;
}
