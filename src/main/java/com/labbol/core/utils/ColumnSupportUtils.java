package com.labbol.core.utils;

import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.yelong.commons.beans.BeanUtilsE;
import org.yelong.commons.lang.annotation.AnnotationUtilsE;
import org.yelong.core.model.annotation.Column;

public class ColumnSupportUtils {

	public static void checkValueLength(Object obj, Class<?> cls)
			throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException {
		Field[] fields = FieldUtils.getAllFields(cls);
		for (Field field : fields) {
			Column column = AnnotationUtilsE.getAnnotation(field, Column.class);
			if (null != column) {
				String fieldName = field.getName();
				Object fieldValue = BeanUtilsE.getProperty(obj, fieldName);
				long valueLength = column.maxLength();
				if (fieldValue instanceof String) {// instanceof 比较的值为 null 时默认是 false
					String data = (String) fieldValue;
					long length = new Long((long) data.length());
					if (length > valueLength)
						// 非法参数异常
						throw new IllegalArgumentException(
								"字段【" + fieldName + "】值长度为：" + length + "，不符合参数规定长度：" + valueLength);
				}
			}
		}
	}

}
