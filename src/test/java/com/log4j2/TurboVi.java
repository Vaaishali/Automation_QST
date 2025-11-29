package com.log4j2;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TestNG.DataproviderStorage;

public class TurboVi {
			Logger log;
			WebDriver w;
			@BeforeClass
			public void launchAnBrowser()
			{
				log = LogManager.getFormatterLogger();
				w = new ChromeDriver();
				log.info("Chrome Browser has been Launch");
				if (w!=null) {
					w.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
					log.info("global wait for 3 sec till every element is loaded.");
				} else {
					log.error("Chrome browser is been not started or has been closed");
				}
			}
			@BeforeMethod
			public void NavigateTologin() 
			{
				if (w!=null) {
					w.get("https://turboviplay.com/login");
					log.info("user has been redirected to turboViplay site");
				} else {
					log.error("Chrome browser is been not started or has been closed");
				}
			}
			@Test (dataProviderClass = DataproviderStorage.class,dataProvider = "login")
			
			public void Verifylogin(String username,String password)
			{
				if (w!=null) {
					w.findElement(By.id("email")).sendKeys(username);
					log.info("User has Enter"+username+"in username field");
					w.findElement(By.id("password")).sendKeys(password);
					log.info("User has Enter"+password+"in password field");
					w.findElement(By.id("btn-login")).click();
					log.info("User click on Login button");
					SoftAssert soft = new SoftAssert();
					soft.assertEquals(w.getCurrentUrl(),"https://turboviplay.com/dashboard");
					soft.assertEquals(w.getTitle(),"Dashboard - Turbo VIPlay");
					soft.assertAll();
				} else {
					log.error("Chrome browser is been not started or has been closed");
				}	
			}
			
			@AfterMethod
			public void logout()
			{
				try {
					w.findElement(By.id("VIP")).click();
					w.findElement(By.linkText(" Logout")).click();
				}catch(Exception e)
				{
					
				}
			}
		}

