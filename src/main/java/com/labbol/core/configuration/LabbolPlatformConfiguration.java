/**
 * 
 */
package com.labbol.core.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import com.labbol.core.Labbol;
import com.labbol.core.platform.dict.manage.DictManager;
import com.labbol.core.platform.dict.manage.SimpleDictManager;
import com.labbol.core.platform.dict.service.DictCommonService;
import com.labbol.core.platform.dict.service.impl.DictCommonServiceImpl;
import com.labbol.core.platform.icon.manage.IconManager;
import com.labbol.core.platform.icon.manage.SimpleIconManager;
import com.labbol.core.platform.icon.service.IconCommonService;
import com.labbol.core.platform.icon.service.impl.IconCommonServiceImpl;
import com.labbol.core.platform.login.service.LoginSessionCommonService;
import com.labbol.core.platform.login.service.impl.LoginSessionCommonServiceImpl;
import com.labbol.core.platform.module.manage.ModuleManager;
import com.labbol.core.platform.module.manage.SimpleModuleManager;
import com.labbol.core.platform.module.service.ModuleCommonService;
import com.labbol.core.platform.module.service.impl.ModuleCommonServiceImpl;
import com.labbol.core.platform.org.manage.OrgManager;
import com.labbol.core.platform.org.manage.SimpleOrgManager;
import com.labbol.core.platform.org.service.OrgCommonService;
import com.labbol.core.platform.org.service.impl.OrgCommonServiceImpl;
import com.labbol.core.platform.role.service.RoleCommonService;
import com.labbol.core.platform.role.service.RoleDataRightCommonService;
import com.labbol.core.platform.role.service.RoleRightCommonService;
import com.labbol.core.platform.role.service.impl.RoleCommonServiceImpl;
import com.labbol.core.platform.role.service.impl.RoleDataRightCommonServiceImpl;
import com.labbol.core.platform.role.service.impl.RoleRightCommonServiceImpl;
import com.labbol.core.platform.service.manage.ModuleServiceManager;
import com.labbol.core.platform.service.manage.SimpleModuleServiceManager;
import com.labbol.core.platform.service.service.ModuleServiceCommonService;
import com.labbol.core.platform.service.service.ModuleServiceInterfaceCommonService;
import com.labbol.core.platform.service.service.impl.ModuleServiceCommonServiceImpl;
import com.labbol.core.platform.service.service.impl.ModuleServiceInterfaceCommonServiceImpl;
import com.labbol.core.platform.user.service.UserCommonService;
import com.labbol.core.platform.user.service.UserExtraOrgCommonService;
import com.labbol.core.platform.user.service.UserRightCommonService;
import com.labbol.core.platform.user.service.UserRoleCommonService;
import com.labbol.core.platform.user.service.impl.UserCommonServiceImpl;
import com.labbol.core.platform.user.service.impl.UserExtraOrgCommonServiceImpl;
import com.labbol.core.platform.user.service.impl.UserRightCommonServiceImpl;
import com.labbol.core.platform.user.service.impl.UserRoleCommonServiceImpl;
import com.labbol.core.service.LabbolModelService;

/**
 * 平台服务配置
 * 
 * 这些服务默认情况下是注入的
 * 
 * @since 1.0.0
 */
@ConditionalOnProperty(prefix = Labbol.LABBOL_PROPERTIES_PREFIX, name = "auto", havingValue = "true", matchIfMissing = true)
public class LabbolPlatformConfiguration {

	public static final String DREAM_FIRST_PROPERTIES_PREFIX = Labbol.LABBOL_PROPERTIES_PREFIX
			+ ".platform";

	// ===========================字典============================

	/**
	 * @return 字典服务
	 */
	@Bean
	@ConditionalOnMissingBean(DictCommonService.class)
	public DictCommonService dictService(LabbolModelService modelService) {
		return new DictCommonServiceImpl(modelService);
	}

	/**
	 * @param dictCommonService 字典公共服务
	 * @return 字典管理管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = DictManager.class)
	public DictManager dictManager(DictCommonService dictCommonService) {
		return new SimpleDictManager(dictCommonService);
	}

	// ===========================图标============================

	/**
	 * @return 图标管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = IconCommonService.class)
	public IconCommonService iconCommonService(LabbolModelService modelService) {
		return new IconCommonServiceImpl(modelService);
	}

	/**
	 * @return 图标管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = IconManager.class)
	public IconManager iconManager(IconCommonService iconCommonService) {
		return new SimpleIconManager(iconCommonService);
	}

	// ===========================模块============================

	/**
	 * @return 模块服务
	 */
	@Bean
	@ConditionalOnMissingBean(ModuleCommonService.class)
	public ModuleCommonService moduleService(LabbolModelService modelService) {
		return new ModuleCommonServiceImpl(modelService);
	}

