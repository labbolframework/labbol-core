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
import org.yelong.core.model.Modelable;
import org.yelong.core.model.service.ModelService;

import com.labbol.core.check.CurrentLoginUserInfo;
import com.labbol.core.check.CurrentLoginUserInfoHolder;
import com.labbol.core.model.BaseModelable;
import com.labbol.core.platform.constants.State;
import com.labbol.core.utils.IDUtils;

/**
 * @author PengFei
 */
@Intercepts({
	@Signature(type = ModelService.class,method = "save",args = Modelable.class),
	@Signature(type = ModelService.class,method = "saveSelective",args = Modelable.class)
})
public class SaveModelServiceInterceptor implements Interceptor{

	public static final String SYSTEM_ADMIN_USER_NAME = "system";
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		Object model = args[0];
		if( model instanceof BaseModelable ) {
			BaseModelable baseModelable = (BaseModelable) model;
			baseModelable.setId(IDUtils.getUUID());
			Date createTime = Dates.nowDate();
			baseModelable.setCreateTime(createTime);
			baseModelable.setState(State.YES.getCode());
			baseModelable.setUpdateTime(createTime);
			
			String userName = SYSTEM_ADMIN_USER_NAME;
			CurrentLoginUserInfo currentLoginUserInfo = CurrentLoginUserInfoHolder.currentLoginUserInfo();
			if( null != currentLoginUserInfo) {
				if( null != currentLoginUserInfo.getUser()) {
					userName = currentLoginUserInfo.getUser().getUsername();
				}
			}
			baseModelable.setCreator(userName);
			baseModelable.setUpdator(userName);
		}
		return invocation.proceed();
	}

}
