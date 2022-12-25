package com.abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends LoginPage {
	
	private WebElement adminLink;
	private WebElement PIMLink;
	private WebElement LeaveLink;
	private WebElement TimeLink;
	
	public HomePage(String username,String password) {
		super(username,password);
	}
	
	public WebElement getAdminLink() {
		adminLink=driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
		return adminLink;
	}
	public WebElement getPIMLink() {
		PIMLink=driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
		return PIMLink;
	}
	public WebElement getLeaveLink() {
		return LeaveLink;
	}
	public WebElement getTimeLink() {
		return TimeLink;
	}
	
	

}
