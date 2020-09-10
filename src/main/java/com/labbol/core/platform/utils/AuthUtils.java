/**
 * 
 */
package com.labbol.core.platform.utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.labbol.core.check.CurrentLoginUserInfo;
import com.labbol.core.check.CurrentLoginUserInfoHolder;
import com.labbol.core.platform.user.model.User;

/**
 * @author PengFei
 */
public final class AuthUtils {

	/**
	 * 判断登录用户是否拥有该模块的权限
	 * 
	 * @param moduleId 模块id
	 * @return <code>true</code> 拥有
	 */
	public static boolean hasOpRight(String moduleId) {
		if (StringUtils.isBlank(moduleId)) {
			return false;
		}
		CurrentLoginUserInfo currentLoginUserInfo = CurrentLoginUserInfoHolder.currentLoginUserInfo();
		if (null == currentLoginUserInfo) {
			return false;
		}
		// 如果为超级管理员则不用验证权限
		User user = currentLoginUserInfo.getUser();
		if (null != user && "1".equals(user.getIsSuper())) {
			return true;
		}
		// 验证用户是否拥有该模块的权限
		List<String> opRights = currentLoginUserInfo.getOpRights();
		return opRights.contains(moduleId);
	}
}
