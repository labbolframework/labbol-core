/**
 * 
 */
package com.labbol.core.platform.login.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;
import org.yelong.commons.lang.Strings;
import org.yelong.core.model.collector.ModelCollectors;
import org.yelong.ssm.service.BaseSsmModelService;

import com.labbol.core.platform.login.model.LoginSession;
import com.labbol.core.platform.login.service.LoginSessionCommonService;
import com.labbol.core.service.LabbolModelService;

/**
 * @author PengFei
 * @since 2.0
 */
@Service
public class LoginSessionCommonServiceImpl extends BaseSsmModelService implements LoginSessionCommonService {

	protected final LabbolModelService modelService;

	public LoginSessionCommonServiceImpl(LabbolModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public LoginSession getByUsername(String username) {
		return modelService.collect(ModelCollectors.getModelBySingleColumnEQ(LoginSession.class, "username", username));
	}

	@Override
	public void saveOverrideUsername(LoginSession loginSession) {
		Objects.requireNonNull(loginSession);
		Strings.requireNonBlank(loginSession.getUsername());
		modelService.collect(
				ModelCollectors.removeBySingleColumnEQ(LoginSession.class, "username", loginSession.getUsername()));
		modelService.saveSelective(loginSession);
	}

}
