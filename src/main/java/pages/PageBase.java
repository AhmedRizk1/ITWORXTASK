package pages;




import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public WebDriver driver;
	public WebDriverWait wait;
	public final Logger log;

	// Constructor
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 60);
		log = Logger.getLogger(this.getClass());
		

	}

	// Wait Element Viability Method
	public void waitVisibility(WebElement element, String message) {
		log.info("Wait until  " + message+ " Appears");
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Can't find " + message);

		}

	}
	// Wait Element InViability Method
	public void waitinVisibility(WebElement element, String message) {
		log.info("Wait until " + message + " Disappears");
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			log.error( message + " Still Appears ");

		}

	}

	// Click Method
	public void click(WebElement element) {
		// waitVisibility(element);
		ExpectedConditions.elementToBeClickable(element);
		element.click();
	}

	// Write Text Method
	public void writeText(WebElement element, String text) {
		// waitVisibility(element);
		element.clear();
		element.sendKeys(text);
	}
	

}