package com.compass.utils;

import java.util.Base64;

public final class DecodeUtils {
	
	private DecodeUtils() {}
	
	public static String getDecodedString (String encoded) {
		return new String(Base64.getDecoder().decode(encoded.getBytes()));
	}

}
