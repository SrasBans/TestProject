package com.test.e2e;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.pom.SignUpPOM;
import com.test.reusable.BaseLib;

public class FlipkartSignUp extends BaseLib {

	@Test
	public void signUp() throws EncryptedDocumentException, InvalidFormatException, IOException {
		SignUpPOM.signUp(driver);
	}
}
