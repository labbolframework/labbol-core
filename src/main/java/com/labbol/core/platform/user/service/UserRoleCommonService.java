/**
 * 
 */
package com.labbol.core.platform.user.service;

import java.util.List;

import com.labbol.core.platform.user.model.User;
import com.labbol.core.platform.user.model.UserRole;

/**
 * @author PengFei
 */
public interface UserRoleCommonService {

	/**
	 * 根据用户查询用户角色信息
	 * 
	 * @param userId 用戶id
	 * @return 用戶角色集合
	 */
	List<UserRole> findByUserId(String userId);

	/**
	 * 根据角色名称查询拥有该角色的用户信息
	 * 
	 * @param roleName 角色名称
	 * @return 拥有该角色的所有用户信息
	 */
	List<User> findUserByRoleName(String roleName);

	/**
	 * 查询是否存在用户名称和角色名称到的记录 <br/>
	 * 
	 * 翻译：查询用户(username)是否是这个(roleName)角色
	 * 
	 * @param username 用戶名稱
	 * @param roleName 橘色名稱
	 * @return <code>true</code> 拥有
	 */
	boolean existByUsernameAndRoleName(String username, String roleName);

}
