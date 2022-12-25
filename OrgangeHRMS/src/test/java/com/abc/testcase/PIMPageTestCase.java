package com.abc.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abc.commonfunctionality.Browser;
import com.abc.pages.HomePage;
import com.abc.pages.LoginPage;
import com.abc.pages.PIMPage;
import com.abc.reports.Reporter;

public class PIMPageTestCase {
	
	@BeforeClass()
	public void generatereport() throws InterruptedException {
		Reporter reporter=new Reporter();
		reporter.generateReport();
		Browser browser=new Browser();
		browser.BrowesrLaunch();
	}
	
	@Test(description="Verify that user is able to add employee",groups= {"smoke","regression"},enabled=false)
	public void TC3() throws InterruptedException {
		Reporter reporter=new Reporter();
		reporter.CreateTestCase("Verify that user is able to add employee");
		PIMPage pimpage=new PIMPage("Admin", "admin123");
		pimpage.getAddBtn().click();
		Thread.sleep(4000);
		pimpage.AddEmployee("test1", "test1", "test2");
	}
	
	@Test(invocationCount=5)
	public void TC4() {
		System.out.println("this is sample test ");
	}

}
