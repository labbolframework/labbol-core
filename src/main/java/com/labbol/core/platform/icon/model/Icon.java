/**
 * 
 */
package com.labbol.core.platform.icon.model;

import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

/**
 * @author PengFei
 */
@Table(value = "CO_ICON")
public class Icon extends BaseModel<Icon> {

	private static final long serialVersionUID = -6254356196113995923L;

	private String iconClass;

	private String iconPath;

	private String iconRemark;

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getIconRemark() {
		return iconRemark;
	}

	public void setIconRemark(String iconRemark) {
		this.iconRemark = iconRemark;
	}

}
