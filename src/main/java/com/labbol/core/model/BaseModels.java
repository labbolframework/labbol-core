/**
 * 
 */
package com.labbol.core.model;

import org.yelong.commons.beans.BeanUtilsE;
import org.yelong.core.model.sql.SqlModel;

/**
 * @author PengFei
 * @since 1.0.4
 */
public final class BaseModels {

	private BaseModels() {
	}

	/**
	 * 添加条件运算符。并根据 expression 来修改 column 对应的值。<br/>
	 * 这个 column 对应的值如果不存在则 方法相当于
	 * {@link SqlModel#addConditionOperator(String, String)}<br/>
	 * 这只支持字符串类型的字段及拓展属性<br/>
	 * 一般用于对列添加模糊查询。<br/>
	 * addConditionOperator(sqlModel , "name" , "like" , "%${value}%")<br/>
	 * 
	 * @param <S> SqlModel type
	 * @param sqlModel   需要修改的model
	 * @param column     列
	 * @param operator   运算符
	 * @param expression 表达式 ${value}表示原来的值 如： %${value}%
	 * @return sqlModel
	 */
	@SuppressWarnings("rawtypes")
	public static final <S extends SqlModel> S addConditionOperator(S sqlModel, String column, String operator,
			String expression) {
		sqlModel.addConditionOperator(column, operator);
		Object value;
		value = sqlModel.getExtendAttribute(column);
		if (null == value) {
			try {
				value = BeanUtilsE.getProperty(sqlModel, column);
			} catch (Exception e) {

			}
		}
		if (null != value) {
			if (value instanceof CharSequence) {
				value = expression.replace("${value}", (String) value);
				sqlModel.addExtendAttribute(column, value);
			}
		}
		return sqlModel;
	}

}
