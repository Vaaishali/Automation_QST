package com.TestNG;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.Tirabueatyrepo;

public class AnotationofTirabueauty {
	WebDriver w;
	Tirabueatyrepo repo;
	String main;
	@BeforeSuite
	public void launchBrowser()
	{
		w=new ChromeDriver();
		w.manage().window().maximize();
		
		repo = new Tirabueatyrepo(w);
	}
	@BeforeTest
	public void navigatetoTirabueatysite()
	{
		w.get("https://www.tirabeauty.com/");
	}
	@BeforeClass
	public void Search()
	{
		repo.searchEnter("Shampoo");
	}
	@BeforeMethod
	public void product() throws Exception
	{
		Thread.sleep(5000);
		repo.productclick();
		main = w.getWindowHandle();
		Set<String> multi = w.getWindowHandles();
		for(String mu : multi) {
			if(!mu.equals(main)) {
				w.switchTo().window(mu);
			}
		}
	}
	@Test(priority = 1)
	public void AddToBag() throws Exception 
	{
		Thread.sleep(2000);
		repo.addToBag();
	}
	@Test(priority = 2)
	public void Wishlist() throws Exception 
	{
		Thread.sleep(2000);
		repo.Wishlist();
	}
	@Test(priority = 3)
	public void viewcart() throws Exception 
	{
		Thread.sleep(2000);
		repo.Viewcart();
	}
	@AfterMethod
	public void switchBacktomainpage() throws Exception
	{
		Thread.sleep(2000);
		w.close();
		w.switchTo().window(main);
	}
	@AfterClass
	public void backToHomepage() throws Exception {
		Thread.sleep(2000);
		w.navigate().back();
	}
	@AfterTest
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		w.quit();
	}
}