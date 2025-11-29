package Hybrid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Keyworddriven.Repoofscreener;

public class HybridScreener {

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\vaishali\\Desktop\\Selenium_vaishali\\Selenium_vaishali\\Selenium_Files\\Screener.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet= work.getSheet("sheet1");
		for(int i =1;i<=2;i++)
		{
			WebDriver w = null;
			Repoofscreener repo = null;
			XSSFRow r = sheet.getRow(i);
			XSSFCell testDatas = r.getCell(5);
			String[] testData = testDatas.toString().split(",");
			for(String data : testData) {
				XSSFCell TestSteps = r.getCell(6);
				String[] testSteps = TestSteps.toString().trim().split("[0-9]");
				for(String step : testSteps)
				{
					if(step.contains("Launch a Chrome Browser")) {
						w = new ChromeDriver();
						repo = new Repoofscreener(w);
					}
					else if(step.contains("Navigate to Screener"))
					{
						repo.navgateURL("https://www.screener.in/");
						Thread.sleep(2000);
					}
					else if(step.contains("Enter Data on Search"))
					{
						repo.EnterSearchData(data);
						Thread.sleep(2000);
					}
					else if(step.contains("Click on Follow"))
					{
						repo.follow();
						Thread.sleep(2000);
					}
					else if(step.contains("Close the browser"))
					{
						Thread.sleep(2000);
						repo.close();
					}
					else {
						System.out.println("Test step missing are "+step);
					}
				}
			}
		}
	}
}
