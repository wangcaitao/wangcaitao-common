package com.wangcaitao.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * json util. use jackson
 *
 * @author wangcaitao
 */
@Slf4j
public class JsonUtils {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

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
            log.error("serialization error.", e);

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
            log.error("deserialization error. text: {}, className: {}", text, clazz.getName(), e);

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
            log.error("deserialization error. text: {}, className: {}", text, clazz.getName(), e);

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
