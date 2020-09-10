/**
 * 
 */
package com.labbol.core.platform.user.constants;

/**
 * 用户密级
 * 
 * @author PF
 */
public enum UserSecretDegree {
	/** 涉密 */
	SECRET_RELATED("01"),

	/** 内部人员 */
	INTERIOR("02");
	
	public final String CODE;

	private UserSecretDegree(String code) {
		CODE = code;
	}

}
