package tests;

import org.testng.annotations.Test;

import pages.FootballPage;

import java.io.IOException;


public class FootballTest extends TestBase{

	FootballPage football;
	
	@Test
	public void laLigaTest() throws InterruptedException, IOException {
		
		// we have small change here as when i try to navigate to the link and to check
		// English Premier League the data table was empty so i navigate to the La Liga
		// and continue the flow with the change of Teams names for the highest points
		// and highest goals.
		
		log.info("Start to Check La liga Champions");
		football = new FootballPage(driver);
		football.laLiga();
				
	}
}
