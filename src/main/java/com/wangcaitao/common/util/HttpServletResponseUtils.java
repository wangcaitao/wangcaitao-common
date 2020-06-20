package com.wangcaitao.common.util;

import com.wangcaitao.common.constant.ContentTypeConstant;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author wangcaitao
 */
public class HttpServletResponseUtils {

    /**
     * 输出. json 格式
     *
     * @param response response
     * @throws IOException IOException
     */
    public static void output(HttpServletResponse response, String content) throws IOException {
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType(ContentTypeConstant.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        PrintWriter printWriter = response.getWriter();
        printWriter.print(content);
        printWriter.flush();
        printWriter.close();
    }
}
