package com.security;

import com.SpringApplicationContext;

public class SecurityConstant {

	public static final Long EXPIRATION_TIME = 864000000L;
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String HEADER_STRING = "Authorization";

	public static final String SIGNUP_URL = "/user";

	public static String getTockenSecret() {
		AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
		return appProperties.getTokenSecret();
	}
}
