package cn.wangcaitao.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author wangcaitao
 */
public class AmountUtilsTest {

    @Test
    public void shouldToUpperWhenReturn() {
        BigDecimal case01 = BigDecimal.ZERO;
        Assert.assertEquals("零元整", AmountUtils.toUpper(case01));

        BigDecimal case02 = BigDecimal.ONE;
        Assert.assertEquals("壹元整", AmountUtils.toUpper(case02));

        BigDecimal case03 = BigDecimal.valueOf(0.01);
        Assert.assertEquals("壹分", AmountUtils.toUpper(case03));

        BigDecimal case04 = BigDecimal.valueOf(1234567890123.12);
        Assert.assertEquals("壹万贰仟叁佰肆拾伍亿陆仟柒佰捌拾玖万零壹佰贰拾叁元壹角贰分", AmountUtils.toUpper(case04));

        BigDecimal case05 = BigDecimal.valueOf(1001001001.01);
        Assert.assertEquals("壹拾亿零壹佰万壹仟零壹元零壹分", AmountUtils.toUpper(case05));
    }
}
