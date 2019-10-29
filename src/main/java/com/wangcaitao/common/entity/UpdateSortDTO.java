package com.wangcaitao.common.entity;

import com.wangcaitao.common.util.validate.IdValidateUtils;
import com.wangcaitao.common.util.validate.StringValidateUtils;
import lombok.Data;

/**
 * 修改排序实体类
 *
 * @author wangcaitao
 */
@Data
public class UpdateSortDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 移动类型编码
     */
    private String typeCode;

    /**
     * 参数校验
     */
    public void validate() {
        IdValidateUtils.notNull(id, "id");
        StringValidateUtils.notBlack(typeCode, "typeCode");
    }
}
