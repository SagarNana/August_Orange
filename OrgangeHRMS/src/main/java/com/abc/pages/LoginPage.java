package com.abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.abc.commonfunctionality.Browser;

public class LoginPage extends Browser {

	private WebElement usernameTxt;
	private WebElement passwordTxt;
	private WebElement Loginbtn;
	
	public LoginPage(String username,String password) {
		LoginFunctinality(username, password);
	}

	public WebElement getUsernameTxt() {
		usernameTxt = driver.findElement(By.xpath("//form[@class='oxd-form']"
				+ "//div[@class='oxd-form-row']//input[@name='username']"));
		return usernameTxt;
	}

	public WebElement getPasswordTxt() {
		passwordTxt = driver.findElement(By.xpath("//form[@class='oxd-form']//"
			+ "div[@class='oxd-form-row']//input[@name='password']"));
		
		return passwordTxt;
	}

	public WebElement getLoginbtn() {
		Loginbtn = driver.findElement(By.xpath("//form[@class='oxd-form']//"
				+ "div[@class='oxd-form-actions orangehrm-login-action']//button"));
		return Loginbtn;
	}
	
	//Login in application 
	
	public void LoginFunctinality(String username,String password)  {
		getUsernameTxt().sendKeys(username);
		getPasswordTxt().sendKeys(password);
		getLoginbtn().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
