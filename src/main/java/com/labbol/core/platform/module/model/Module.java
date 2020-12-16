/**
 * 
 */
package com.labbol.core.platform.module.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;
import org.yelong.core.order.Orderable;

import com.labbol.core.model.BaseModel;

/**
 * @author PengFei
 */
@Table("CO_MODULE")
public class Module extends BaseModel<Module> implements Comparable<Module>, Orderable {

	private static final long serialVersionUID = -1663619675171907021L;

	private String moduleNo;

	private String parentModuleNo;

	private String moduleName;

	private String moduleType;

	private String moduleUrl;

	@Column(column = "moduleSourceUrl")
	private String moduleSourceUrl;

	private Integer moduleOrder;

	private String moduleShow;

	private String moduleLog;

	private String moduleDesc;

	private String moduleProperty;

	private String moduleIcon;

	@Column(columnName = "打开模块的方式")
	private String moduleOpenType;

	public String getModuleNo() {
		return moduleNo;
	}

	public void setModuleNo(String moduleNo) {
		this.moduleNo = moduleNo;
	}

	public String getParentModuleNo() {
		return parentModuleNo;
	}

	public void setParentModuleNo(String parentModuleNo) {
		this.parentModuleNo = parentModuleNo;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public String getModuleUrl() {
		return moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

	public Integer getModuleOrder() {
		return moduleOrder;
	}

	public void setModuleOrder(Integer moduleOrder) {
		this.moduleOrder = moduleOrder;
	}

	public String getModuleShow() {
		return moduleShow;
	}

	public void setModuleShow(String moduleShow) {
		this.moduleShow = moduleShow;
	}

	public String getModuleLog() {
		return moduleLog;
	}

	public void setModuleLog(String moduleLog) {
		this.moduleLog = moduleLog;
	}

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public String getModuleProperty() {
		return moduleProperty;
	}

	public void setModuleProperty(String moduleProperty) {
		this.moduleProperty = moduleProperty;
	}

	public String getModuleIcon() {
		return moduleIcon;
	}

	public void setModuleIcon(String moduleIcon) {
		this.moduleIcon = moduleIcon;
	}

	public String getModuleSourceUrl() {
		return moduleSourceUrl;
	}

	public void setModuleSourceUrl(String moduleSourceUrl) {
		this.moduleSourceUrl = moduleSourceUrl;
	}

	public String getModuleOpenType() {
		return moduleOpenType;
	}

	public void setModuleOpenType(String moduleOpenType) {
		this.moduleOpenType = moduleOpenType;
	}

	@Override
	public int compareTo(Module o) {
		if (o.moduleOrder == null) {
			return 1;
		} else if (this.moduleOrder == null) {
			return -1;
		} else {
			return Integer.compare(this.moduleOrder, o.moduleOrder);
		}
	}

	@Override
	public int getOrder() {
		return null == this.moduleOrder ? LOWEST_PRECEDENCE : this.moduleOrder;
	}

}
