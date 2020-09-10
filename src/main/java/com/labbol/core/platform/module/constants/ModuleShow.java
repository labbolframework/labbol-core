/**
 * 
 */
package com.labbol.core.platform.module.constants;

/**
 * 模块是否显示
 * 
 * @author PengFei
 */
public enum ModuleShow {

	/** 显示 */
	SHOW("01"),
	/** 不显示 */
	UNSHOW("02");

	String code;

	public final String CODE;

	private ModuleShow(String code) {
		this.code = code;
		this.CODE = code;
	}

	public String code() {
		return this.code;
	}

}