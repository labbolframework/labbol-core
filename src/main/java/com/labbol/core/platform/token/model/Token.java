package com.labbol.core.platform.token.model;

import java.util.Date;

import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

@Table("TUS_USER_AUTH")
public class Token extends BaseModel<Token> {

	private static final long serialVersionUID = 87669142986863374L;

	private String userId;

	private String userName;

	private String authToken;

	private Date authCreateTime;

	private Date authExpireTime;

	private String realName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public Date getAuthCreateTime() {
		return authCreateTime;
	}

	public void setAuthCreateTime(Date authCreateTime) {
		this.authCreateTime = authCreateTime;
	}

	public Date getAuthExpireTime() {
		return authExpireTime;
	}

	public void setAuthExpireTime(Date authExpireTime) {
		this.authExpireTime = authExpireTime;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}