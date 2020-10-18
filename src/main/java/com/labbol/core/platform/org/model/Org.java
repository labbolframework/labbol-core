/**
 * 
 */
package com.labbol.core.platform.org.model;

import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModelable;

import dream.first.base.platform.org.model.BaseOrg;

/**
 * @author PengFei
 */
@Table(value = "CO_ORG", alias = "org")
public class Org extends BaseOrg<Org> implements BaseModelable{

	private static final long serialVersionUID = 6252651909683829956L;
	
}
