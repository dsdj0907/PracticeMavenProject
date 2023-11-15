package com.practice.core.driver;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class ChromeWebDriver extends BaseDriver{

	@Override
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//resources//drivers//chromedriver");
		final ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		HashMap<String,Object> chromePrefs = new HashMap<>();
		chromePrefs.put("download.default_directory",  System.getProperty("user.dir")+ File.separator+"libs"+File.separator+"Downloads");
		options.setExperimentalOption("prefs", chromePrefs);
		
		driver.set(new ChromeDriver(options));
		
	}

}
