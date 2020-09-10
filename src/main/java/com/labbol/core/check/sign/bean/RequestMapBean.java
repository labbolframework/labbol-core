package com.labbol.core.check.sign.bean;

import java.util.Map;
/**
 * @ClassName: RequestMapBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Dwayne
 * @date 2020年3月20日
 *
 */
public class RequestMapBean {
	
	@Deprecated
	private Map<String, String> headerMap;
	
	private Map<String, String> parameterMap;
	
	private String body;
	
	private String sign;

	public Map<String, String> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, String> parameterMap) {
		this.parameterMap = parameterMap;
	}

	public Map<String, String> getHeaderMap() {
		return headerMap;
	}

	public void setHeaderMap(Map<String, String> headerMap) {
		this.headerMap = headerMap;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
