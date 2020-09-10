/**
 * 
 */
package com.labbol.core.controller;

import org.yelong.core.annotation.Nullable;
import org.yelong.support.spring.mvc.controller.AbstractSpringMvcController;
import org.yelong.support.spring.mvc.token.RequestUserInfo;
import org.yelong.support.spring.mvc.token.RequestUserInfoHolder;
import org.yelong.support.spring.mvc.token.TokenValidate;
import org.yelong.support.spring.mvc.token.TokenValidate.TokenLocation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.labbol.core.Labbol;
import com.labbol.core.check.CurrentLoginUserInfo;
import com.labbol.core.check.CurrentLoginUserInfoHolder;
import com.labbol.core.check.login.LoginUserInfo;
import com.labbol.core.check.login.LoginUserInfoHolder;
import com.labbol.core.check.login.LoginValidate;
import com.labbol.core.check.sign.annotation.SignValidate;
import com.labbol.core.check.sign.bean.RequestMapBean;
import com.labbol.core.check.sign.holder.RequestMapHolder;
import com.labbol.core.gson.GsonSupplier;
import com.labbol.core.platform.org.model.Org;
import com.labbol.core.platform.user.model.User;

/**
 * 基础的 controller
 * 
 * 提供默认的JSON转换，获取当前登陆人等公共且常用的方法
 * 
 * @author PengFei
 * @since 2.0
 */
@TokenValidate(tokenLocation = TokenLocation.HEADER, tokenParamName = Labbol.X_AUTH_TOKEN) // 令牌验证
@SignValidate // 签名验证	
@LoginValidate // 登录验证
public abstract class BaseCoreController extends AbstractSpringMvcController {

	public static final String TOKEN_PARAM_NAME = Labbol.X_AUTH_TOKEN;
	
	/**
	 * 使用默认的Gson将对象转换转换为JSON
	 * 
	 * @param obj 对象
	 * @return JSON格式的字符串
	 * @see #getGson()
	 */
	protected String toJson(Object obj) {
		Gson gson = getGson();
		return gson.toJson(obj);
	}

	/**
	 * @return 默认的Gson
	 * @see GsonSupplier#getDefaultGson()
	 */
	protected Gson getGson() {
		return GsonSupplier.getDefaultGson();
	}

	/**
	 * @return 默认Gson构建器
	 * @see GsonSupplier#createGsonBuilder()
	 */
	protected GsonBuilder createDefaultGsonBuilder() {
		return GsonSupplier.createGsonBuilder();
	}

	// ==================================================当前登录/请求人信息==================================================

	/**
	 * @return 当前登录/请求人的相关信息
	 * @see CurrentLoginUserInfoHolder#currentLoginUserInfo()
	 */
	@Nullable
	protected CurrentLoginUserInfo getCurrentLoginUserInfo() {
		return CurrentLoginUserInfoHolder.currentLoginUserInfo();
	}

	/**
	 * @return 当前登录/请求人用户信息
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUser()
	 */
	@Nullable
	protected User getCurrentLoginUser() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUser();
	}

	/**
	 * @return 当前登录/请求人的用户名称(账号)
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUsername()
	 */
	@Nullable
	protected String getCurrentLoginUsername() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUsername();
	}

	/**
	 * @return 当前登录/请求人的用户真实名称
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserRealName()
	 */
	@Nullable
	protected String getCurrentLoginUserRealName() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserRealName();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserOrg()
	 */
	@Nullable
	protected Org getCurrentLoginUserOrg() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserOrg();
	}

	/**
	 * @return 当前登录/请求人的用户所有在部门的ID
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserOrgId()
	 */
	@Nullable
	protected String getCurrentLoginUserOrgId() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserOrgId();
	}

	/**
	 * @return 获取当前登录人
	 * @see #getCurrentLoginUserInfo()
	 */
	@Nullable
	@Deprecated
	protected LoginUserInfo getLoginUserInfo() {
		return LoginUserInfoHolder.currentLoginUser();
	}

	/**
	 * @return 当前请求人。这应该是通过token认证通过的
	 * @see #getCurrentLoginUserInfo()
	 */
	@Nullable
	@Deprecated
	protected RequestUserInfo getRequestUserInfo() {
		return RequestUserInfoHolder.currentRequestUserInfo();
	}

	protected RequestMapBean getRequestMap() {
		return (RequestMapBean) RequestMapHolder.getRequestMapBean();
	}

}
