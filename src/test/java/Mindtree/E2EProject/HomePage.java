package Mindtree.E2EProject;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException 
	{
		driver=initializeDriver();
		//log.info("Driver is initialized");

		
	}

	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String email,String Password) throws IOException
	{
		driver.get(prop.getProperty("URL"));
		//log.info("Navigated to Home Page");

		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getemail().sendKeys(email);
		lp.getpassword().sendKeys(Password);
		
		lp.getLogIn().click();
		
	}
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data type test should run
		//coloumn stands for how many value per each test 
		Object[][] data = new Object[2][2];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1] = "12345";
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1] = "54321";
		return data;
		
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}
	
}
