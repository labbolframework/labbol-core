/**
 * 
 */
package com.labbol.core.service;

import org.yelong.core.model.ModelConfiguration;
import org.yelong.mybatis.spring.MyBatisModelService;
import org.yelong.support.orm.mybaits.mapper.MyBatisBaseDataBaseOperation;

import com.labbol.core.queryinfo.filter.QueryFilterInfoResolver;

/**
 * @author PengFei
 */
public class LabbolModelServiceImpl extends MyBatisModelService implements LabbolModelService {

	private QueryFilterInfoResolver queryFilterInfoResolver;

	public LabbolModelServiceImpl(ModelConfiguration modelConfiguration,
			MyBatisBaseDataBaseOperation myBatisBaseDataBaseOperation,
			QueryFilterInfoResolver queryFilterInfoResolver) {
		super(modelConfiguration, myBatisBaseDataBaseOperation);
		this.queryFilterInfoResolver = queryFilterInfoResolver;
	}

	public QueryFilterInfoResolver getQueryFilterInfoResolver() {
		return queryFilterInfoResolver;
	}

	@Override
	public Class<?> getTargetClass() {
		return LabbolModelServiceImpl.class;
	}

}
