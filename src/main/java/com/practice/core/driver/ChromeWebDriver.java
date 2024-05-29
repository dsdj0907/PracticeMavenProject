package com.practice.core.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		
		final List<String> optionList = new ArrayList<>();
		
		optionList.add("--no-sandbox");
		optionList.add("--disable-dev-shm-usage");
		optionList.add("--disable-gpu");
		optionList.add("--ignore-ssl-errors=yes");
		optionList.add("--ignore-certificate-errors");
		optionList.add("--remote-debugging-port=9222");
		optionList.add("--start-maximized");
		optionList.add("--allow-running-insecure-content");
		optionList.add("--allow-insecure-localhost");
		
		options.addArguments(optionList);
		
		driver.set(new ChromeDriver(options));
		
	}

}
