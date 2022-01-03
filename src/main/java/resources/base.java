package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
	prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\91700\\OneDrive\\Desktop\\project 2\\E2EProject\\src\\main\\java\\resources\\data.propertiec");
	prop.load(fis);
	String browserName= prop.getProperty("browser");
	if (browserName.equals("chrome"))
	{
		//excute in chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91700\\OneDrive\\Desktop\\Work\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if (browserName.equals("firefox"))
	{
		//excute in firefox driver
	}
	else if (browserName.equals("IE"))
	{
		//excute in IE driver
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	
}
public void getScreenshot(String result) throws IOException
{
	
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File("C:\\Users\\91700\\OneDrive\\Desktop\\project 2\\"+ result + "screenshot.png"));
	
}

}
