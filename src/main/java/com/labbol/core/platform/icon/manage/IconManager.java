package com.labbol.core.platform.icon.manage;

import java.util.List;

import com.labbol.core.platform.icon.model.Icon;

/**
 * 图标管理器
 * 
 * @since 2.0
 */
public interface IconManager {

	/**
	 * 获取所有的图标
	 * 
	 * @return 所有的图标
	 */
	List<Icon> getAll();

}
