package com.labbol.core.platform.role.model;

import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

@Table("CO_ROLE")
public class Role extends BaseModel<Role> {

	private static final long serialVersionUID = 1245848196715132172L;

	private String roleName;

	private String roleType;

	private String roleDesc;

	private String roleProperty;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleProperty() {
		return roleProperty;
	}

	public void setRoleProperty(String roleProperty) {
		this.roleProperty = roleProperty;
	}

}