package com.labbol.core.queryinfo;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.labbol.core.queryinfo.filter.QueryFilterInfo;

/**
 * 查询信息工具类
 * 
 * @author PengFei
 * @date 2020年12月7日下午4:18:19
 */
public final class QueryInfos {

	private QueryInfos() {
	}

	/**
	 * 获取QueryInfo中所有查询字段
	 */
	public static List<String> getFilterFieldNames(QueryInfo queryInfo) {
		return queryInfo.getFilters().stream().map(QueryFilterInfo::getFieldName).collect(Collectors.toList());
	}

	/**
	 * 如果不存在排序则添加默认排序
	 * 
	 * @author PengFei
	 * @date 2020年12月7日下午4:45:20
	 * @param queryInfo 查询信息
	 */
	public static void addDefaultSortIfNotSort(QueryInfo queryInfo) {
		// 默认排序为根据创建时间降序
		addDefaultSortIfNotSort(queryInfo, () -> new QuerySortInfo("createTime", "DESC"));
	}

	/**
	 * 如果不存在排序则添加默认排序
	 * 
	 * @author PengFei
	 * @date 2020年12月7日下午4:45:20
	 * @param queryInfo     查询信息
	 * @param querySortInfo 排序信息
	 */
	public static void addDefaultSortIfNotSort(QueryInfo queryInfo, Supplier<QuerySortInfo> querySortInfoSupplier) {
		if (queryInfo.isNotSort()) {
			queryInfo.addSort(querySortInfoSupplier.get());
		}
	}

}
