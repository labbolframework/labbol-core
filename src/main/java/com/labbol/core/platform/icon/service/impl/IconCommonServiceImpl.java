/**
 * 
 */
package com.labbol.core.platform.icon.service.impl;

import java.util.List;

import com.labbol.core.platform.icon.model.Icon;
import com.labbol.core.platform.icon.service.IconCommonService;
import com.labbol.core.service.LabbolModelService;

/**
 * 图标公共服务默认实现
 * 
 * @since 2.0
 */
public class IconCommonServiceImpl implements IconCommonService {

	protected final LabbolModelService modelService;

	public IconCommonServiceImpl(LabbolModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public List<Icon> findAll() {
		return modelService.findAll(Icon.class);
	}

}
