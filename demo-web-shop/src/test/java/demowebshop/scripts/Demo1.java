package demowebshop.scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Demo1 {
	
	@Test
	public void TestExtentReports()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReports/Demo.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test= report.createTest("Test Report");
		test.log(Status.INFO,"DemoReports");
		test.log(Status.INFO,"DemoReports");
		test.log(Status.INFO,"DemoReports");
		report.flush();
		
	}

}
