/**
 * 
 */
package com.labbol.core.platform.service.service.impl;

import java.util.List;

import org.yelong.ssm.service.BaseSsmModelService;

import com.labbol.core.platform.service.model.ModuleService;
import com.labbol.core.platform.service.service.ModuleServiceCommonService;
import com.labbol.core.service.LabbolModelService;

/**
 * @author PengFei
 */
public class ModuleServiceCommonServiceImpl extends BaseSsmModelService implements ModuleServiceCommonService {

	protected final LabbolModelService modelService;

	public ModuleServiceCommonServiceImpl(LabbolModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public ModuleService findByServiceName(String serviceName) {
		ModuleService sqlModel = new ModuleService();
		sqlModel.setServiceNameEn(serviceName);
		ModuleService moduleService = modelService.findFirstBySqlModel(ModuleService.class, sqlModel);
		return moduleService;
	}

	@Override
	public List<ModuleService> findAll() {
		return modelService.findAll(ModuleService.class);
	}

	@Override
	public ModuleService findById(String id) {
		return modelService.findById(ModuleService.class, id);
	}

}
