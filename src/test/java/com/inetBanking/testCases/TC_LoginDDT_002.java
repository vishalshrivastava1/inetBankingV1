package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.utilities.XLUtils;
import com.inteBanking.pageObject.LoginPage;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData" )
	public void loginDDT(String user, String pwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("User Name is provided");
		lp.setPassword(pwd);
		logger.info("Password is provided");
		lp.clickSubmit();
		logger.info("Login button has been clicked");
		Thread.sleep(3000);

		
		if(isAlertPresent()==true) 
		{
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			Thread.sleep(3000);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();	
			logger.warn("Login Passed");
		}
	}
	
	
	
	
	//User defined method created to check alert is present or not.
	public boolean isAlertPresent() {
		try 
		{
		driver.switchTo().alert();
		return true;
		} 
		catch(NoAlertPresentException e) 
		{
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
	
	


}
