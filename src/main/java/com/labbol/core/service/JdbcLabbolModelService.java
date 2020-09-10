/**
 * 
 */
package com.labbol.core.service;

import org.yelong.core.jdbc.BaseDataBaseOperation;
import org.yelong.core.model.ModelConfiguration;
import org.yelong.core.model.convertor.ModelAndMapConvertor;
import org.yelong.core.model.service.JdbcModelService;

import com.labbol.core.queryinfo.filter.QueryFilterInfoResolver;

/**
 * 默认实现。数据库操作使用普通的JDBC
 * 
 * @since 2.0
 */
public class JdbcLabbolModelService extends JdbcModelService implements LabbolModelService {

	private final QueryFilterInfoResolver queryFilterInfoResolver;

	public JdbcLabbolModelService(ModelConfiguration modelConfiguration, BaseDataBaseOperation db,
			QueryFilterInfoResolver queryFilterInfoResolver) {
		super(modelConfiguration, db);
		this.queryFilterInfoResolver = queryFilterInfoResolver;
	}

	public JdbcLabbolModelService(ModelConfiguration modelConfiguration, BaseDataBaseOperation db,
			ModelAndMapConvertor modelAndMapConvertor, QueryFilterInfoResolver queryFilterInfoResolver) {
		super(modelConfiguration, db, modelAndMapConvertor);
		this.queryFilterInfoResolver = queryFilterInfoResolver;
	}

	@Override
	public Class<?> getTargetClass() {
		return JdbcLabbolModelService.class;
	}

	@Override
	public QueryFilterInfoResolver getQueryFilterInfoResolver() {
		return queryFilterInfoResolver;
	}

}
