/**
 * 
 */
package com.labbol.core.platform.user.constants;

/**
 * @author PengFei
 *
 */
public enum UserInitState {

	/** 已经初始化 */
	HAS_BEEN_INIT("02");

	public final String CODE;

	private UserInitState(String code) {
		this.CODE = code;
	}

}
