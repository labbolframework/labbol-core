/**
 * 
 */
package com.labbol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PengFei
 */
public final class LApplication {

	private static final Map<String, String> PROPERTIES = new HashMap<String, String>();

	public static final String getProperty(String key) {
		return PROPERTIES.get(key);
	}

	public static final String getProperty(String key, String defaultValue) {
		return PROPERTIES.getOrDefault(key, defaultValue);
	}

	public static final void setProperty(String key, String value) {
		PROPERTIES.put(key, value);
	}

	public static final Map<String, String> getProperties() {
		return PROPERTIES;
	}

}
