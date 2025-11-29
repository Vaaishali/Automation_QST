package Keyworddriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screener {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\vaishali\\Desktop\\Selenium_vaishali\\Selenium_vaishali\\Selenium_Files\\Screener.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("sheet1");
		for(int i=1;i<=2;i++)
		{
			XSSFRow row = sheet.getRow(i);
			XSSFCell TestStep = row.getCell(6);
			WebDriver w = null;
			Repoofscreener repo = null;
			String ts = TestStep.toString();
			String [] arr = ts.trim().split("[0-9]");
			for(String a : arr)
			{
				System.out.println(a);
				if(a.contains("Launch a Chrome Browser")) {
					w = new ChromeDriver();
					repo = new Repoofscreener(w);
				}
				else if(a.contains("Navigate to Screener"))
				{
					repo.navgateURL("https://www.screener.in/");
					Thread.sleep(2000);
				}
				else if(a.contains("Enter Data on Search"))
				{
					repo.EnterSearchData("TCS");
					Thread.sleep(2000);
				}
				else if(a.contains("Click on Follow"))
				{
					repo.follow();
					Thread.sleep(2000);
				}
				else if(a.contains("Close the browser"))
				{
					Thread.sleep(2000);
					repo.close();
				}
				else {
					System.out.println("Test step missing are "+a);
				}
			}
		}
	}
}



























