package com.practice.core.driver;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import static java.lang.Thread.currentThread;

import org.openqa.selenium.WebDriver;

public class WebDriverRunner {

	private static Map<Long, WebDriver> THREAD_WEB_DRIVER = new ConcurrentHashMap<Long, WebDriver>(4);
	private static Collection<Thread> ALL_WEB_DRIVERS_THREADS = new ConcurrentLinkedQueue<Thread>();

	
	public static WebDriver getWebDriver(String browser) {
		WebDriver driver = gettingWebDriver(browser);
		return driver;
	}
	
	
	public static WebDriver settingWebDriver(WebDriver driver) {
		THREAD_WEB_DRIVER.put(currentThread().getId(), driver);
		return driver;
	}
	
	public static void closeWebDriver() {
		
	}
	
	public static WebDriver gettingWebDriver(String browser) {
		WebDriver webDriver = THREAD_WEB_DRIVER.get(currentThread().getId());
		webDriver = (webDriver!=null)? webDriver: settingWebDriver(webDriverFactory.getWebDriverByType(browser));
		return webDriver;
	}

}
