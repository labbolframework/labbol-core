/**
 * 
 */
package com.labbol.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.annotation.Nullable;
import org.yelong.core.jdbc.sql.condition.ConditionConnectWay;
import org.yelong.core.jdbc.sql.condition.support.Condition;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.sql.SqlModel;

import com.labbol.core.queryinfo.filter.QueryFilterInfo;

import dream.first.base.model.DreamFirstBaseModel;

/**
 * 基础模型。包含基础的字段，并提供常用的方法
 * 
 * 注意：该类继承{@link SqlModel}，这个类的子类是可以转换为SQL的
 * 
 * @author PengFei
 * @since 2.0
 */
public abstract class BaseModel<M extends Modelable> extends DreamFirstBaseModel<M> implements BaseModelable {

	private static final long serialVersionUID = -4023707437316252376L;

	/**
	 * @see #addConditionOperator(String, String)
	 */
	public BaseModel<M> addCustomerQueryCondition(String conditionName, String condition) {
		super.addConditionOperator(conditionName, condition);
		return this;
	}

	/**
	 * @see #getConditionOperatorMap()
	 */
	@Deprecated
	public Map<String, String> getCustomerQueryConditionMap() {
		return super.getConditionOperators();
	}

	/**
	 * @see SqlModel#addExtendAttribute(String, Object)
	 */
	public BaseModel<M> addExtendAttribute(String attrName, Object attrValue) {
		super.addExtendAttribute(attrName, attrValue);
		return this;
	}

	/**
	 * @see SqlModel#removeExtendAttribute(String)
	 */
	public BaseModel<M> removeExtendAttribute(String attrName) {
		super.removeExtendAttribute(attrName);
		return this;
	}

	/**
	 * @see SqlModel#getExtendAttribute(String)
	 */
	@Nullable
	public Object getExtendAttribute(String attrName) {
		return super.getExtendAttribute(attrName);
	}

	/**
	 * @see SqlModel#getExtendAttributesMap()
	 */
	@Deprecated
	public Map<String, Object> getExtendAttributesMap() {
		return super.getExtendAttributes();
	}

	/**
	 * @see SqlModel#getSortFieldMap()
	 */
	@Deprecated
	public Map<String, String> getSortFieldMap() {
		return super.getSortFields();
	}

	/**
	 * @see SqlModel#addSortField()
	 */
	public BaseModel<M> addSortField(String sortField, String sortOrder) {
		super.addSortField(sortField, sortOrder);
		return this;
	}

	/**
	 * @see SqlModel#addCondition(Condition)
	 */
	@Deprecated
	public BaseModel<M> addQueryFilterInfo(QueryFilterInfo queryFilterInfo) {
		super.addCondition(toCondition(queryFilterInfo));
		return this;
	}

	/**
	 * @see SqlModel#addCondition(Condition)
	 */
	@Deprecated
	public BaseModel<M> addQueryFilterInfo(String fieldName, String operator, @Nullable Object value) {
		return addQueryFilterInfo(new QueryFilterInfo(fieldName, operator, value));
	}

	/**
	 * @see SqlModel#getConditions()
	 */
	@Deprecated
	public List<QueryFilterInfo> getQueryFilterInfos() {
		List<Condition> conditions = getConditions();
		List<QueryFilterInfo> queryFilterInfos = new ArrayList<QueryFilterInfo>();
		for (Condition condition : conditions) {
			queryFilterInfos.add(toQueryFilterInfo(condition));
		}
		return queryFilterInfos;
	}

	@Deprecated
	private Condition toCondition(QueryFilterInfo queryFilterInfo) {
		Condition condition = null;
		Object fieldValue = queryFilterInfo.getFieldValue();
		if (null == fieldValue) {
			condition = new Condition(queryFilterInfo.getFieldName(), queryFilterInfo.getOperator());
		} else {
			condition = new Condition(queryFilterInfo.getFieldName(), queryFilterInfo.getOperator(),
					queryFilterInfo.getFieldValue());
		}
		condition.setGroupName(queryFilterInfo.getGroupName());
		String connectOperator = queryFilterInfo.getConnectOperator();
		if (StringUtils.isNotBlank(connectOperator)) {
			condition.setConnectWay(ConditionConnectWay.valueOf(connectOperator));
		}
		return condition;
	}

	@Deprecated
	private QueryFilterInfo toQueryFilterInfo(Condition condition) {
		QueryFilterInfo queryFilterInfo = new QueryFilterInfo();
		queryFilterInfo.setConnectOperator(condition.getConnectWay().getKeyword());
		queryFilterInfo.setFieldName(condition.getColumn());
		queryFilterInfo.setFieldValue(condition.getValue());
		queryFilterInfo.setGroupName(condition.getGroupName());
		queryFilterInfo.setOperator(condition.getOperator());
		return queryFilterInfo;
	}

}
