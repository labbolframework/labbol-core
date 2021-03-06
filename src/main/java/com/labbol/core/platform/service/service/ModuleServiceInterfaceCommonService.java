/**
 * 
 */
package com.labbol.core.platform.service.service;

import java.util.List;

import com.labbol.core.platform.service.model.ModuleServiceInterface;

/**
 * @author PengFei
 */
public interface ModuleServiceInterfaceCommonService {

	/**
	 * 获取所有的模块服务接口
	 * 
	 * @return 所有的模块服务接口
	 */
	List<ModuleServiceInterface> findAll();

	/**
	 * 获取指定模块服务下的所有接口
	 * 
	 * @param serviceId 接口
	 * @return 指定模块服务下的所有接口
	 */
	List<ModuleServiceInterface> findByServiceId(String serviceId);

	/**
	 * 根据接口名称查询服务接口
	 * 
	 * @param interfaceName 接口名称
	 * @return
	 */
	ModuleServiceInterface findByInterfaceName(String interfaceName);

}
