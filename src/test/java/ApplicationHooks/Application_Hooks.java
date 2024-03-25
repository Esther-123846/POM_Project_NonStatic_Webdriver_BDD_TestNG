package ApplicationHooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Factory.DriverFactory;
import com.practiceautomate.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Application_Hooks 
{
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader ConfigReader;
	Properties properties;
	
	@Before(order = 0)
	public void getProperty()
	{
		ConfigReader = new ConfigReader();
		properties = ConfigReader.init_properties();
	}
	
	@Before(order = 1)
	public void launchBrowser()
	{
		String browser = properties.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browser);
	}
	
	@After(order = 0) //higher priority will execute first unlike @before
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order = 1) //higher priority will execute first unlike @before
	public void tearDown(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			String screeshotName = scenario.getName().replaceAll(" ","_");
			TakesScreenshot  takesScreenshot = ((TakesScreenshot)driver);
			byte[] sourcePath = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile,new File("./src/test/java/ScreenShots/"+screeshotName+".png"));
			scenario.attach(sourcePath, "image/png", screeshotName);
		}
	}
}
