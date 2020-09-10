package com.labbol.core.platform.user.model;

import org.yelong.core.model.annotation.Table;
import org.yelong.core.model.annotation.Transient;

import com.labbol.core.model.BaseModel;

@Table("CO_USER_EXTRAORG")
public class UserExtraOrg extends BaseModel<UserExtraOrg> {

	private static final long serialVersionUID = 8500687079797831260L;

	private String userId;

	private String orgId;

	@Transient
	private String orgName;

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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}