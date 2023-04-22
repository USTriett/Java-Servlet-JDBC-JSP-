package com.Help;

import java.nio.charset.StandardCharsets;

public class Helper {
	public static String getUTF8String(String raw)
	{
		byte[] bytes = raw.getBytes(StandardCharsets.UTF_8);
		String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
		return utf8EncodedString;
	}
	
}
