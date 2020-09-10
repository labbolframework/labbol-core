/**
 * 
 */
package com.labbol.core.platform.scip.constants;

/**
 * 地址类型
 * 
 * @author PF
 */
public enum SCIPType {

	/** 涉密网段 */
	SECRET_RELATED("01");

	public final String CODE;

	private SCIPType(String code) {
		this.CODE = code;
	}

}
