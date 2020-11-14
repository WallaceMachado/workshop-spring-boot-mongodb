package com.wallacemachado.workshopmongo.resources.util;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	
	//decodificar a busca feita pelo usuario de forma que programa entenda
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}