package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;


public class TestNGdemo 
{
	@Parameters("browser")
	@Test (priority=1)
	public void Flipkart(String bro) throws Exception
	{
		WebDriver w;
		if (bro.equals("chrome")) {
			w = new ChromeDriver();
		}else if(bro.equals("firefox")) {
			w = new FirefoxDriver();
		}else {
			w=null;
		}
		w.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		w.quit();
	}
	
	@Parameters("browser")
	@Test (priority=2)
	public void Facebook(String bro) throws Exception
	{
		WebDriver w;
		if (bro.equals("chrome")) {
			w = new ChromeDriver();
		}else if(bro.equals("firefox")) {
			w = new FirefoxDriver();
		}else {
			w=null;
		}
		w.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		w.quit();
	}
}
