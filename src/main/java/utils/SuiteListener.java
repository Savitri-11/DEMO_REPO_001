package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import base.BaseTest;

public class SuiteListener implements ITestListener, IAnnotationTransformer {

	public void onTestFailure(ITestResult result) {

		String filename = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ result.getMethod().getMethodName();

		File f1 = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(f1, new File(filename + ".png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	 public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		   
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		 
		  }

}

//import io.qameta.allure.Attachment;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import base.BaseTest;
//
//public class SuiteListener implements ITestListener {
//    private WebDriver driver;
//
//    @Attachment(value = "Screenshot on Failure", type = "image/png")
////    @Attachment(value = "Failed", type = "/Users/savitrigajakosh/Documents/Savitri_Eclipse_Workspace/Generic_Selenium_Framework/allure-results/TC_002.png/")
//    public byte[] saveScreenshot(WebDriver driver) {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        Object testClass = result.getInstance();
//        if (testClass instanceof BaseTest) {
//            this.driver = ((BaseTest) testClass).getDriver();
//            saveScreenshot(driver);
//        }
//        
//        
//    }
//}
