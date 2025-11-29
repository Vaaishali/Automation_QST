package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {
	WebDriver w ;
	@BeforeMethod
	public void launchAnBrowser()
	{
		w = new ChromeDriver();
		w.get("https://turboviplay.com/login");
		w.manage().window().maximize();
	}
	@Test
	public void invalidlogin()
	{
		w.findElement(By.id("email")).sendKeys("gtyftfygyt");
		w.findElement(By.id("password")).sendKeys("gtgyegfygfryud3y3");
		w.findElement(By.id("btn-login")).click();
		String errormessage = w.findElement(By.cssSelector("div[class=\"text-danger mt-1 ms-2\"]")).getText().trim();
	//hard assertion
//		Assert.assertEquals(errormessage,"Incorrect login email");
//		String acttitle = w.getTitle();
//		Assert.assertEquals(acttitle,"Log In - Turbo VIPlay");
//		Assert.assertEquals(w.getCurrentUrl(),"https://turboviplay.com/login");
		
	//Soft assertion
		SoftAssert Assert = new SoftAssert();
		Assert.assertEquals(errormessage,"Incorrect login email");
		String acttitle = w.getTitle();
		Assert.assertEquals(acttitle,"Log In - Turbo VIPlay");
		Assert.assertEquals(w.getCurrentUrl(),"https://turboviplay.com/");
	}
	@AfterMethod
	public void CloseTheBrowser() {
		w.close();
	}
}

