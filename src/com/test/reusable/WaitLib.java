package com.test.reusable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitLib {

	public static void eWaitForVisibility(WebDriver driver,int secs,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,secs);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
	}

	public static void iWait(WebDriver driver, int sec){
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
}
