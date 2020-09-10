/**
 * 
 */
package com.labbol.core.platform.user.service;

import java.util.List;

import com.labbol.core.platform.user.model.UserExtraOrg;

/**
 * @author PengFei
 */
public interface UserExtraOrgCommonService {

	/**
	 * 根据用户id查询用户附属部门信息
	 * 
	 * @param userId 用戶id
	 * @return 附屬部門
	 */
	List<UserExtraOrg> findByUserId(String userId) throws Exception;

}
