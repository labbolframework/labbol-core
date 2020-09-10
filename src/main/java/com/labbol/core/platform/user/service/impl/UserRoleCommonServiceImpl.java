/**
 * 
 */
package com.labbol.core.platform.user.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.ssm.service.BaseSsmModelService;

import com.labbol.core.platform.user.model.User;
import com.labbol.core.platform.user.model.UserRole;
import com.labbol.core.platform.user.service.UserRoleCommonService;
import com.labbol.core.service.LabbolModelService;

/**
 * @author PengFei
 */
public class UserRoleCommonServiceImpl extends BaseSsmModelService implements UserRoleCommonService {

	protected final LabbolModelService modelService;

	public UserRoleCommonServiceImpl(LabbolModelService modelService) {
		this.modelService = modelService;
	}
	@Override
	public List<UserRole> findByUserId(String userId){
		if(StringUtils.isEmpty(userId)) {
			return Collections.emptyList();
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("userRole.userId", "=", userId);
		return modelService.findByCondition(UserRole.class,combinationCondition);
	}
	
	
	@Override
	public List<User> findUserByRoleName(String roleName){
		String sql = "select usr.*  " + 
				"from CO_USER usr " + 
				"inner join CO_USER_ROLE userRole on usr.id = userRole.userId " + 
				"inner join CO_ROLE role on role.id = userRole.roleId where role.roleName = ? ";
		return modelService.findBySQL(User.class,sql, new Object[] {roleName});
	}
	
	@Override
	public boolean existByUsernameAndRoleName(String username, String roleName) {
		String sql = "select count(1) from CO_USER u  " + 
				"inner join CO_USER_ROLE userRole on userRole.userId = u.id " + 
				"inner join CO_ROLE role on role.id = userRole.roleId " + 
				"where u.username = ? and role.rolename = ? ";
		return modelService.getBaseDataBaseOperation().count(sql, username,roleName) > 0;
	}
	
}
