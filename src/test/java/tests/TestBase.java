package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public final Logger log = Logger.getLogger(this.getClass());
	public static WebDriver driver;

	@BeforeSuite
	public void startDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false); // To disable Extensions for Chrome
		driver = new ChromeDriver(options);
		// set browser window size to 1024x768
		// driver.manage().window().setSize(new Dimension(1024, 768));
		driver.manage().window().maximize();
		driver.navigate().to("https://footballstatsdirect.com/home");

	}

	@AfterSuite
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
