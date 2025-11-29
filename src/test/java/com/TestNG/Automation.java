package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Automation {
	@BeforeSuite
	public void Bsuite() {
		System.out.println("This is an Before suite");
	}
	@BeforeTest
	public void Btest() {
		System.out.println("This is an Before test");
	}
	@BeforeClass
	public void BClass() {
		System.out.println("This is an Before class");
	}
	@BeforeMethod
	public void Bmethod() {
		System.out.println("This is an Before method");
	}
	@Test
	public void test11() {
		System.out.println("This is 1st test condition");
	}
	@Test
	public void test2() {
		System.out.println("This is 2nd test condition");
	}
	@AfterMethod
	public void Amethod() {
		System.out.println("This is an After method");
	}
	@AfterClass
	public void AClass() {
		System.out.println("This is an After class");
	}
	@AfterTest
	public void Atest() {
		System.out.println("This is an After test");
	}
	@AfterSuite
	public void Asuite() {
		System.out.println("This is an After suite");
	}
}
