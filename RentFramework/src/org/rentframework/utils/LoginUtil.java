/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the MIT License (MIT);
 * 
 */
package org.rentframework.utils;


public class LoginUtil {

	
	public static boolean isLoggedIn() {
		Object value = SessionCache.getInstance().get(BusinessConstants.LOGGED_IN);
		Boolean flag = false;
		if (value != null)
			flag = true;
		System.out.println("LoggedIn: " + flag);
		return flag;
	}
	public static boolean isAdmin() {
		Object value = SessionCache.getInstance().get(BusinessConstants.ADMIN);
		Boolean flag = false;
		if (value != null)
			flag = true;
		System.out.println("IsADMIN: " + flag);
		return flag;
	}

	public static boolean isStaff() {
		Object value = SessionCache.getInstance().get(BusinessConstants.STAFF);
		Boolean flag = false;
		if (value != null)
			flag = true;
		System.out.println("IsStaff: " + flag);
		return flag;
	}

	public static String getLoggedInUsername() {
		Object value = SessionCache.getInstance().get(BusinessConstants.STAFF);
		if (value != null)
			return value.toString();
		return null;
	}

}
