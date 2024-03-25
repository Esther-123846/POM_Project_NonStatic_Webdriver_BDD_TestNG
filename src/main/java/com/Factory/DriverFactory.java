package com.Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver ddriver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public WebDriver init_driver(String browser)
	{
		switch(browser)
		{

		case "chrome" :
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			break;
		case "edge" :
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			break;
		default :
			System.out.print("Invalid browser name , Please choose among Chrome and Egde");
		}	
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		//getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
}
