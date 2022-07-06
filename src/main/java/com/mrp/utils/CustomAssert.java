package com.mrp.utils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mrp.drivers.DriverManager;
import com.mrp.listeners.TestUtil;
import com.mrp.report.ReportManagerRunner;

public class CustomAssert {
	public static void assertEquals(String actual,String expected,String logMessage,String logErrMessage){
	       if(actual.equals(expected))
	           ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	      
	       else
	           fail(logErrMessage,actual,expected);
	    }

	    public static void assertEquals(int actual,int expected,String logMessage,String logErrMessage){
	        if(actual==expected)
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	            fail(logErrMessage,String.valueOf(actual),String.valueOf(expected));
	    }

	    public static void assertEquals(double actual,double expected,String logMessage,String logErrMessage){
	        if(actual==expected)
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	            fail(logErrMessage,String.valueOf(actual),String.valueOf(expected));
	    }

	    public static void assertEquals(float actual,float expected,String logMessage,String logErrMessage){
	        if(actual==expected)
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	            fail(logErrMessage,String.valueOf(actual),String.valueOf(expected));
	    }

	    public static void assertEquals(char actual,char expected,String logMessage,String logErrMessage){
	        if(actual==expected)
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	            fail(logErrMessage,String.valueOf(actual),String.valueOf(expected));
	    }

	    public static void assertTrue(boolean condition,String logMessage,String logErrMessage){
	        if(condition)
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	            fail(logErrMessage);
	    }

	    public static void assertFalse(boolean condition,String logMessage,String logErrMessage){
	        if(!condition)
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	            fail(logErrMessage);
	    }

	    public static void assertEqualsIgnoreCase(String actual,String expected,String logMessage,String logErrMessage){
	        if(actual.equalsIgnoreCase(expected))
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	            fail(logErrMessage,actual,expected);
	    }

	    public static void assertContains(String actual,String expected,String logMessage,String logErrMessage){
	        if(actual.contains(expected)||expected.contains(actual))
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	            fail(logErrMessage,actual,expected);
	    }

	    public static void assertEquals(Object actual,Object expected,String logMessage,String logErrMessage){
	        if(actual.equals(expected))
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	            fail(logErrMessage,actual.toString(),expected.toString());
	    }
	    
	    public static void assertEqualsNS(int actual,int expected,String logMessage,String logErrMessage){
	        if(actual==expected)
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	        	ReportManagerRunner.getTest().log(Status.FAIL,logErrMessage);
	    }
	    
	    public static void assertNotEqualsNS(int actual,int expected,String logMessage,String logErrMessage){
	        if(actual!=expected)
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	        	ReportManagerRunner.getTest().log(Status.FAIL,logErrMessage);
	    }
	    public static void assertNotEquals(int actual,int expected,String logErrMessage){
	        if(actual!=expected)
	            ReportManagerRunner.getTest().log(Status.FAIL,logErrMessage);
	        
	    }
	    public static void assertTrue(String logMessage) {
	    	ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	    }
	    
	    public static void assertFail(String logMessage) {
	    	ReportManagerRunner.getTest().log(Status.FAIL,logMessage);
	    	Assert.fail(logMessage);
	    }
	    
		    
	    public static void assertFalse(String logMessage,Throwable throwable) {
	    	fail(logMessage);
	    	ReportManagerRunner.getTest().log(Status.FAIL,throwable);
	    }
	    
	    public static void assertFalse(String logMessage) {
	    	ReportManagerRunner.getTest().log(Status.FAIL,logMessage);
	    }
	    
	    public static void assertCSSFalseNS(String header,List<String> logMessage) {
	    	String message="";
	    	for(String e:logMessage){
	    		message+="<br>"+e;
	    	};
	    	ReportManagerRunner.getTest().log(Status.FAIL,"<B>"+header+"</B>"+message );
	    }
	    
	    public static void assertCSSTrue(String header,List<String> logMessage) {
	    	String message="";
	    	for(String e:logMessage){
	    		message+="<br>"+e;
	    	};
	    	ReportManagerRunner.getTest().log(Status.PASS,"<B>"+header+"</B>"+message );
	    }
	    
	    public static void assertCSSTrue(String header,String logMessage) {
	    	String message="";
	    		message+="<br>"+logMessage;
	    	ReportManagerRunner.getTest().log(Status.PASS,"<B>"+header+"</B>"+message );
	    }
	    
	    public static void assertTrueNS(boolean condition,String logMessage,String logErrMessage){
	        if(condition)
	            ReportManagerRunner.getTest().log(Status.PASS,logMessage);
	        else
	        	ReportManagerRunner.getTest().log(Status.FAIL,logErrMessage);
	    }
	    
	    public static void assertCSSFalse(String header,List<String> logMessage) {
	    	String message="";
	    	for(String e:logMessage){
	    		String[] ms = e.split("path");
	    		String imagePath= "."+ms[1].trim();
	    		String imageConstruct = "<img data-featherlight="+imagePath+" width=\"10%\" src="+imagePath+" data-src="+imagePath+">";
	    		message+="<br>"+ms[0].trim()+"<br>"+imageConstruct;
	    	};
	    	ReportManagerRunner.getTest().log(Status.FAIL,"<B>"+header+"</B>"+message );
	    }
	    
	    private static void fail(String logErrMessage){
	        SessionId sessionId;
	        try {
	            sessionId = ((RemoteWebDriver) DriverManager.getDriver()).getSessionId();
	        }catch (NullPointerException e){
	            sessionId=null;
	        }
	        if(sessionId!=null) {
	        try {
	            TestUtil.captureScreenShot();
	            ReportManagerRunner.getTest().log(Status.FAIL, logErrMessage, MediaEntityBuilder. createScreenCaptureFromPath("."+ TestUtil.ScreenshotPath.replace("/GeneratedReport","") + TestUtil.screenShotName).build());
	            
	        } catch (IOException e) {
	            ReportManagerRunner.getTest().log(Status.FAIL, logErrMessage );
	        }
	        }else {
	            ReportManagerRunner.getTest().log(Status.FAIL, logErrMessage );
	        }
	    }

	    private static void fail(String logErrMessage,String actual, String expected) {
	        SessionId sessionId;
	        try {
	            sessionId = ((RemoteWebDriver) DriverManager.getDriver()).getSessionId();
	        }catch (NullPointerException e){
	            sessionId=null;
	        }
	        if(sessionId!=null) {
	        try {
	            TestUtil.captureScreenShot();
	            ReportManagerRunner.getTest().log(Status.FAIL, logErrMessage + " | " + "Actual: " + actual + " Expected: " + expected, MediaEntityBuilder.createScreenCaptureFromPath("." + TestUtil.ScreenshotPath.replace("/GeneratedReport", "") + TestUtil.screenShotName).build());
	        } catch (IOException | NullPointerException e) {
	            ReportManagerRunner.getTest().log(Status.FAIL, logErrMessage + " | " + "Actual: " + actual + " Expected: " + expected);
	        }
	        }else {
	            ReportManagerRunner.getTest().log(Status.FAIL, logErrMessage + " | " + "Actual: " + actual + " Expected: " + expected);
	        }
	    }
	
}
