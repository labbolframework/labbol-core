package com.labbol.core.platform.mycat.model;

import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

@Table("CO_TENANT_SCHEMA")
public class TenantSchema extends BaseModel<TenantSchema> {

	private static final long serialVersionUID = -1938348612355838298L;

	private String tenantid;

	private String schemaname;

	private String encryptSchema;

	public String getTenantid() {
		return tenantid;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid == null ? null : tenantid.trim();
	}

	public String getSchemaname() {
		return schemaname;
	}

	public void setSchemaname(String schemaname) {
		this.schemaname = schemaname == null ? null : schemaname.trim();
	}

	public String getEncryptSchema() {
		return encryptSchema;
	}

	public void setEncryptSchema(String encryptSchema) {
		this.encryptSchema = encryptSchema;
	}

}