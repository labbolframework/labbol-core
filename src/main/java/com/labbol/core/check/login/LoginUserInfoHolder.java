/**
 * 
 */
package com.labbol.core.check.login;

import com.labbol.core.check.CurrentLoginUserInfoHolder;

/**
 * @author PengFei
 */
public class LoginUserInfoHolder {

	public static void setLoginUser(LoginUserInfo user) {
		CurrentLoginUserInfoHolder.setCurrentLoginUserInfo(user);
	}

	public static LoginUserInfo currentLoginUser() {
		return (LoginUserInfo) CurrentLoginUserInfoHolder.currentLoginUserInfo();
	}
}
