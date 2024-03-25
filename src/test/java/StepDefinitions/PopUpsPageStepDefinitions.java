package StepDefinitions;

import org.testng.Assert;

import com.Factory.DriverFactory;
import com.practiceautomate.qa.pages.PopUpsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import com.practiceautomate.qa.pages.HomePage;
import com.practiceautomate.qa.pages.PopUpsPage;
import com.practiceautomate.qa.util.ElementUtil;

public class PopUpsPageStepDefinitions 
{
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private PopUpsPage popUpsPage ;
	
	@Given("User is on Popups page")
	public void user_is_on_popups_page() throws IOException, InterruptedException 
	{
		DriverFactory.getDriver().get("https://practice-automation.com/");
		popUpsPage = homePage.clickOnPopUpsPageLink();
	}

	@When("User clicks on Alert Popup button")
	public void user_clicks_on_alert_popup_button() 
	{
		popUpsPage.clickOnAlertPopUp();
	}

	@Then("Alert popup message should be {string}")
	public void alert_popup_message_should_be(String expectedAlertMessage) 
	{
		Assert.assertEquals(popUpsPage.getAlertMessage(),expectedAlertMessage);
	}



}