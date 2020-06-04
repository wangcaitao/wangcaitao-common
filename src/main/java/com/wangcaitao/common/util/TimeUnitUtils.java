package com.wangcaitao.common.util;

import com.wangcaitao.common.exception.ResultException;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author wangcaitao
 */
@Slf4j
public class TimeUnitUtils {

    /**
     * 睡眠. 单位: 毫秒
     *
     * @param timeout 睡眠时间
     */
    public static void millisecondsSleep(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            log.error("time sleep error.", e);

            throw new ResultException();
        }
    }

    /**
     * 睡眠. 单位: 秒
     *
     * @param timeout 睡眠时间
     */
    public static void secondsSleep(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            log.error("time sleep error.", e);

            throw new ResultException();
        }
    }

    /**
     * 睡眠. 单位: 分
     *
     * @param timeout 睡眠时间
     */
    public static void minutesSleep(long timeout) {
        try {
            TimeUnit.MINUTES.sleep(timeout);
        } catch (InterruptedException e) {
            log.error("time sleep error.", e);

            throw new ResultException();
        }
    }
}
