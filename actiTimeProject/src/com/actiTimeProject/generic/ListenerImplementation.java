package com.actiTimeProject.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation extends Baseclass implements ITestListener {


	@Override
	public void onTestStart(ITestResult arg0) {
		
	}

	@Override
	public void onTestSuccess(ITestResult arg) {
        String result=arg.getName();
        TakesScreenshot t=(TakesScreenshot)driver;
		File source=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/"+result+".png");
		try {
			
			FileUtils.copyFile(source,dest);
		}
		catch(IOException e) {
			
		}
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult arg0) {
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		
	}

}
