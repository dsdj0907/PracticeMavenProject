package com.practice.core.resourceUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ResourceReader {

	static Locale locale = Locale.ROOT;

	private static ResourceBundle appSettings = ResourceBundle.getBundle("projectApplication", locale);

	private static ResourceBundle getResourceBundle(final String aName) {
		try (FileInputStream fis = new FileInputStream(aName)) {
			return new PropertyResourceBundle(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getAppSettings(String key) {
		return appSettings.getString(key);
	}

}
