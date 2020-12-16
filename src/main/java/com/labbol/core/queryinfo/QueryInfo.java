/**
 * 
 */
package com.labbol.core.queryinfo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.labbol.core.queryinfo.filter.QueryFilterInfo;

/**
 * @author PengFei
 */
public class QueryInfo {

	private Integer pageNum;

	private Integer pageSize;

	private List<QueryFilterInfo> filters = new ArrayList<QueryFilterInfo>();

	private List<QuerySortInfo> sorters = new ArrayList<QuerySortInfo>();

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<QueryFilterInfo> getFilters() {
		return filters;
	}

	public void setFilters(List<QueryFilterInfo> filters) {
		this.filters = filters;
	}

	public List<QuerySortInfo> getSorters() {
		return sorters;
	}

	// ==================================================条件==================================================

	/**
	 * 添加一个排序条件
	 */
	public void addFilter(QueryFilterInfo queryFilterInfo) {
		this.filters.add(queryFilterInfo);
	}

	/**
	 * 是否存在条件
	 * 
	 * @date 2019年11月12日下午6:09:05
	 * @return <tt>true</tt> 存在条件
	 */
	public boolean isFilter() {
		return null != filters && !filters.isEmpty();
	}

	/**
	 * 条件是否为空
	 * 
	 * @author PengFei
	 * @date 2020年12月7日下午4:16:35
	 * @return <code>true</code> 条件为空
	 */
	public boolean isNotFilter() {
		return CollectionUtils.isEmpty(filters);
	}

	// ==================================================排序==================================================

	/**
	 * 设置排序信息。这会覆盖原有的排序信息
	 * 
	 * @date 2019年11月12日下午5:32:38
	 */
	public void setSorters(List<QuerySortInfo> sorters) {
		this.sorters = sorters;
	}

	/**
	 * 是否存在排序
	 * 
	 * @date 2019年10月23日下午12:02:52
	 * @return <tt>true</tt>存在排序
	 */
	public boolean isSort() {
		return null != sorters && !sorters.isEmpty();
	}

	/**
	 * 排序是否为空
	 * 
	 * @author PengFei
	 * @date 2020年12月7日下午4:14:47
	 * @return <code>true</code> 排序为空
	 */
	public boolean isNotSort() {
		return CollectionUtils.isEmpty(sorters);
	}

	/**
	 * 添加一个排序
	 * 
	 * @date 2019年10月23日下午12:04:20
	 */
	public void addSort(QuerySortInfo querySortInfo) {
		this.sorters.add(querySortInfo);
	}

	/**
	 * 添加一个排序
	 * 
	 * @date 2019年10月23日下午12:04:20
	 */
	public void addSort(String sortField, String direction) {
		this.sorters.add(new QuerySortInfo(sortField, direction));
	}

}
