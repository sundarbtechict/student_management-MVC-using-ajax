package com.sundar.studentmanagement.student.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

	public static Boolean isForwardedRequest(HttpServletRequest request) {
		String originalRequestURI = (String) request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
		return originalRequestURI != null ? true : false;
	} 
}
