package com.utils;

public class TextUtils {
	public static boolean isEmpty(String... str){
		for (String string : str) {
			if (string==null||string.isEmpty()) {
				return true;
			}else{
				continue;
			}
		}
		return false;
		
	}

}
