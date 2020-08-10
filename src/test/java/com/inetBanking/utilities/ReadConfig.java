package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
				
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is :"+e.getMessage());
		}
	}


	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String url = pro.getProperty("username");
		return url;
	}
	
	public String getPassword() {
		String url = pro.getProperty("password");
		return url;
	}
	
	public String getChromePath() {
		String url = pro.getProperty("chromepath");
		return url;
	}
	
	public String getIEPath() {
		String url = pro.getProperty("iepath");
		return url;
	}
	
	public String getFirefoxPath() {
		String url = pro.getProperty("firefoxpath");
		return url;
	}

}
