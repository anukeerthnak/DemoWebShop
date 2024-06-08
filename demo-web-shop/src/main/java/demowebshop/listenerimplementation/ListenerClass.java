package demowebshop.listenerimplementation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import demowebshop.baseclass.BaseClass;
import demowebshop.fileutility.JavaUtility;

/**
 * @author ANU
 */
public class ListenerClass implements ISuiteListener,ITestListener{
	
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	JavaUtility ju=new JavaUtility();
	@Override
	public void onStart(ISuite suite) {
		
		spark=new ExtentSparkReporter("./AdvancedReports/"+suite.getName()+ju.getSystemDate()+".html");
		report = new ExtentReports();
		report.attachReporter(spark);
		Reporter.log(suite.getName()+" has started Execution",true);
	}
	
	@Override
	public void onTestStart(ITestResult result) {

		
		test= report.createTest(result.getName());
		test.log(Status.INFO,result.getName()+" has started Execution");
		
		Reporter.log(result.getName()+" Test Script has started Execution",true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP,result.getName()+" Test Script has been skipped");
		Reporter.log(result.getName()+" Test Script has been skipped",true);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,result.getName()+" Test Script has been executed successfully");
		Reporter.log(result.getName()+" Test Script has been executed successfully",true);
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		Reporter.log(result.getName()+" Test Script has failed and screenshot has been taken ",true);
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String screenshotPath="./FailedScreenshot/"+result.getName()+ju.getSystemDate()+".png";
		File path= new File(screenshotPath);
		File img=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(img,path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath("."+screenshotPath);
		test.log(Status.FAIL,result.getName()+" Test Script has failed and screenshot has been taken");
		
	}
	
	@Override
		public void onFinish(ISuite suite) {
		
		test.log(Status.PASS,suite.getName()+" has been executed successfully");
		Reporter.log(suite.getName()+"  has been executed successfully",true);
		report.flush();
			
			
		}
	
	
	

}
