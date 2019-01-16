package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.HttpStatusConstant;
import cn.wangcaitao.common.exception.ResultException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangcaitao
 */
public class ParamValidateUtilsTest {

    @Test
    public void shouldSuccessWhenValidateId() {
        ParamValidateUtils.validateId(1L);
    }

    @Test
    public void shouldExceptionWhenValidateId() {
        try {
            ParamValidateUtils.validateId(null);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("id 不能为空", e.getMsg());
        }

        try {
            ParamValidateUtils.validateId(0L);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("id 无效", e.getMsg());
        }
    }

    @Test
    public void shouldSuccessWhenValidateStringWhenSave() {
        ParamValidateUtils.validateStringWhenSave("test", "test", 4);
        ParamValidateUtils.validateStringWhenSave("test", "test", 4, true);
    }

    @Test
    public void shouldExceptionWhenValidateStringWhenSave() {
        try {
            ParamValidateUtils.validateStringWhenSave(null, "test", 4);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("test 不能为空", e.getMsg());
        }

        try {
            ParamValidateUtils.validateStringWhenSave("", "test", 4);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("test 不能为空", e.getMsg());
        }

        try {
            ParamValidateUtils.validateStringWhenSave("test", "test", 3);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("test 最大 3 个字符", e.getMsg());
        }

        try {
            ParamValidateUtils.validateStringWhenSave(null, "test", 4, false);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("test 不能为空", e.getMsg());
        }

        try {
            ParamValidateUtils.validateStringWhenSave("", "test", 4, false);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("test 不能为空", e.getMsg());
        }

        try {
            ParamValidateUtils.validateStringWhenSave("test", "test", 3, false);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("test 最大 3 个字符", e.getMsg());
        }
    }

    @Test
    public void shouldSuccessWhenValidateString() {
        String result = ParamValidateUtils.validateString("", "test", 4);
        Assert.assertNull(result);

        result = ParamValidateUtils.validateString(null, "test", 4);
        Assert.assertNull(result);

        result = ParamValidateUtils.validateString("test", "test", 4);
        Assert.assertEquals("test", result);

        result = ParamValidateUtils.validateString("", "test", 4, true);
        Assert.assertEquals("", result);

        result = ParamValidateUtils.validateString(null, "test", 4, true);
        Assert.assertNull(result);

        result = ParamValidateUtils.validateString("test", "test", 4, true);
        Assert.assertEquals("test", result);
    }

    @Test
    public void shouldExceptionWhenValidateString() {
        try {
            ParamValidateUtils.validateString("test", "test", 3);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("test 最大 3 个字符", e.getMsg());
        }

        try {
            ParamValidateUtils.validateString("test", "test", 3, true);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("test 最大 3 个字符", e.getMsg());
        }

        try {
            ParamValidateUtils.validateString("test", "test", 3, true, false);
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("test 最大 3 个字符", e.getMsg());
        }
    }

    @Test
    public void shouldSuccessWhenValidateObjectNull() {
        ParamValidateUtils.validateObjectNull(null, "parentId", true);
        ParamValidateUtils.validateObjectNull(1L, "parentId", true);
        ParamValidateUtils.validateObjectNull(1L, "parentId");
    }

    @Test
    public void shouldExceptionWhenValidateObjectNull() {
        try {
            ParamValidateUtils.validateObjectNull(null, "parentId");
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("parentId 不能为空", e.getMsg());
        }
    }

    @Test
    public void shouldSuccessWhenValidateListEmpty() {
        ParamValidateUtils.validateListEmpty(null, "list", true);
        List<String> list = new ArrayList<>();
        ParamValidateUtils.validateListEmpty(list, "list", true);
        list.add("test");
        ParamValidateUtils.validateListEmpty(list, "list", true);
        ParamValidateUtils.validateListEmpty(list, "list");
    }

    @Test
    public void shouldExceptionWhenValidateListEmpty() {
        try {
            ParamValidateUtils.validateListEmpty(null, "list");
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("list 不能为空", e.getMsg());
        }

        try {
            ParamValidateUtils.validateListEmpty(new ArrayList(), "list");
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("list 不能为空", e.getMsg());
        }
    }

    @Test
    public void shouldSuccessWhenValidateArrayEmpty() {
        ParamValidateUtils.validateArrayEmpty(null, "array", true);
        String[] array = new String[5];
        ParamValidateUtils.validateArrayEmpty(array, "array", true);
        array[0] = "test";
        ParamValidateUtils.validateArrayEmpty(array, "array", true);
        ParamValidateUtils.validateArrayEmpty(array, "array");
    }

    @Test
    public void shouldExceptionWhenValidateArrayEmpty() {
        try {
            ParamValidateUtils.validateArrayEmpty(null, "array");
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("array 不能为空", e.getMsg());
        }

        try {
            ParamValidateUtils.validateArrayEmpty(new String[5], "array");
        } catch (ResultException e) {
            Assert.assertEquals(HttpStatusConstant.BAD_REQUEST_CODE, e.getCode());
            Assert.assertEquals("array 不能为空", e.getMsg());
        }
    }
}
