package com.practice.core.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	private static Logger Log = LogManager.getLogger(Log.class.getSimpleName());

	public static void startTestCase(String TestCaseMessage) {
		System.out.println();
		Log.info("********************" + "S_T_A_R_T" + "*************************");
		Log.info("********************" + TestCaseMessage + "*************************");
	}
	
	public static void endTestCase(String TestCaseMessage) {
		System.out.println();
		Log.info("********************" + "E_N_D" + "*************************");
		Log.info("********************" + TestCaseMessage + "*************************");
	}
	
	public static void info(String infoMessage) {
		System.out.println(infoMessage);
		Log.info(infoMessage);
	}

	public static void warn(String warnMessage) {
		Log.warn(warnMessage);
	}
	
	public static void error(String errorMessage) {
		Log.error(errorMessage);
	}
	
	//fatal
	//debug
}
