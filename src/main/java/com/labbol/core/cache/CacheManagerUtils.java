/**
 * 
 */
package com.labbol.core.cache;

import java.util.function.Function;

import org.yelong.core.cache.CacheEntity;
import org.yelong.core.cache.CacheManager;

public final class CacheManagerUtils {

	private CacheManagerUtils() {
	}

	public static <T> CacheEntity<T> putCacheIfAbsent(CacheManager cacheManager, String key,
			Function<String, T> cacheValueFactory) {
		return cacheManager.putCacheIfAbsent(key, cacheValueFactory);
	}

	public static <T> T putCacheObjIfAbsent(CacheManager cacheManager, String key,
			Function<String, T> cacheValueFactory) {
		return cacheManager.putCacheObjIfAbsent(key, cacheValueFactory);
	}

}
