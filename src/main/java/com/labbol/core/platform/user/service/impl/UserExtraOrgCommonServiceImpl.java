/**
 * 
 */
package com.labbol.core.platform.user.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.ssm.service.BaseSsmModelService;

import com.labbol.core.platform.user.model.UserExtraOrg;
import com.labbol.core.platform.user.service.UserExtraOrgCommonService;
import com.labbol.core.service.LabbolModelService;

/**
 * @author PengFei
 */
public class UserExtraOrgCommonServiceImpl extends BaseSsmModelService implements UserExtraOrgCommonService {

	protected final LabbolModelService modelService;

	public UserExtraOrgCommonServiceImpl(LabbolModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public List<UserExtraOrg> findByUserId(String userId) throws Exception {
		if (StringUtils.isEmpty(userId)) {
			return Collections.emptyList();
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("userExtraOrg.userId", "=", userId);
		return modelService.findByCondition(UserExtraOrg.class, combinationCondition);
	}

}
