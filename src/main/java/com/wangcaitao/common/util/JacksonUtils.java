package com.wangcaitao.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.wangcaitao.common.config.JacksonModule;
import com.wangcaitao.common.constant.DateTimeFormatterConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * jackson util
 *
 * @author wangcaitao
 */
@Slf4j
public class JacksonUtils {

    /**
     * OBJECT_MAPPER
     */
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
            .setLocale(Locale.CHINA)
            .setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()))
            .setDateFormat(new SimpleDateFormat(DateTimeFormatterConstant.DATE_TIME_PATTERN_01))
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JacksonModule());

    /**
     * object to json string
     *
     * @param object object
     * @return json string
     */
    public static String toJsonString(Object object) {
        if (null == object) {
            throw new NullPointerException();
        }

        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("serialization error.");

            throw new RuntimeException("serialization error.");
        }
    }

    /**
     * json string to object
     *
     * @param text  text
     * @param clazz clazz
     * @param <T>   T
     * @return object
     */
    public static <T> T parseObject(String text, Class<T> clazz) {
        if (StringUtils.isBlank(text)) {
            throw new NullPointerException();
        }

        try {
            return OBJECT_MAPPER.readValue(text, clazz);
        } catch (JsonProcessingException e) {
            log.error("deserialization error. text: {}, className: {}", text, clazz.getName());

            throw new RuntimeException("deserialization error.");
        }
    }

    /**
     * json bytes to object
     *
     * @param bytes text
     * @param clazz clazz
     * @param <T>   T
     * @return object
     */
    public static <T> T parseObject(byte[] bytes, Class<T> clazz) {
        if (null == bytes || bytes.length == 0) {
            throw new NullPointerException();
        }

        try {
            return OBJECT_MAPPER.readValue(bytes, clazz);
        } catch (IOException e) {
            log.error("deserialization error. className: {}", clazz.getName());

            throw new RuntimeException("deserialization error.");
        }
    }

    /**
     * json string to list
     *
     * @param text  text
     * @param clazz clazz
     * @param <T>   T
     * @return list
     */
    public static <T> List<T> parseArray(String text, Class<T> clazz) {
        if (StringUtils.isBlank(text)) {
            throw new NullPointerException();
        }

        try {
            return OBJECT_MAPPER.readValue(text, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (JsonProcessingException e) {
            log.error("deserialization error. text: {}, className: {}", text, clazz.getName());

            throw new RuntimeException("deserialization error.");
        }
    }

    /**
     * copy bean properties for entity
     *
     * @param source      the source bean
     * @param targetClazz the target class
     * @param <T>         T
     * @return target bean
     */
    public static <T> T convertObject(Object source, Class<T> targetClazz) {
        return OBJECT_MAPPER.convertValue(source, targetClazz);
    }

    /**
     * copy bean properties for list
     *
     * @param source      the source list
     * @param targetClazz the target class
     * @param <T>         T
     * @return target list
     */
    public static <T> List<T> convertArray(Object source, Class<T> targetClazz) {
        return parseArray(toJsonString(source), targetClazz);
    }
}
