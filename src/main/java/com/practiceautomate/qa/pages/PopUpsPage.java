package com.practiceautomate.qa.pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.practiceautomate.qa.util.ElementUtil;

public class PopUpsPage 
{
	ElementUtil utilClass;
	private WebDriver driver;
	private String alertMessage;
	private By popUpsPageLink = By.linkText("Popups");
	private By alertPopUpButton = By.id("alert");
	private By confirmPopUpButton = By.id("confirm");
	private By confirmResultButton = By.id("confirmResult");
	private By promptPopUpButton =By.id("prompt");	
	private By promptResultButton =By.id("promptResult");
	private By tooltip_1Button = By.className("tooltip_1");
	
	public PopUpsPage() {}
	
	public PopUpsPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void clickOnPopUpsPage()
	{
		driver.findElement(popUpsPageLink).click();
		//return new PopUpsPage();
	}
	
	
	public void clickOnAlertPopUp()
	{
		driver.findElement(alertPopUpButton).click();
		Alert alert = driver.switchTo().alert();
		alertMessage = alert.getText();
		alert.accept();	
	}
	
	public String getAlertMessage()
	{
		return alertMessage;
	}
	
	public String getText(WebElement elementText)
	{
		return elementText.getText();
	}
}
