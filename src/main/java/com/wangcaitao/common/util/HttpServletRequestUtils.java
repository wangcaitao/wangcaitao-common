package com.wangcaitao.common.util;

import com.wangcaitao.common.constant.CharConstant;
import com.wangcaitao.common.constant.HttpHeaderConstant;
import com.wangcaitao.common.exception.ResultException;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * http servlet request util
 *
 * @author wangcaitao
 */
public class HttpServletRequestUtils {

    /**
     * 获取客户端地址
     *
     * @param request request
     * @return 客户端地址
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        if (null == request) {
            throw new ResultException();
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
            throw new ResultException();
        }

        return request.getHeader(HttpHeaderConstant.KEY_USER_AGENT);
    }
}
