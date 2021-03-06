package com.labbol.core.platform.role.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

@Table("CO_ROLE_DATARIGHT")
public class RoleDataRight extends BaseModel<RoleDataRight> {

	private static final long serialVersionUID = -7175495832247132240L;

	@Column(columnName = "角色id")
	private String roleId;

	@Column(columnName = "权限名称")
	private String rightName;

	@Column(columnName = "模块id")
	private String moduleId;

	@Column(columnName = "参数")
	private String params;

	@Column(columnName = "")
	private String expression;

	@Column(columnName = "权限描述")
	private String rightDesc;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getRightDesc() {
		return rightDesc;
	}

	public void setRightDesc(String rightDesc) {
		this.rightDesc = rightDesc;
	}

}