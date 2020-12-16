/**
 * 
 */
package com.labbol.core.platform.module.constants;

/**
 * 模块打开的类型
 * 
 * @author PengFei
 * @date 2020年12月10日上午9:17:11
 */
public enum ModuleOpenType {

	/** 添加tab标签打开 */
	TAB("01"),
	/** 新页面打开 */
	NEW_PAGE("02");

	public final String CODE;

	private ModuleOpenType(String code) {
		this.CODE = code;
	}

}
