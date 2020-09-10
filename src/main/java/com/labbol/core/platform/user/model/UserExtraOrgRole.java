package com.labbol.core.platform.user.model;

import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

@Table("CO_USER_EXTRAORG_ROLE")
public class UserExtraOrgRole extends BaseModel<UserExtraOrgRole> {

	private static final long serialVersionUID = 2287415287069683444L;

	private String extraOrgId;

	private String userId;

	private String orgId;

	private String roleId;

	public String getExtraOrgId() {
		return extraOrgId;
	}

	public void setExtraOrgId(String extraOrgId) {
		this.extraOrgId = extraOrgId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}