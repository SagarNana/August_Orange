package com.abc.commonfunctionality;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;

public class Browser {

	public static Properties prop;
	public static WebDriver driver;

	@BeforeSuite(alwaysRun=true)
	public void BrowesrLaunch() throws InterruptedException {

		readPropertyFile();
		// step 1 -> Register the driver
		if (prop.getProperty("browsername").equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
			// Step 2- Create object of the class
			 driver = new ChromeDriver(); // browser will get
			// step 3 -
		} else if (prop.getProperty("browsername").equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", ".\\src\\main\\resources\\msedgedriver.exe");
			 driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("application.url"));
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	public void readPropertyFile() {

		prop = new Properties();
		try {
			prop.load(new FileInputStream(".\\src\\main\\resources\\application.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
