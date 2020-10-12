/**
 * 
 */
package com.labbol.core.model;

import org.yelong.commons.util.map.CaseInsensitiveMapUtils.KeyStoreMode;
import org.yelong.core.model.map.MapModel;

/**
 * @author PengFei
 */
public abstract class BaseMapModel extends MapModel implements BaseMapModelable {

	private static final long serialVersionUID = -4448830529149248472L;

	public BaseMapModel() {
		this(KeyStoreMode.LOWER);
	}

	public BaseMapModel(KeyStoreMode keyStoreMode) {
		super(keyStoreMode);
	}


}
