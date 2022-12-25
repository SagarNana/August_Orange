package com.abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.abc.commonfunctionality.Browser;

public class PIMPage extends HomePage{

	private WebElement firstNameTxt;
	private WebElement middletNameTxt;
	private WebElement lastNameTxt;
	private WebElement saveBtn;
	private WebElement addBtn;
	
	public PIMPage(String username,String password) {
		super(username,password);
		getPIMLink().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebElement getFirstNameTxt() {
		firstNameTxt=Browser.driver.findElement(By.xpath("//input[@name='firstName']"));
		return firstNameTxt;
	}
	public WebElement getMiddletNameTxt() {
		middletNameTxt=Browser.driver.findElement(By.xpath("//input[@name='middleName']"));
		return middletNameTxt;
	}
	public WebElement getLastNameTxt() {
		lastNameTxt=Browser.driver.findElement(By.xpath("//input[@name='lastName']"));
		return lastNameTxt;
	}
	public WebElement getSaveBtn() {
		saveBtn=Browser.driver.findElement(By.xpath("//button[@type='submit']"));
		return saveBtn;
	}
	
	public WebElement getAddBtn() {
		addBtn=Browser.driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
		return addBtn;
	}
	
	
	public void AddEmployee(String firstname,
			String middleName,String lastname) {
		
		getFirstNameTxt().sendKeys(firstname);
		getMiddletNameTxt().sendKeys(middleName);
		getLastNameTxt().sendKeys(lastname);
		getSaveBtn().click();
		
	}
}