	/**
	 * @param moduleCommonService 模块公共服务
	 * @return 模块管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = ModuleManager.class)
	public ModuleManager moduleManager(ModuleCommonService moduleCommonService) {
		return new SimpleModuleManager(moduleCommonService);
	}

	// ===========================组织============================

	/**
	 * @return 组织服务
	 */
	@Bean
	@ConditionalOnMissingBean(OrgCommonService.class)
	public OrgCommonService orgService(LabbolModelService modelService) {
		return new OrgCommonServiceImpl(modelService);
	}

	/**
	 * @param orgCommonService 组织公共服务
	 * @return 组织管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = OrgManager.class)
	public OrgManager orgManager(OrgCommonService orgCommonService) {
		return new SimpleOrgManager(orgCommonService);
	}

	// ===========================角色============================

	/**
	 * @return 角色数据权限
	 */
	@Bean
	@ConditionalOnMissingBean(RoleDataRightCommonService.class)
	public RoleDataRightCommonService roleDataRightService(LabbolModelService modelService) {
		return new RoleDataRightCommonServiceImpl(modelService);
	}

	/**
	 * @return 角色权限
	 */
	@Bean
	@ConditionalOnMissingBean(RoleRightCommonService.class)
	public RoleRightCommonService roleRightCommonService(LabbolModelService modelService) {
		return new RoleRightCommonServiceImpl(modelService);
	}

	/**
	 * @return 角色服务
	 */
	@Bean
	@ConditionalOnMissingBean(RoleCommonService.class)
	public RoleCommonService roleService(LabbolModelService modelService, RoleRightCommonService roleRightService,
			RoleDataRightCommonService roleDataRightService) {
		return new RoleCommonServiceImpl(modelService, roleRightService, roleDataRightService);
	}

	// ===========================用户============================

	/**
	 * @return 用户组织权限
	 */
	@Bean
	@ConditionalOnMissingBean(UserExtraOrgCommonService.class)
	public UserExtraOrgCommonService userExtraOrgService(LabbolModelService modelService) {
		return new UserExtraOrgCommonServiceImpl(modelService);
	}

	/**
	 * @return 用户权限
	 */
	@Bean
	@ConditionalOnMissingBean(UserRightCommonService.class)
	public UserRightCommonService userRightCommonService(LabbolModelService modelService) {
		return new UserRightCommonServiceImpl(modelService);
	}

	/**
	 * @return 用户角色
	 */
	@Bean
	@ConditionalOnMissingBean(UserRoleCommonService.class)
	public UserRoleCommonService userRoleService(LabbolModelService modelService) {
		return new UserRoleCommonServiceImpl(modelService);
	}

	/**
	 * @return 用户服务
	 */
	@Bean
	@ConditionalOnMissingBean(UserCommonService.class)
	public UserCommonService userCommonService(LabbolModelService modelService) {
		return new UserCommonServiceImpl(modelService);
	}

	// ===========================服务接口============================

	/**
	 * @return 模块接口服务
	 */
	@Bean
	@ConditionalOnMissingBean(ModuleServiceInterfaceCommonService.class)
	public ModuleServiceInterfaceCommonService moduleServiceInterfaceService(LabbolModelService modelService) {
		return new ModuleServiceInterfaceCommonServiceImpl(modelService);
	}

	/**
	 * @return 模块接口服务
	 */
	@Bean
	@ConditionalOnMissingBean(ModuleServiceCommonService.class)
	public ModuleServiceCommonService moduleServiceCommonService(LabbolModelService modelService) {
		return new ModuleServiceCommonServiceImpl(modelService);
	}

	/**
	 * @param moduleServiceCommonService          模块服务公共服务
	 * @param moduleServiceInterfaceCommonService 模块服务接口公共服务
	 * @return 模块服务管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = ModuleServiceManager.class)
	public ModuleServiceManager moduleServiceManager(ModuleServiceCommonService moduleServiceCommonService,
			ModuleServiceInterfaceCommonService moduleServiceInterfaceCommonService) {
		return new SimpleModuleServiceManager(moduleServiceCommonService, moduleServiceInterfaceCommonService);
	}

	// ===========================登录============================

	/**
	 * @return 登录会话服务
	 */
	@Bean
	@ConditionalOnMissingBean(LoginSessionCommonService.class)
	public LoginSessionCommonService loginSessionCommonService(LabbolModelService modelService) {
		return new LoginSessionCommonServiceImpl(modelService);
	}

}
