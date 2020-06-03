package com.wangcaitao.common.util;

import com.wangcaitao.common.entity.Location;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 地理位置工具
 *
 * @author wangcaitao
 */
@Slf4j
public class LocationUtils {

    /**
     * 根据 ip 获取地理位置相关信息
     *
     * @param ip ip
     * @return location
     */
    public static Location getResult(String ip) {
        StringBuilder responseContent = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL("http://whois.pconline.com.cn/ipJson.jsp?" + "ip=" + ip + "&json=true");
            URLConnection connection = url.openConnection();
            connection.connect();

            String line;
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
            while ((line = bufferedReader.readLine()) != null) {
                responseContent.append(line.trim());
            }
        } catch (IOException e) {
            log.error("get location error. ip: {}", ip);
        } finally {
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    log.error("get location error. ip: {}", ip);
                }
            }
        }

        String responseContentStr = responseContent.toString();
        if (StringUtils.isBlank(responseContentStr)) {
            return null;
        }

        return JsonUtils.parseObject(responseContentStr, Location.class);
    }

    /**
     * 根据 ip 获取地理位置
     *
     * @param ip ip
     * @return 地址
     */
    public static String getLocation(String ip) {
        Location location = getResult(ip);
        if (null == location) {
            return "";
        }

        return location.getAddr().trim();
    }
}
