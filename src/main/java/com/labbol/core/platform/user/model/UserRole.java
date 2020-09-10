package com.labbol.core.platform.user.model;

import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

@Table("CO_USER_ROLE")
public class UserRole extends BaseModel<UserRole> {

	private static final long serialVersionUID = -7899995642604594310L;

	private String roleId;

	private String userId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}