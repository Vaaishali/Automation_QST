package com.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TurboViPlay {
	WebDriver w;
	@BeforeClass
	public void launchAnBrowser()
	{
		w = new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	@BeforeMethod
	public void NavigateTologin() 
	{
		w.get("https://turboviplay.com/login");
	}
	@Test (dataProviderClass = DataproviderStorage.class,dataProvider = "login")
	
	public void Verifylogin(String username,String password)
	{
		w.findElement(By.id("email")).sendKeys(username);
		w.findElement(By.id("password")).sendKeys(password);
		w.findElement(By.id("btn-login")).click();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(w.getCurrentUrl(),"https://turboviplay.com/dashboard");
		soft.assertEquals(w.getTitle(),"Dashboard - Turbo VIPlay");
		soft.assertAll();
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
