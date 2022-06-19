package pages;

import static org.testng.Assert.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FootballPage extends PageBase {

	public FootballPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button//span[contains(text(),'La Liga')]")
	public WebElement laLigaButton;
	@FindBy(xpath = "//div[contains(.,'Points')]//span[@class='ag-header-icon ag-header-label-icon ag-sort-descending-icon']")
	public WebElement pointsDescSortIcon;
	@FindBy(xpath = "//div[@row-index='0']//*[@col-id='team']")
	public WebElement firstTeamName;
	@FindBy(xpath = "//div[@role='presentation']//span[@class='ag-header-cell-text'][contains(.,'Goals For')]")
	public WebElement gooalForButton;
	@FindBy(xpath = "//div[contains(.,'Goals For')]//span[@class='ag-header-icon ag-header-label-icon ag-sort-descending-icon']")
	public WebElement forGoalsDescSortIcon;
	@FindBy(xpath = "//button//span[contains(text(),'Top 20 Scorers')]")
	public WebElement top20ScorersButton;
	@FindBy(xpath = "//span[(text() = 'Club' or . = 'Club')]")
	public WebElement clubColumnButton;
	@FindBy(xpath = "(//div[@class='ag-cell-label-container ag-header-cell-sorted-none']/span/span)[5]")
	public WebElement menuIconOfClubColumn;
	@FindBy(xpath = "//div[@class='ag-tabs ag-menu ag-focus-managed ag-ltr ag-popup-child']/div/span[2]")
	public WebElement filterIconOfClubColumn;
	@FindBy(xpath = "//div[@class='ag-tabs ag-menu ag-focus-managed ag-ltr ag-popup-child ag-keyboard-focus']/div/span[2]")
	public WebElement filterIconOfClubafterfilter;

	@FindBy(xpath = "//div[@class='ag-filter-body']//input[@placeholder='Filter...']")
	public WebElement filtertxtFiled;

	public void laLiga() throws IOException, InterruptedException {

		// Wait for La Liga Button to be visible
		waitVisibility(laLigaButton, "laLiga Button");
		log.info("Click on La Liga Button");
		click(laLigaButton);

		log.info("check that Point columns is sorted Desc");
		waitVisibility(pointsDescSortIcon, "Points desc sort icon");

		// Wait for first Team Name to be visible
		waitVisibility(firstTeamName, "First Team Name");
		log.info("The team with the highest points is : " + firstTeamName.getText());
		System.out.println("The team with the highest points is : " + firstTeamName.getText());

		// verify that The team with the highest points is Real Madrid
		log.info("verify that The team with the highest points is Real Madrid");
		assertEquals(firstTeamName.getText(), "Real Madrid");

		// Wait for Goals for button to be visible
		waitVisibility(gooalForButton, "Goals for button");
		log.info("Click on Goals for button");
		click(gooalForButton);
		click(gooalForButton);

		// Wait For Goals Desc sort icon to be visible
		waitVisibility(forGoalsDescSortIcon, "For Goals desc sort icon");
		log.info("The team with the highest Goals is : " + firstTeamName.getText());
		System.out.println("The team with the highest Goals is : " + firstTeamName.getText());

		// verify that The team with the highest Goals is Real Madrid
		log.info("verify that The team with the highest Goals is Real Madrid ");
		assertEquals(firstTeamName.getText(), "Real Madrid");

		// Wait for Goals for Top 20 Scorers to be visible
		waitVisibility(top20ScorersButton, "Top 20 Scorers");
		log.info("Click on top20ScorersButton  ");
		click(top20ScorersButton);
		Actions action = new Actions(driver);
		// Wait for Goals for Club column menu icon to be visible
		waitVisibility(clubColumnButton, "Club column menu icon");
		// Hover over club Button
		action.moveToElement(clubColumnButton).build().perform();
		// Wait for Club column menu icon to be visible
		waitVisibility(menuIconOfClubColumn, "Club column menu icon");
		click(menuIconOfClubColumn);

		// Wait for Filter icon of Club column to be visible
		waitVisibility(filterIconOfClubColumn, "Filter icon of Club coulmn");

		log.info("Click on filterIconOfClubColumn  ");
		click(filterIconOfClubColumn);

		// Wait for Filter txt Filed to be visible
		waitVisibility(filtertxtFiled, "Filter txt Filed");

		log.info("Type Real Madrid in filter search");
		writeText(filtertxtFiled, "Real Madrid");

		// Wait for Filter icon of Club coulmn to be visible
		waitVisibility(filterIconOfClubafterfilter, "Filter icon of Club coulmn");

		log.info("Click on filterIconOfClubColumn again to close the filter ");
		click(filterIconOfClubafterfilter);

		// Create web element list for the players
		List<WebElement> plyers = driver.findElements(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Real Madrid'])/preceding::span[1]"));
		FileWriter fw = new FileWriter("./Logs/TxtWriter.txt ", false);

		System.out.println("Total No of top Scores playes Real Madrid are : " + plyers.size());
		log.info("log the players names in the file ");
		for (WebElement webElement : plyers) {
			String name = webElement.getText();
			// log the players name in console
			log.info(name);
			// Write the players name in the txt file
			fw.write(name + "\n");
		}
		// close file writer after finish
		log.info("close file writer after finish  ");
		fw.close();
		
		// add constant sleep time to check the Ï results
		Thread.sleep(3000);

	}
}
