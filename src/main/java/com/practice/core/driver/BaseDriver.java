package com.practice.core.driver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseDriver implements WebDriver {

	static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public abstract void initDriver();

	public BaseDriver() {
		initDriver();
	}

	@Override
	public void get(String url) {
		getWebDriver().get(url);

	}

	@Override
	public String getCurrentUrl() {
		return getWebDriver().getCurrentUrl();
	}

	@Override
	public String getTitle() {
		return getWebDriver().getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return getWebDriver().findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return getWebDriver().findElement(by);
	}

	@Override
	public String getPageSource() {
		return getWebDriver().getPageSource();
	}

	@Override
	public void close() {
		getWebDriver().close();

	}

	@Override
	public void quit() {
		getWebDriver().quit();

	}

	@Override
	public Set<String> getWindowHandles() {
		return getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return getWebDriver().getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return getWebDriver().switchTo();
	}

	@Override
	public Navigation navigate() {
		return getWebDriver().navigate();
	}

	@Override
	public Options manage() {
		return getWebDriver().manage();
	}

	public static WebDriver getWebDriver() {
		return driver.get();
	}

}
