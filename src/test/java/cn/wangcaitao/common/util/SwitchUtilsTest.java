package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.CharConstant;
import cn.wangcaitao.common.constant.IntegerConstant;
import cn.wangcaitao.common.constant.LongConstant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 测试对象转换工具类
 *
 * @author wangcaitao
 */
public class SwitchUtilsTest {

    /**
     * 英文逗号分割的字符串转 Long[]
     */
    @Test
    public void shouldStringToLongArray() {
        String str = CharConstant.EMPTY;
        Long[] longArray = SwitchUtils.stringToLongArray(str);
        assertEquals(IntegerConstant.ZERO, longArray.length);

        str = "1,2,3,";
        longArray = SwitchUtils.stringToLongArray(str);
        assertEquals(IntegerConstant.THREE, longArray.length);
        assertEquals(LongConstant.ONE, longArray[IntegerConstant.ZERO].longValue());
        assertEquals(LongConstant.TWO, longArray[IntegerConstant.ONE].longValue());
        assertEquals(LongConstant.THREE, longArray[IntegerConstant.TWO].longValue());
    }

    /**
     * Long[] 转 英文逗号分割的字符串（最后无逗号）
     */
    @Test
    public void shouldLongArrayToString() {
        String str = SwitchUtils.longArrayToString(null);
        assertEquals(CharConstant.EMPTY, str);

        Long[] longArray = new Long[IntegerConstant.ZERO];
        assertEquals(CharConstant.EMPTY, SwitchUtils.longArrayToString(longArray));

        longArray = new Long[IntegerConstant.TWO];
        longArray[IntegerConstant.ZERO] = LongConstant.ZERO;
        longArray[IntegerConstant.ONE] = LongConstant.ONE;
        assertEquals("0,1", SwitchUtils.longArrayToString(longArray));
    }

    /**
     * 英文逗号分割的字符串转排序后的字符串（最后无逗号）
     */
    @Test
    public void shouldStringToSortedString() {
        String str = CharConstant.EMPTY;
        assertEquals(CharConstant.EMPTY, SwitchUtils.stringToSortedString(str));

        str = "b,a,cat,dog,bad";
        assertEquals("a,b,bad,cat,dog", SwitchUtils.stringToSortedString(str));
    }

    /**
     * 英文逗号分割的字符串（纯数字）转排序后的字符串（最后无逗号）
     */
    @Test
    public void shouldLongToSortedString() {
        String str = CharConstant.EMPTY;
        String sortedStr = SwitchUtils.longToSortedString(str);
        assertEquals(CharConstant.EMPTY, sortedStr);

        str = "2,1,3,5,4,";
        sortedStr = SwitchUtils.longToSortedString(str);
        assertEquals("1,2,3,4,5", sortedStr);
    }
}
