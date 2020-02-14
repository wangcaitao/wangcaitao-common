package com.wangcaitao.common.util;

import com.wangcaitao.common.constant.IntegerConstant;
import org.junit.Assert;
import org.junit.Test;

/**
 * 测试随机数生成工具类
 *
 * @author wangcaitao
 */
public class RandomUtilsTest {

    /**
     * 生成自定义位数随机数
     */
    @Test
    public void shouldGenerateRandomDigit() {
        int randomDigit = RandomUtils.generateRandomDigit(IntegerConstant.SIX);
        Assert.assertEquals(IntegerConstant.SIX, String.valueOf(randomDigit).length());
    }

    /**
     * 生成通用编号
     */
    @Test
    public void shouldGenerateCommonNo() {
        String commonNo = RandomUtils.generateCommonNo();
        Assert.assertEquals(IntegerConstant.TWENTY + IntegerConstant.FIVE, commonNo.length());
    }
}