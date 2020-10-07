package com.test.pom;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.reusable.InputData;
import com.test.reusable.WaitLib;

public class SignUpPOM{

	@FindBy(className="oZoRPi")
	private static WebElement newCustomer;

	@FindBy(xpath="//div[contains(@class,'_39M2dM JB4AMj')]//span[contains(@class,'b5konl')]")
	private static WebElement enterMob;

	static Logger logger = LogManager.getLogger(SignUpPOM.class);

	public static void signUp(WebDriver driver) throws EncryptedDocumentException, InvalidFormatException, IOException {
		PageFactory.initElements(driver, new SignUpPOM());
		WaitLib.eWaitForVisibility(driver, 30, newCustomer);
		newCustomer.click();
		logger.debug("element is clicked");
		WaitLib.iWait(driver, 10);
		driver.findElement(By.xpath("//div[contains(@class,'_39M2dM JB4AMj')]//span[contains(@class,'b5konl')]")).sendKeys(InputData.getValue("inputdata", "Mobile", 1));

	}}
