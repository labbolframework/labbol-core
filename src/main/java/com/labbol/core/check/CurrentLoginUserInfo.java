/**
 * 
 */
package com.labbol.core.check;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yelong.core.annotation.Nullable;

import com.labbol.core.platform.org.model.Org;
import com.labbol.core.platform.user.model.User;

/**
 * @author PengFei
 */
public class CurrentLoginUserInfo implements Serializable {

	private static final long serialVersionUID = -4109346450125322854L;

	private final Map<String, Object> attributes = new HashMap<String, Object>();

	@Nullable
	private User user;

	@Nullable
	private Org org;

	@Nullable
	private List<String> opRights;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public List<String> getOpRights() {
		return opRights == null ? Collections.emptyList() : opRights;
	}

	public void setOpRights(List<String> opRights) {
		this.opRights = opRights;
	}

	public Object getAttribute(String name) {
		return this.attributes.get(name);
	}

	@SuppressWarnings("unchecked")
	public <T> T getAttribute(String name, T defaultValue) {
		return (T) this.attributes.getOrDefault(name, defaultValue);
	}

	public void setAttribute(String name, Object value) {
		this.attributes.put(name, value);
	}

}
