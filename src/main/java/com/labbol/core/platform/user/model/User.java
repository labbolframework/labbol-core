/**
 * 
 */
package com.labbol.core.platform.user.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModelable;

import dream.first.base.platform.user.model.BaseUser;

/**
 * @author PengFei
 */
@Table(value = "CO_USER", alias = "usr")
public class User extends BaseUser<User> implements BaseModelable{

	private static final long serialVersionUID = 4722398860035012945L;

	/**
	 * @since 1.0.7
	 */
	@Column(columnName = "人员ID")
	private String employeeId;

	@Column(column = "secretDegree")
	private String secretDegree;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getSecretDegree() {
		return secretDegree;
	}

	public void setSecretDegree(String secretDegree) {
		this.secretDegree = secretDegree;
	}

}
