package com.wangcaitao.common.util;

import com.wangcaitao.common.constant.IntegerConstant;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangcaitao
 */
public class InputStreamUtils {

    /**
     * InputStream to byte[]
     *
     * @param inputStream inputStream
     * @return byte[]
     * @throws IOException IOException
     */
    public static byte[] getByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buff = new byte[IntegerConstant.ONE_HUNDRED];
        int index;
        while ((index = inputStream.read(buff, 0, IntegerConstant.ONE_HUNDRED)) > 0) {
            byteArrayOutputStream.write(buff, 0, index);
        }

        return byteArrayOutputStream.toByteArray();
    }

    /**
     * byte[] to InputStream
     *
     * @param bytes bytes
     * @return InputStream
     */
    public static InputStream getInputStream(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }
}
