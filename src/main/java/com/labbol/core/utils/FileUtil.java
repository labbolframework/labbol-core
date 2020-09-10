package com.labbol.core.utils;

import org.yelong.commons.io.FileUtilsE;

public class FileUtil {

	public static String byteCountToDisplaySize(long size, int decimalDigits) {
		return FileUtilsE.byteCountToDisplaySize(size, decimalDigits);
	}
	
}
