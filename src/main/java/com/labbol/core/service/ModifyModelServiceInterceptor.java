/**
 * 
 */
package com.labbol.core.service;

import java.util.Date;

import org.yelong.commons.util.Dates;
import org.yelong.core.interceptor.Interceptor;
import org.yelong.core.interceptor.Intercepts;
import org.yelong.core.interceptor.Invocation;
import org.yelong.core.interceptor.Signature;
import org.yelong.core.jdbc.sql.condition.ConditionSqlFragment;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.service.ModelService;
import org.yelong.core.model.service.SqlModelService;
import org.yelong.core.model.service.SqlModelServiceAdapter;
import org.yelong.core.model.sql.SqlModel;

import com.labbol.core.check.CurrentLoginUserInfo;
import com.labbol.core.check.CurrentLoginUserInfoHolder;
import com.labbol.core.model.BaseModelable;
import com.labbol.core.platform.constants.State;

/**
 * @author PengFei
 *
 */
@Intercepts({
	@Signature(type = ModelService.class, method = "modifyBySqlFragment", args = { Modelable.class,
			ConditionSqlFragment.class }),
	@Signature(type = ModelService.class, method = "modifySelectiveBySqlFragment", args = { Modelable.class,
			ConditionSqlFragment.class }),
	@Signature(type = SqlModelService.class, method = "modifyBySqlModel", args = { Modelable.class,
			SqlModel.class }),
	@Signature(type = SqlModelService.class, method = "modifySelectiveBySqlModel", args = { Modelable.class,
			SqlModel.class }),
	@Signature(type = SqlModelServiceAdapter.class, method = "modifyById", args = { Modelable.class }),
	@Signature(type = SqlModelServiceAdapter.class, method = "modifyByOnlyPrimaryKey", args = { Modelable.class }),
	@Signature(type = SqlModelServiceAdapter.class, method = "modifySelectiveById", args = { Modelable.class }),
	@Signature(type = SqlModelServiceAdapter.class, method = "modifySelectiveByOnlyPrimaryKey", args = {
			Modelable.class }),
	@Signature(type = SqlModelServiceAdapter.class, method = "modifyByCondition", args = { Modelable.class,
			ConditionSqlFragment.class }),
	@Signature(type = SqlModelServiceAdapter.class, method = "modifySelectiveByCondition", args = { Modelable.class,
			ConditionSqlFragment.class }), })
public class ModifyModelServiceInterceptor implements Interceptor{

	public static final String SYSTEM_ADMIN_USER_NAME = "system";
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		Object model = args[0];
		if( model instanceof BaseModelable ) {
			BaseModelable baseModelable = (BaseModelable) model;
			Date createTime = Dates.nowDate();
			baseModelable.setState(State.YES.getCode());
			baseModelable.setUpdateTime(createTime);
			String userName = SYSTEM_ADMIN_USER_NAME;
			CurrentLoginUserInfo currentLoginUserInfo = CurrentLoginUserInfoHolder.currentLoginUserInfo();
			if( null != currentLoginUserInfo) {
				if( null != currentLoginUserInfo.getUser()) {
					userName = currentLoginUserInfo.getUser().getUsername();
				}
			}
			baseModelable.setUpdator(userName);
		}
		return invocation.proceed();
	}

}
