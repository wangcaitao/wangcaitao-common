package cn.wangcaitao.common.entity;

import cn.wangcaitao.common.util.ParamValidateUtils;
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
        ParamValidateUtils.validateId(id);
        ParamValidateUtils.validateStringEmpty(typeCode, "typeCode");
    }
}
