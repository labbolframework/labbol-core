package com.labbol.core.utils;

/**
 * @ClassName: MoneySupportUtils  
 * @Description: 金额工具类
 * @author dwayne  
 * @date 2020-5-27  
 *
 */
public class MoneySupportUtils {

	private static final String UNIT = "万千佰拾亿千佰拾万千佰拾元角分";

	private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";

	private static final double MAX_VALUE = 9999999999999.99D;

	/**
	 * @Title: change  
	 * @Description: 小写金额转大写金额  
	 * @param @param v
	 * @param @return    参数  
	 * @return String    返回类型  
	 * @throws
	 */
	public static String change(double v) {
		if (v < 0 || v > MAX_VALUE){
			return "参数非法!";
		}
		long l = Math.round(v * 100);
		if (l == 0){
			return "零元整";
		}
		String strValue = l + "";
		// j用来控制单位
		int j = UNIT.length() - strValue.length();
		// i用来控制数
		int i = 0;
		String rs = "";
		boolean isZero = false;
		for (; i < strValue.length(); i++, j++){
			char ch = strValue.charAt(i);
			if (ch == '0') {
				isZero = true;
				if (UNIT.charAt(j) == '亿' || UNIT.charAt(j) == '万' || UNIT.charAt(j) == '元') {
					rs = rs + UNIT.charAt(j);
					isZero = false;
				}
			} else {
				if (isZero) {
					rs = rs + "零";
					isZero = false;
				}
				rs = rs + DIGIT.charAt(ch - '0') + UNIT.charAt(j);
			}
		}
		if (!rs.endsWith("分")) {
			rs = rs + "整";
		}
		rs = rs.replaceAll("亿万", "亿");
		return rs;
	}


}