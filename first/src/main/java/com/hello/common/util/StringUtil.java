package com.hello.common.util;

public abstract class StringUtil {
	
	private StringUtil() {};
	
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}
	public static boolean isExceedLength(String str, int maxlength) {
		if(!isEmpty(str)) {
			return str.trim().length() > maxlength;
		}
		return false;
	}
	public static boolean isNull(String str) {
		return str == null;
	}
	public static boolean isMatch(String str, String other) {
		return str.equals(other);
	}
}
