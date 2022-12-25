package com.abc.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter {
	
	public static ExtentReports report;
	public ExtentTest extentTest;
	//extent report 
	//screen shot 

	
	public void generateReport() {
	//Test - user should be able to login with valid credential 
		
		report=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("./Result/result.html");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Swag Lab Automation");
		spark.config().setReportName("HSBC Bank");
		
		report.attachReporter(spark);
		
	}
	
	public void CreateTestCase(String TestCaseName) {
		extentTest=report.createTest(TestCaseName);
	}
	
	public void  Pass(String TestStep) {
		extentTest.log(Status.PASS, TestStep);
	}
	public void  Fail(String TestStep) {
		extentTest.log(Status.FAIL, TestStep);
	}
	
	
}
