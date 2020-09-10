package com.labbol.core.platform.module.constants;

/**
 * 模块类型
 * 
 * @author PengFei
 */
public enum ModuleType {

	/** 模块 */
	MODULE("01"),
	/** 操作 */
	OPERATE("02");

	String code;

	public final String CODE;

	private ModuleType(String code) {
		this.code = code;
		this.CODE = code;
	}

	public String code() {
		return this.code;
	}

}
