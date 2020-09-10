/**
 * 
 */
package com.labbol.core.utils;

import java.util.UUID;

/**
 * @author PengFei
 */
public class IDUtils {

	/**
	 * @return 32位字符的随机串
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

}
