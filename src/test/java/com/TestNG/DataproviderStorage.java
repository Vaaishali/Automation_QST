package com.TestNG;

import org.testng.annotations.DataProvider;

public class DataproviderStorage 
{
	@DataProvider (name="login")
	public String[][] loginData()
	{
		String[][] up = new String [4][2];
		
		up[0][0] = "falcon226@proton.me";
		up[0][1] = "user@qst123Gm";
		
		up[1][0] = "konhumai@gmail.cpm";
		up[1][1] = "user@qst123Gm";
		
		up[2][0] = "whoareyou@gmail.com";
		up[2][1] = "nahire";
		
		up[3][0] = "falcon6519087";
		up[3][1] = "user@qst12";
		
		return up;
	}
}
