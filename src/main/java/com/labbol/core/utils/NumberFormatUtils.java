/**
 * 
 */
package com.labbol.core.utils;

import java.text.DecimalFormat;

/**
 * @author PengFei
 */
public class NumberFormatUtils {

	public static String format(Long text, String partten) {
		DecimalFormat df = new DecimalFormat(partten);

		return df.format(text);
	}

	public static String format(Integer text, String partten) {
		DecimalFormat df = new DecimalFormat(partten);

		return df.format(text);
	}

	public static String format(Float text, String partten) {
		DecimalFormat df = new DecimalFormat(partten);

		return df.format(text);
	}

	public static String format(Short text, String partten) {
		DecimalFormat df = new DecimalFormat(partten);

		return df.format(text);
	}

}
