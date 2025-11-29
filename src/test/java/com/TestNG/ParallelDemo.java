package com.TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelDemo {
	//ThreadLocal<WebDriver> w = new ThreadLocal<WebDriver>();
	ThreadLocal<RemoteWebDriver> w = new ThreadLocal<RemoteWebDriver>();
	DesiredCapabilities dc;
	//RemoteWebDriver rw;
	@BeforeMethod
	public void launchBrowser()
	{
		dc = new DesiredCapabilities();
		dc.setPlatform(Platform.WINDOWS);
		dc.setBrowserName("chrome");
		//rw = new RemoteWebDriver(dc);
		//w.set(new ChromeDriver());
		w.set(new RemoteWebDriver(dc));
	}
	@Test
	public void google() throws Exception {
	w.get().get("https://www.google.com/");
	Thread.sleep(3000);
	}
	@Test
	public void facebook() throws Exception {
	w.get().get("https://www.facebook.com/");
	Thread.sleep(3000);
	}
	@AfterMethod
	public void closebrowser() {
		w.get().quit();
	}
}