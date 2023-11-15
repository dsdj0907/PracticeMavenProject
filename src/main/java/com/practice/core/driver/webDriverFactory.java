package com.practice.core.driver;

import org.openqa.selenium.WebDriver;

public class webDriverFactory {

	public static WebDriver getWebDriverByType(String type) {
		final WebDriver driver;
		driver = new ChromeWebDriver();
		return driver;
	}

}
