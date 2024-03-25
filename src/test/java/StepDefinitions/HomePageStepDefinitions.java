package StepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.Factory.DriverFactory;
import com.practiceautomate.qa.pages.FileUploadPage;
import com.practiceautomate.qa.pages.HomePage;
import com.practiceautomate.qa.pages.PopUpsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinitions 
{
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private FileUploadPage fileUploadPage;
	private PopUpsPage popUpsPage;
	private String pageTitle;

	@Given("User is on Home page")
	public void user_is_on_home_page() 
	{
	  DriverFactory.getDriver().get("https://practice-automation.com/");
	}
	
	@When("User clicks on Popups page link he lands on PopUps Page") //for actions
	public void user_clicks_on_popups_page_link_he_lands_on_pop_ups_Page() throws IOException, InterruptedException 
	{
		popUpsPage = homePage.clickOnPopUpsPageLink();
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_pop_ups_page() 
	{
		pageTitle =homePage.getPageTitle();
	}

	@Then("title of the page should be {string}")
	public void title_of_the_pop_ups_page_should_be(String expectedPageTitle) 
	{
		Assert.assertEquals(pageTitle,expectedPageTitle);
	}
	
	@When("User clicks on FileUpload page link he lands on FileUpload Page")
	public void user_clicks_on_file_upload_page_link_he_lands_on_file_upload_page() throws IOException, InterruptedException 
	{
		fileUploadPage = homePage.clickOnFileUploadLink();
	}
}
