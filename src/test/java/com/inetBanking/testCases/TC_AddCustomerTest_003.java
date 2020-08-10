package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inteBanking.pageObject.AddCustomerPage;
import com.inteBanking.pageObject.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass{

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("User Name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		logger.info("Login button has been clicked");

		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("Providing Customer Details....");
		
		addcust.custName("Vishal");
		addcust.custgender("male");
		addcust.custdob("27","12","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("AZM");
		addcust.custstate("UP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation Started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
			
		if(res==true) 
		{
			Assert.assertTrue(true);
			logger.info("Test Case is Passed...");
		}
		else 
		{
			logger.info("Test case is Failed...");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
		}
	}
	

	
}
