/**
 * 
 */
package com.labbol.core.platform.debug.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

/**
 * @author PengFei
 */
/*
 * mysql 删除记录 delete from co_debug where createtime < STR_TO_DATE('2020-05-04
 * 17:25:00','%Y-%m-%d %T');
 */
@Table(value = "CO_DEBUG", alias = "debug")
public class Debug extends BaseModel<Debug> {

	private static final long serialVersionUID = -2163338806380110531L;

	@Column(columnName = "调试人")
	private String debugPeople;

	@Column(columnName = "调试描述")
	private String debugDesc;

	@Column(columnName = "创建地址")
	private String createAddress;

	public String getDebugPeople() {
		return debugPeople;
	}

	public void setDebugPeople(String debugPeople) {
		this.debugPeople = debugPeople;
	}

	public String getDebugDesc() {
		return debugDesc;
	}

	public void setDebugDesc(String debugDesc) {
		this.debugDesc = debugDesc;
	}

	public String getCreateAddress() {
		return createAddress;
	}

	public void setCreateAddress(String createAddress) {
		this.createAddress = createAddress;
	}

}
