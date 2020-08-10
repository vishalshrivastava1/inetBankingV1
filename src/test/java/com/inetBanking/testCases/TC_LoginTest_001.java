package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inteBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws IOException 
	{

		logger.info("URL is opened");
			
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered UserName");

		lp.setPassword(password);
		logger.info("Entered Password");

		lp.clickSubmit();
		logger.info("Click button has been entered");
		
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			logger.info("Login Test is passed");
		}
		else 
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test is Failed");
		}
		
	}

}
