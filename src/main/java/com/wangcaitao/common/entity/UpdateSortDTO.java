package com.wangcaitao.common.entity;

import com.wangcaitao.common.constant.CommonDictCodeConstant;
import com.wangcaitao.common.constant.CommonErrorEnum;
import com.wangcaitao.common.exception.ResultException;
import com.wangcaitao.common.util.validate.IdValidateUtils;
import com.wangcaitao.common.util.validate.ObjectValidateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * 修改排序实体类
 *
 * @author wangcaitao
 */
@Data
public class UpdateSortDTO implements Serializable {
    private static final long serialVersionUID = 8813901406648837869L;

    /**
     * id
     */
    private Long id;

    /**
     * 移动类型编码
     */
    private Integer moveTypeCode;

    /**
     * 参数校验
     */
    public void validate() {
        IdValidateUtils.notNull(id, "id");
        ObjectValidateUtils.notNull(moveTypeCode, "moveTypeCode");

        if (!Objects.equals(moveTypeCode, CommonDictCodeConstant.MOVE_TYPE_UP) && !Objects.equals(moveTypeCode, CommonDictCodeConstant.MOVE_TYPE_DOWN)) {
            throw new ResultException(CommonErrorEnum.MOVE_TYPE_CODE_INVALID);
        }
    }
}
