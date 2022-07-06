package com.mrp.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	private int retryCnt = 0;
	private int maxRetryCnt = Integer.parseInt("");

	@Override
	public boolean retry(ITestResult result) {
		if (retryCnt < maxRetryCnt) {
			retryCnt++;
			return true;
		}
		return false;
	}
}
