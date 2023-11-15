package com.practice.core.common;

import com.practice.application.objectrepository.ApplicationObjectRepository;
import com.practice.core.functions.CommonUserActions;
import com.practice.core.functions.Log;
import com.practice.core.resourceUtils.ApplicationPropReader;
import com.practice.core.resourceUtils.ResourceReader;
import org.testng.Assert;

public class appCommonActions extends CommonUserActions implements ApplicationObjectRepository {

	public static String XPATH = "xpath";
	public static String NAME = "NAME";
	public static String ID = "id";

	protected String appurl = ResourceReader.getAppSettings(ApplicationPropReader.URLTOLAUNCH);
	protected String uname = ResourceReader.getAppSettings(ApplicationPropReader.APPUSER);
	protected String pwd = ResourceReader.getAppSettings(ApplicationPropReader.APPPWD);

	public void launchApp() {
		getUrl(appurl);
	}

	public void loginToApplication() {
		try {
			enterText(NAME, USERNAME_FILED, uname);
			enterText(NAME, PWD_FIELD, pwd);
			clickElement(XPATH, LOGIN_BTN);
			Log.info("Logged in to the application");
		} catch (Exception e) {
			Log.error("Failed to Login");
			Assert.fail();
		}
	}

}
