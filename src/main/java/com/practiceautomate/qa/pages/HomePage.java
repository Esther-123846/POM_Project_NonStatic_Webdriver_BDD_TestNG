package com.practiceautomate.qa.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage 
{

	private By popUpsPageLink= By.linkText("Popups");
	private By fileUploadPageLink = By.xpath("//a[text()='File Upload']");
	private WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
    
	public PopUpsPage clickOnPopUpsPageLink() throws IOException, InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try {
		js.executeScript("arguments[0].click()",driver.findElement(popUpsPageLink));
		}
		catch(StaleElementReferenceException | NoSuchElementException e)
		{
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			WebElement popupsLink = driver.findElement(By.linkText("Popups"));
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(popupsLink));
			popupsLink.click();
		}
		return new PopUpsPage(driver);
	}
	
	public FileUploadPage clickOnFileUploadLink() throws IOException, InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try {
		js.executeScript("arguments[0].click()",driver.findElement(fileUploadPageLink));
		}
		catch(StaleElementReferenceException | NoSuchElementException n)
		{
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			WebElement fileUploadPageLinkcopy = driver.findElement(By.xpath("//a[text()='File Upload']"));
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(fileUploadPageLinkcopy));
			fileUploadPageLinkcopy.click();

//			js.executeScript("arguments[0].click()",fileUploadPageLinkcopy);

		}
		//fileUploadPageLink.click();
		return new FileUploadPage(driver);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
}
