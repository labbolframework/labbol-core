package com.labbol.core.gson;

import java.util.Date;

/**
 * 兼容旧版本
 * 
 * @author PengFei
 * @since 1.2.2
 */
public class DateTypeAdapter extends org.yelong.support.json.gson.adapter.DateTypeAdapter{

	public DateTypeAdapter() {
		this(DEFAULT_SERIALIZATION_NULL_PADDING, DEFAULT_DESERIALIZATION_NULL_PADDING);
	}

	/**
	 * @param serializationNullPadding   序列化null值填补
	 *                                   当String类型进行转换json时，如果这个属性值为null则使用{@link #serializationNullPadding}来替换
	 * @param deserializationNullPadding 反序列化null值填补 反序列化null值填补
	 *                                   当json进行转换String类型时，如果这个属性值为null则使用{@link #deserializationNullPadding}来替换
	 */
	public DateTypeAdapter(String serializationNullPadding, Date deserializationNullPadding) {
		super(serializationNullPadding,deserializationNullPadding);
	}
	
}
