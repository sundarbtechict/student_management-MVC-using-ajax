package com.sundar.studentmanagement.student.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class CommonUtil {
	private static final Logger LOGGER = Logger.getLogger(CommonUtil.class);

	public static Boolean isForwardedRequest(HttpServletRequest request) {
		String originalRequestURI = (String) request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
		return originalRequestURI != null ? true : false;
	} 
}
