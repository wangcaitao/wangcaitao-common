package com.wangcaitao.common.util;

import com.wangcaitao.common.constant.CharConstant;
import com.wangcaitao.common.constant.ContentTypeConstant;
import com.wangcaitao.common.constant.HttpHeaderConstant;
import com.wangcaitao.common.constant.HttpMethodConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;

/**
 * http servlet request util
 *
 * @author wangcaitao
 */
@Slf4j
public class HttpServletRequestUtils {

    /**
     * 获取客户端地址
     *
     * @param request request
     * @return 客户端地址
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        if (null == request) {
            log.error("HttpServletRequest is null");

            return "";
        }

        String ip = request.getHeader(HttpHeaderConstant.KEY_X_FORWARDED_FOR);
        if (StringUtils.isNotEmpty(ip) && !HttpHeaderConstant.VALUE_UNKNOWN.equalsIgnoreCase(ip)) {
            int index = ip.indexOf(CharConstant.COMMA);
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }

        ip = request.getHeader(HttpHeaderConstant.KEY_X_REAL_IP);
        if (StringUtils.isNotEmpty(ip) && !HttpHeaderConstant.VALUE_UNKNOWN.equalsIgnoreCase(ip)) {
            return ip;
        }

        return request.getRemoteAddr();
    }

    /**
     * 获取 user-agent
     *
     * @param request request
     * @return user-agent
     */
    public static String getUserAgent(HttpServletRequest request) {
        if (null == request) {
            log.error("HttpServletRequest is null");

            return "";
        }

        return request.getHeader(HttpHeaderConstant.KEY_USER_AGENT);
    }

    /**
     * 获取请求参数
     *
     * @param request request
     * @return 请求参数
     */
    public static String getParam(HttpServletRequest request) {
        if (null == request) {
            log.error("HttpServletRequest is null");

            return "";
        }

        StringBuilder param = new StringBuilder();
        String method = request.getMethod();
        if (Objects.equals(HttpMethodConstant.GET, method)) {
            System.out.println(request.getQueryString());
        } else {
            String contentType = request.getContentType();
            if (Objects.equals(ContentTypeConstant.APPLICATION_FORM_URLENCODED_VALUE, contentType)) {
                Enumeration<String> enumeration = request.getParameterNames();
                while (enumeration.hasMoreElements()) {
                    String key = enumeration.nextElement();
                    String value = request.getParameter(key);

                    param.append(key).append(": ").append(value).append(", ");
                }
            } else if (Objects.equals(ContentTypeConstant.APPLICATION_JSON_VALUE, contentType)
                    || Objects.equals(ContentTypeConstant.APPLICATION_XML_VALUE, contentType)
                    || Objects.equals(ContentTypeConstant.TEXT_PLAIN_VALUE, contentType)
                    || Objects.equals(ContentTypeConstant.TEXT_HTML_VALUE, contentType)
                    || Objects.equals(ContentTypeConstant.TEXT_XML_VALUE, contentType)
            ) {
                String line;
                try {
                    BufferedReader bufferedReader = request.getReader();
                    while ((line = bufferedReader.readLine()) != null) {
                        param.append(line.trim());
                    }
                } catch (IOException e) {
                    log.error("get param error.", e);
                }

            } else {
                log.error("not support. content-type: {}", contentType);
            }
        }

        return param.toString();
    }
}
