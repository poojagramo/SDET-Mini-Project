package com.selenium.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
public class Listeners extends TakeScreenshot implements ITestListener {
 
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
 
    }
 
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
 
    }
 
    public void onTestFailure(ITestResult result) {
    	System.out.println("Test Case Failed - Capturing Screenshot");
    	try {
			screenshot();
			} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
 
    }
 

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
 
    }
 

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
 
    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
 
    }
}