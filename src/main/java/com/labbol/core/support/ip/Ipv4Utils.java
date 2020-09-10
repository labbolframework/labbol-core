/**
 * 
 */
package com.labbol.core.support.ip;

/**
 * @author PF
 *
 */
public final class Ipv4Utils {

	private Ipv4Utils() {
	}

	/**
	 * 判断ip前三段是否相同
	 * 
	 * @param ip1 判断的第一个ip
	 * @param ip2 判断的第二个ip
	 * @return <code>true</code> 相同
	 */
	public static boolean validateFirstThreeSection(String ip1, String ip2) {
		// 起始IP和结束IP的前三个段必须相同
		ip1 = ip1.substring(0, ip1.lastIndexOf("."));
		ip2 = ip2.substring(0, ip2.lastIndexOf("."));
		return ip1.equals(ip2);
	}

}
