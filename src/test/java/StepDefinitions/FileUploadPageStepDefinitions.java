package StepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;

import com.Factory.DriverFactory;
import com.practiceautomate.qa.pages.FileUploadPage;
import com.practiceautomate.qa.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileUploadPageStepDefinitions 
{
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private FileUploadPage fileUploadPage ;
	private String filePath ="C:\\Users\\estya\\Desktop\\InterviewPrep\\Selenium_Interview_Preparation\\Selenium.txt";
	private String actualFileName;
	
	@Given("User is on FileUpload page")
	public void user_is_on_FileUpload_page() throws IOException, InterruptedException 
	{
	  DriverFactory.getDriver().get("https://practice-automation.com/");
	  fileUploadPage = homePage.clickOnFileUploadLink();
	}
	@When("user uploads file through Browse button")
	public void user_uploads_file_through_browse_button() 
	{
		actualFileName=fileUploadPage.clickOnBrowserButton(filePath);
	}

	@Then("the file name after upload should be {string}")
	public void the_file_name_after_upload_should_be(String expectedfileName) 
	{
		Assert.assertEquals(actualFileName,expectedfileName);
	}

	@When("user uploads file Using Robot Class")
	public void user_uploads_file_using_robot_class() throws InterruptedException, AWTException 
	{
		actualFileName = fileUploadPage.fileUploadUsingRobot(filePath);
	}
}
	
