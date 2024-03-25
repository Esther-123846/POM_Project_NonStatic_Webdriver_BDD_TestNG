package com.practiceautomate.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FileUploadPage
{
 
	private WebDriver driver;
	private By browseButton= By.id("file-upload");
	private By browseButtonErrormsg = By.xpath("//input[@id='file-upload']/following::span[1]");
	
	public FileUploadPage() {}
	
	public FileUploadPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public String  clickOnBrowserButton(String filePath)
	{
		driver.findElement(browseButton).sendKeys(filePath);
		return driver.findElement(browseButtonErrormsg).getText();
	}
	
	public String fileUploadUsingRobot(String filePath) throws InterruptedException, AWTException
	{
		Actions act= new Actions(driver);
		act.click(driver.findElement(browseButton)).perform();
		Thread.sleep(2000);		
		//js.executeScript("document.getElementById('file-upload').click()");
		Robot rb = new Robot();
		rb.delay(2000);
		
		//Copy file path to clipboard
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//paste path to file name 
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(2000);
		return driver.findElement(browseButtonErrormsg).getText();
	}
}
