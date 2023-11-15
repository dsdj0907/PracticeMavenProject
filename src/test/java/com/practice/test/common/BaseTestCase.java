package com.practice.test.common;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.practice.core.common.appCommonActions;
import com.practice.core.driver.WebDriverRunner;
import com.practice.core.functions.CommonUserActions;
import com.practice.core.functions.Log;

public abstract class BaseTestCase extends appCommonActions {

	protected WebDriver driver;
	CommonUserActions commonActions = new CommonUserActions();

	public abstract void initPages();

	@BeforeSuite(alwaysRun = true)
	public void launchApplication() {
		driver = WebDriverRunner.getWebDriver("chrome");
		maximizeWindow();
		Log.info("Browser is opened");
		launchApp();
	}

	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws InterruptedException {
		initPages();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void startTest(Method method) {
		Log.startTestCase(this.getClass().getSimpleName()+"_"+method.getName());
	}

	//@AfterMethod(alwaysRun = true)
	public void failureCatcher(ITestResult testResult) throws IOException {
		Log.endTestCase(this.getClass().getSimpleName() + " " + testResult.getName());
		if (!testResult.isSuccess()) {
			Log.error("Test Failed.." + this.getClass().getSimpleName() + "_" + testResult.getName());
			Log.info("**********************************");
			Log.error("********************  Message  ****************\n" + testResult.getThrowable().getMessage()
					+ "\n");
			captureScreenShot(driver, this.getClass().getSimpleName() + "_" + testResult.getName());
		}
	}

	@AfterSuite(alwaysRun = true)
	public void closeTest() {
		WebDriverRunner.closeWebDriver();
	}

}
