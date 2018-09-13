package com.example.demo.commonutils;

public class StringUtilsTool {

	private StringUtilsTool() {
	}

	/**
	 * 只能是字符串或者可以和字符串转换的对象
	 */
	public static boolean isNotNull(Object value){
		return (value != null && !"".equals(value.toString()) && !"{}".equals(value.toString()) && !"[]".equals(value.toString()));
	}
}
