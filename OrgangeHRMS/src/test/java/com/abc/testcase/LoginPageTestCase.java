package com.abc.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abc.commonfunctionality.Browser;
import com.abc.pages.HomePage;
import com.abc.pages.LoginPage;
import com.abc.reports.Reporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPageTestCase {
	
	@BeforeClass(alwaysRun=true)
	public void generatereport() throws InterruptedException {
		Reporter reporter=new Reporter();
		reporter.generateReport();
		Browser browser=new Browser();
		browser.BrowesrLaunch();
	}
	
	
	@Test(description="Verify user is able to login with valid credentail",priority=1,groups= {"smoke","regression"})
	public void TC1() throws InterruptedException {
		ExtentTest extenttest=Reporter.report.createTest("Verify user is able to login with valid credentail");
	 //	LoginPage loginpage=new LoginPage("Admin","admin123");
		//loginpage.LoginFunctinality("Admin", "admin123");
		//Thread.sleep(2000);
		
		//getcurrenturl
		HomePage homepage=new HomePage("Admin","admin123");//we are passing data as hard -code
		//getAdmin
		if(homepage.getAdminLink().isDisplayed()) {
			extenttest.log(Status.PASS, "user is able to login");
		} else {
			extenttest.log(Status.FAIL, "user is unable to login");
		}
		
	}
	
	@Test(description="Verify user is unable to login with invalid credential",priority=0,groups= {"regression"})
	public void TC2() throws InterruptedException {
		Reporter reporter=new Reporter();
		reporter.CreateTestCase("Verify user is unable to login with invalid credential");
		//Reporter.report.createTest("Verify user is unable to login with invalid credential");
		LoginPage loginpage=new LoginPage("Aadmin","admin123");
		//loginpage.LoginFunctinality("Aadmin", "admin123");
		Thread.sleep(5000);
		if(loginpage.getLoginbtn().isDisplayed()) {
			reporter.Pass("User is unable to login with invalid credential");
		} else {
			reporter.Fail("User is unable to login with invalid credential");
		}
		
		//validation 
	}


	@AfterClass
	public void PostCondition() {
		Reporter.report.flush();
	}
}
