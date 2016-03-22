package com.newgen.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class ManagerPro {
	static Properties properties = new Properties();

	static {
		
		InputStream inputStream = ManagerPro.class.getClassLoader().getResourceAsStream("system-config.properties");
		try {
			properties.load(new InputStreamReader(inputStream,"UTF-8"));
						
			
					} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getString(String str)
	{
		String property = properties.getProperty(str);
		return property;
	}
	
}
