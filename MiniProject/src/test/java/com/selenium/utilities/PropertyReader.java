package com.selenium.utilities;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public static String getProperties(String s) throws IOException {
		FileReader reader = new FileReader("files/info.properties/");
		Properties p = new Properties();
		p.load(reader);
		return (p.getProperty(s));		
	}
}
