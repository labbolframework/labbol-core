/**
 * 
 */
package com.labbol.core.platform.user.service;

import java.util.List;

import com.labbol.core.platform.module.model.Module;
import com.labbol.core.platform.role.model.Role;

/**
 * @author PengFei
 */
public interface UserRightCommonService {

	/**
	 * 查询用户所拥有的角色
	 * 
	 * @param userId 用戶id
	 * @return 角色集合
	 */
	List<Role> findRole(String userId);

	/**
	 * 查询用户所拥有的角色id
	 * 
	 * @param userId 用戶id
	 * @return 角色id集合
	 */
	List<String> findRoleIds(String userId);

	/**
	 * 查询用户可操作性的模块
	 * 
	 * @param userId 用戶id
	 * @return 可操作性的模块
	 */
	List<Module> findModule(String userId);

	/**
	 * 查询用户可操作的模块id
	 * 
	 * @param userId 用戶id
	 * @return 可操作性的模块id
	 */
	List<String> findModuleIds(String userId);

}
