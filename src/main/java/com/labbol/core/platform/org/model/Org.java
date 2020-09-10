/**
 * 
 */
package com.labbol.core.platform.org.model;

import org.yelong.core.model.annotation.ExtendColumn;
import org.yelong.core.model.annotation.Table;
import org.yelong.core.model.annotation.Transient;
import org.yelong.core.order.Orderable;

import com.labbol.core.model.BaseModel;

/**
 * @author PengFei
 */
@Table(value = "CO_ORG", alias = "org")
public class Org extends BaseModel<Org> implements Orderable {

	private static final long serialVersionUID = 6252651909683829956L;

	private String orgNo;

	private String parentOrgNo;

	private String orgName;

	private String orgShortName;

	private String orgCode;

	private String charger;

	private String tel;

	private String fax;

	private String address;

	private String summary;

	private Integer orgOrder;

	private String showChild;

	private String orgType;

	private String orgGroup;

	private String oldOrgCode;

	@ExtendColumn
	private String orgParentOrgName;

	@Transient
	private String oldOrgNo;

	@Transient
	private String oldParentOrgNo;

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getParentOrgNo() {
		return parentOrgNo;
	}

	public void setParentOrgNo(String parentOrgNo) {
		this.parentOrgNo = parentOrgNo;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgShortName() {
		return orgShortName;
	}

	public void setOrgShortName(String orgShortName) {
		this.orgShortName = orgShortName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getCharger() {
		return charger;
	}

	public void setCharger(String charger) {
		this.charger = charger;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getOrgOrder() {
		return orgOrder;
	}

	public void setOrgOrder(Integer orgOrder) {
		this.orgOrder = orgOrder;
	}

	public String getShowChild() {
		return showChild;
	}

	public void setShowChild(String showChild) {
		this.showChild = showChild;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgGroup() {
		return orgGroup;
	}

	public void setOrgGroup(String orgGroup) {
		this.orgGroup = orgGroup;
	}

	public String getOldOrgCode() {
		return oldOrgCode;
	}

	public void setOldOrgCode(String oldOrgCode) {
		this.oldOrgCode = oldOrgCode;
	}

	public String getOldOrgNo() {
		return oldOrgNo;
	}

	public void setOldOrgNo(String oldOrgNo) {
		this.oldOrgNo = oldOrgNo;
	}

	public String getOldParentOrgNo() {
		return oldParentOrgNo;
	}

	public void setOldParentOrgNo(String oldParentOrgNo) {
		this.oldParentOrgNo = oldParentOrgNo;
	}

	public String getOrgParentOrgName() {
		return orgParentOrgName;
	}

	public void setOrgParentOrgName(String orgParentOrgName) {
		this.orgParentOrgName = orgParentOrgName;
	}

	@Override
	public int getOrder() {
		return null == orgOrder ? LOWEST_PRECEDENCE : this.orgOrder;
	}
}
