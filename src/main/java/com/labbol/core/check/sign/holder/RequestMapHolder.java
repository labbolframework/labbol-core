package com.labbol.core.check.sign.holder;

import com.labbol.core.check.sign.bean.RequestMapBean;

/**
 * @ClassName: RequestMapHolder
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Dwayne
 * @date 2020年3月20日
 *
 */
public class RequestMapHolder {

	private static final ThreadLocal<RequestMapBean> REQUEST_MAP_BEAN_HOLDER = new ThreadLocal<>();
	
	public static void setRequestMapBean(RequestMapBean bean) {
		REQUEST_MAP_BEAN_HOLDER.set(bean);
	}

	public static RequestMapBean getRequestMapBean() {
		return REQUEST_MAP_BEAN_HOLDER.get();
	}
}
