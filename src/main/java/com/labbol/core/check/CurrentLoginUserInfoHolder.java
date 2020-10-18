/**
 * 
 */
package com.labbol.core.check;

import org.yelong.core.annotation.Nullable;

import com.labbol.core.platform.org.model.Org;
import com.labbol.core.platform.user.model.User;

import dream.first.base.userauth.CurrentAuthUserInfoHolder;

/**
 * 当前登录（请求）用户{@link CurrentLoginUserInfo}的持有者
 * 
 * @author PengFei
 * @since 2.0
 */
public abstract class CurrentLoginUserInfoHolder {

	private CurrentLoginUserInfoHolder() {
	}

	/**
	 * 设置当前登录（请求）用户的信息
	 * 
	 * @param currentLoginUserInfo 当前登录（请求）用户的信息
	 */
	public static void setCurrentLoginUserInfo(CurrentLoginUserInfo currentLoginUserInfo) {
		CurrentAuthUserInfoHolder.setCurrentLoginUserInfo(currentLoginUserInfo);
	}

	/**
	 * @return 当前登录（请求）用户的信息
	 */
	@Nullable
	public static CurrentLoginUserInfo currentLoginUserInfo() {
		return (CurrentLoginUserInfo) CurrentAuthUserInfoHolder.getCurrentLoginUserInfo();
	}

	/**
	 * @return 当前登录/请求人的相关信息
	 * @see #currentLoginUserInfo()
	 */
	@Nullable
	public static CurrentLoginUserInfo getCurrentLoginUserInfo() {
		return currentLoginUserInfo();
	}

	/**
	 * @return 当前登录/请求人用户信息
	 */
	@Nullable
	public static User getCurrentLoginUser() {
		CurrentLoginUserInfo currentLoginUserInfo = getCurrentLoginUserInfo();
		return null == currentLoginUserInfo ? null : currentLoginUserInfo.getUser();
	}

	/**
	 * @return 当前登录/请求人的用户名称(账号)
	 */
	@Nullable
	public static String getCurrentLoginUsername() {
		User user = getCurrentLoginUser();
		return null == user ? null : user.getUsername();
	}

	/**
	 * @return 当前登录/请求人的用户真实名称
	 */
	@Nullable
	public static String getCurrentLoginUserRealName() {
		User user = getCurrentLoginUser();
		return null == user ? null : user.getRealName();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门
	 */
	@Nullable
	public static Org getCurrentLoginUserOrg() {
		CurrentLoginUserInfo currentLoginUserInfo = getCurrentLoginUserInfo();
		return null == currentLoginUserInfo ? null : currentLoginUserInfo.getOrg();
	}

	/**
	 * @return 当前登录/请求人的用户所有在部门的ID
	 */
	@Nullable
	public static String getCurrentLoginUserOrgId() {
		Org org = getCurrentLoginUserOrg();
		return null == org ? null : org.getId();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门的编号
	 */
	@Nullable
	public static String getCurrentLoginUserOrgNo() {
		Org org = getCurrentLoginUserOrg();
		return null == org ? null : org.getOrgNo();
	}

}
