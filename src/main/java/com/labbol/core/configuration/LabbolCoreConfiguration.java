/**
 * 
 */
package com.labbol.core.configuration;

import java.util.List;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.HandlerInterceptor;
import org.yelong.core.interceptor.Interceptor;
import org.yelong.core.interceptor.InterceptorChain;
import org.yelong.core.jdbc.dialect.Dialect;
import org.yelong.core.jdbc.sql.condition.support.ConditionResolver;
import org.yelong.core.jdbc.sql.factory.SqlFragmentFactory;
import org.yelong.core.model.ModelConfiguration;
import org.yelong.core.model.manage.ModelManager;
import org.yelong.core.model.property.ModelProperty;
import org.yelong.core.model.service.ModelServiceInterceptor;
import org.yelong.core.model.sql.SqlModelResolver;
import org.yelong.http.client.DefaultHttpClient;
import org.yelong.http.client.HttpClient;
import org.yelong.support.orm.mybaits.mapper.MyBatisBaseDataBaseOperation;

import com.labbol.core.Labbol;
import com.labbol.core.handler.interceptor.DefaultInterceptorConfiguration;
import com.labbol.core.model.sql.LabbolSqlModelResolver;
import com.labbol.core.queryinfo.filter.QueryFilterInfoResolver;
import com.labbol.core.queryinfo.filter.impl.oracle.OracleQueryFilterInfoResolver;
import com.labbol.core.service.LabbolModelService;
import com.labbol.core.service.LabbolModelServiceImpl;

import dream.first.base.model.interceptor.ModifyModelInterceptor;
import dream.first.base.model.interceptor.SaveModelInterceptor;

/**
 * 基础配置
 * 
 * @since 1.0.0
 */
public class LabbolCoreConfiguration {

	/**
	 * @return SqlModel解析器
	 */
	@Bean
	@ConditionalOnMissingBean(SqlModelResolver.class)
	public LabbolSqlModelResolver labbolSqlModelResolver(ModelManager modelManager, ConditionResolver conditionResolver,
			SqlFragmentFactory sqlFragmentFactory, ModelProperty modelProperty) {
		return new LabbolSqlModelResolver(modelManager, conditionResolver, sqlFragmentFactory, modelProperty);
	}

	/**
	 * @param dialect 方言
	 * @return 查询过滤信息解析器
	 */
	@Bean
	@ConditionalOnMissingBean(QueryFilterInfoResolver.class)
	public QueryFilterInfoResolver queryFilterInfoResolver(Dialect dialect) {
		return new OracleQueryFilterInfoResolver();
	}

	/**
	 * @param modelConfiguration           模型配置
	 * @param myBatisBaseDataBaseOperation db
	 * @param queryFilterInfoResolver      查询过滤解析器
	 * @return 模型业务服务
	 */
	@Bean("labbolModelService")
	@ConditionalOnMissingBean(LabbolModelService.class)
	public LabbolModelService modelService(ModelConfiguration modelConfiguration,
			MyBatisBaseDataBaseOperation myBatisBaseDataBaseOperation,
			QueryFilterInfoResolver queryFilterInfoResolver) {
		return new LabbolModelServiceImpl(modelConfiguration, myBatisBaseDataBaseOperation, queryFilterInfoResolver);
	}

	/**
	 * 保存拦截器。在保存前设置创建人、创建时间等信息。
	 * 
	 * @return 保存拦截器
	 */
	@Bean
	@ConditionalOnMissingBean
	public SaveModelInterceptor saveModelInterceptor() {
		return new SaveModelInterceptor();
	}

	/**
	 * 修改拦截器。在修改时设置修改人、修改时间等信息。
	 * 
	 * @return 修改拦截器
	 */
	@Bean
	@ConditionalOnMissingBean
	public ModifyModelInterceptor modifyModelInterceptor() {
		return new ModifyModelInterceptor();
	}

	@Primary
	@Bean("modelService")
	@ConditionalOnBean(Interceptor.class)
	@ConditionalOnSingleCandidate(LabbolModelService.class)
	@ConditionalOnProperty(prefix = Labbol.LABBOL_PROPERTIES_PREFIX, name = "modelServiceProxy", havingValue = "true", matchIfMissing = true)
	public LabbolModelService dreamFirstModelServiceProxy(LabbolModelService labbolModelService,
			ObjectProvider<List<ModelServiceInterceptor>> interceptorProvider) {
		List<ModelServiceInterceptor> interceptors = interceptorProvider.getIfAvailable();
		InterceptorChain interceptorChain = new InterceptorChain();
		interceptorChain.addInterceptor(interceptors);
		Class<?> targetClass = AopUtils.getTargetClass(labbolModelService);
		if (null == targetClass) {
			return (LabbolModelService) interceptorChain.pluginAll(labbolModelService);
		} else {
			return (LabbolModelService) interceptorChain.pluginAll(labbolModelService, targetClass.getInterfaces());
		}
	}

	// ===========================拦截器===========================

	/**
	 * @return 拦截器配置
	 */
	@Bean
	public DefaultInterceptorConfiguration interceptorConfiguration() {
		return new DefaultInterceptorConfiguration();
	}

	/**
	 * 如果没有拦截器则默认加载一个空的拦截器
	 * 
	 * @return 默认的拦截器
	 */
	@Bean
	@ConditionalOnMissingBean(HandlerInterceptor.class)
	public HandlerInterceptor handlerInterceptor() {
		return new HandlerInterceptor() {
		};
	}

	// ===========================http===========================

	@Bean
	@ConditionalOnMissingBean(HttpClient.class)
	public HttpClient httpClient() {
		return new DefaultHttpClient();
	}

}
