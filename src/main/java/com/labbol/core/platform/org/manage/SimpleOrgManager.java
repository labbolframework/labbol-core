package com.labbol.core.platform.org.manage;

import java.util.List;

import com.labbol.core.platform.org.model.Org;
import com.labbol.core.platform.org.service.OrgCommonService;

/**
 * 简单的组织机构管理器
 * 
 * @since 2.0
 */
public class SimpleOrgManager implements OrgManager {

	protected final OrgCommonService orgCommonService;

	public SimpleOrgManager(OrgCommonService orgCommonService) {
		this.orgCommonService = orgCommonService;
	}

	@Override
	public List<Org> getAll() {
		return orgCommonService.findAll();
	}

	@Override
	public Org getByOrgNo(String orgNo) {
		return orgCommonService.findByOrgNo(orgNo);
	}

	@Override
	public List<Org> getByParentOrgNo(String parentOrgNo) {
		return orgCommonService.findByParentOrgNo(parentOrgNo);
	}

}
