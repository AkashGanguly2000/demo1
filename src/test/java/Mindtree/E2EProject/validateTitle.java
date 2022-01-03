package Mindtree.E2EProject;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to Home Page");
	}
	

		@Test
		public void basePageNavigation() throws IOException
		{
			
			LandingPage l = new LandingPage(driver);
			Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
			log.info("Successfully validate text message");
		}
		@AfterTest
		public void closeBrowser()
		{
			driver.close();
			driver=null;
		}

}


