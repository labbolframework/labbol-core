package com.labbol.core.platform.sign.model;

import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

@Table("CO_KEY_SECRET")
public class Sign extends BaseModel<Sign> {

	private static final long serialVersionUID = -7784179554097713615L;

	private String appKey;

	private String appSecret;

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

}
