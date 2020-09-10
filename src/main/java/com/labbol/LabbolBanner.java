/**
 * 
 */
package com.labbol;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

/**
 * @author PengFei
 */
public final class LabbolBanner implements Banner{
	
	public static final LabbolBanner INSTANCE = new LabbolBanner();
	
	private LabbolBanner() {}

	public static final String LABBOL = ".____          ___.  ___.          .__   \r\n" + 
			"|    |   _____ \\_ |__\\_ |__   ____ |  |  \r\n" + 
			"|    |   \\__  \\ | __ \\| __ \\ /  _ \\|  |  \r\n" + 
			"|    |___ / __ \\| \\_\\ \\ \\_\\ (  <_> )  |__\r\n" + 
			"|_______ (____  /___  /___  /\\____/|____/\r\n" + 
			"        \\/    \\/    \\/    \\/             \n";
	
	@Override
	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
		out.print(LABBOL);
	}

}
