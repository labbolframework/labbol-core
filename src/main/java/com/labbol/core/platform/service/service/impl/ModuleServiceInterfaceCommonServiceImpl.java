/**
 * 
 */
package com.labbol.core.platform.service.service.impl;

import java.util.List;

import org.yelong.core.model.collector.ModelCollectors;
import org.yelong.ssm.service.BaseSsmModelService;

import com.labbol.core.platform.service.model.ModuleServiceInterface;
import com.labbol.core.platform.service.service.ModuleServiceInterfaceCommonService;
import com.labbol.core.service.LabbolModelService;

/**
 * @author PengFei
 */
public class ModuleServiceInterfaceCommonServiceImpl extends BaseSsmModelService
		implements ModuleServiceInterfaceCommonService {

	protected final LabbolModelService modelService;

	public ModuleServiceInterfaceCommonServiceImpl(LabbolModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public List<ModuleServiceInterface> findAll() {
		return modelService.findAll(ModuleServiceInterface.class);
	}

	@Override
	public List<ModuleServiceInterface> findByServiceId(String serviceId) {
		return modelService
				.collect(ModelCollectors.findBySingleColumnEQ(ModuleServiceInterface.class, "serviceId", serviceId));
	}

	@Override
	public ModuleServiceInterface findByInterfaceName(String interfaceName) {
		return modelService.collect(
				ModelCollectors.getModelBySingleColumnEQ(ModuleServiceInterface.class, "interfaceName", interfaceName));
	}

}
