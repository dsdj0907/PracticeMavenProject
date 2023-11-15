package com.practice.test.application;

import org.testng.annotations.Test;

import com.practice.core.common.appCommonActions;
import com.practice.test.common.BaseTestCase;

public class LoginTest extends BaseTestCase {

	appCommonActions appActions;

	@Override
	public void initPages() {
		appActions = new appCommonActions();
	}

	@Test
	public void testLogin() {
		appActions.loginToApplication();

	}
}
