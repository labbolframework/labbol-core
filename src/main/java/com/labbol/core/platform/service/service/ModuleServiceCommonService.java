/**
 * 
 */
package com.labbol.core.platform.service.service;

import java.util.List;

import com.labbol.core.platform.service.model.ModuleService;

/**
 * @author PengFei
 */
public interface ModuleServiceCommonService {

	/**
	 * 获取所有的模块服务
	 * 
	 * @return 所有的模块服务
	 */
	List<ModuleService> findAll();

	/**
	 * 根据服务名称获取模块服务信息。
	 * 
	 * @param serviceName 服务名称。此名称应该为服务的英文名称
	 * @return 模块服务
	 */
	ModuleService findByServiceName(String serviceName);

	/**
	 * 根据服务ID获取模块服务信息。
	 * 
	 * @param id 服务ID
	 * @return 模块服务
	 */
	ModuleService findById(String id);

}
