package com.test.reusable;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {

	public WebDriver driver=null;
	static Logger logger = LogManager.getLogger(BaseLib.class);

	@BeforeMethod
	public void launchBrowser() throws EncryptedDocumentException, InvalidFormatException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/A1QHBOH1/Downloads/chromedriver_win32/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		String url=InputData.getValue("Inputdata", "url", 1);
		driver.get(url);
		logger.debug("Chrome is launched");
	}

	@AfterMethod
	public void takeScreenshot(ITestResult result)
	{
		String scriptName = result.getMethod().getMethodName();
		if(result.isSuccess())    //true
		{
			logger.info(scriptName+" script is passed",true);
		}
		else
		{
			// false--> fail
			System.out.println( scriptName+" script failed");
			ScreenshotLib slib=new ScreenshotLib();
			slib.takeScreenshot(driver, scriptName);
		}
		driver.close();
	}
}
