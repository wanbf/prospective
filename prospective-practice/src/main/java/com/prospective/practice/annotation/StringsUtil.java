package com.prospective.practice.annotation;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class StringsUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(StringsUtil.class);

    public static void removeCustomizeValue(Object object) {
        Class<?> interfaceClass = object.getClass();
        Field[] fields = interfaceClass.getDeclaredFields();
        if (fields == null || fields.length == 0) {
            return;
        }
        Remove classRemoveAnnotation = interfaceClass.getAnnotation(Remove.class);
        /**
         *若class上添加了Remove注解
         */
        if (classRemoveAnnotation != null) {
            String[] values = classRemoveAnnotation.values();
            handleFieldsAnnotation(object, fields, true, values);
            return;
        }
        /**
         *若未在class未上添加了Remove注解
         */
        handleFieldsAnnotation(object, fields, false, null);

    }

    private static void handleFieldsAnnotation(Object object, Field[] fields, boolean defaultRemoveTag, String[] annotationDefaultValues) {
        for (Field field : fields) {
            if (needReplaceField(field, defaultRemoveTag)) {
                String[] values = getFieldAnnotationValues(field, annotationDefaultValues);
                if (values == null || values.length == 0)
                    continue;
                replaceFieldValue(object, field, values);
            }
        }
    }

    private static String[] getFieldAnnotationValues(Field field, String[] values) {
        Remove filedRemoveAnnotation = field.getAnnotation(Remove.class);
        if (filedRemoveAnnotation != null) {
            values = filedRemoveAnnotation.values();
        }
        return values;
    }


    private static boolean needReplaceField(Field field, boolean defaultRemoveTag) {
        if (!(String.class).equals(field.getType())) {
            return false;
        }
        field.setAccessible(true);
        Ignore ignoreAnnotation = field.getAnnotation(Ignore.class);
        if (ignoreAnnotation != null) {
            return false;
        }
        Remove filedRemoveAnnotation = field.getAnnotation(Remove.class);
        if (filedRemoveAnnotation != null) {
            return true;
        }
        return defaultRemoveTag;
    }

    private static void replaceFieldValue(Object object, Field field, String[] values) {
        try {
            String fieldValue = (String) field.get(object);
            if (Strings.isNullOrEmpty(fieldValue))
                return;
            for (String value : values) {
                fieldValue = fieldValue.replaceAll(value, "");
            }
            field.set(object, fieldValue);
        } catch (IllegalAccessException e) {
            LOGGER.error(String.format("字段：%s，出现字符串替换异常", field.getName()), e);
        }
    }
}
