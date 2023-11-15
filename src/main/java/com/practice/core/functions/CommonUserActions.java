package com.practice.core.functions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.core.driver.BaseDriver;
import com.practice.core.driver.WebDriverRunner;
import com.practice.core.resourceUtils.ApplicationPropReader;
import com.practice.core.resourceUtils.ResourceReader;

public class CommonUserActions {

	protected BaseDriver driver;
	WebDriverWait wait;
	final SimpleDateFormat GLOBAL_DATE_FORMAT = new SimpleDateFormat("dd-MM-YYYY");
	List<File> screenshots = new ArrayList<File>();

	public CommonUserActions() {
		String browser = ResourceReader.getAppSettings(ApplicationPropReader.BROWSER);
		driver = (BaseDriver) WebDriverRunner.gettingWebDriver(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void implicitlyWaitFor() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void pageLoadTimeOut(Integer time) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
	}

	public WebElement findElement(String locatorType, String locatorValue) {
		locatorType = locatorType.toUpperCase();
		WebElement element = null;
		switch (locatorType) {
		case "XPATH":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "ID":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "CLASS":
			element = driver.findElement(By.className(locatorValue));
			break;
		case "NAME":
			element = driver.findElement(By.name(locatorValue));
			break;
		default:
			break;
		}
		return element;

	}

	public void enterText(String locatorType, String locatorValue, String text) {
		WebElement element = findElement(locatorType, locatorValue);
		element.clear();
		element.sendKeys(text);
	}
	
	public void clickElement(String locatorType, String locatorValue) {
		WebElement element = findElement(locatorType, locatorValue);
		element.click();
	}

	public void captureScreenShot(WebDriver driver, String fileName) throws IOException {
		File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		GregorianCalendar gCalender = new GregorianCalendar();

		String failureImageFileName = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator
				+ GLOBAL_DATE_FORMAT.format(new java.util.Date()) + File.separator
				+ formatInteger(gCalender.get(Calendar.HOUR)) + "_" + formatInteger(gCalender.get(Calendar.MINUTE))
				+ "_" + gCalender.getTimeInMillis() + "_" + fileName + ".png";

		File failreImageFile = new File(failureImageFileName);
		FileUtils.moveFile(imageFile, failreImageFile);
		screenshots.add(failreImageFile);
		Log.error("Something Went Wrong. Check Screenshot");
	}

	public String formatInteger(int input) {
		return String.format("%02d", input);
	}
}
