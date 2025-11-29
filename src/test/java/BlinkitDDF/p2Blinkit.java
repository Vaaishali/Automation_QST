package BlinkitDDF;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class p2Blinkit 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriver w= new FirefoxDriver();
		
		Thread.sleep(2000);
		w.get("https://blinkit.com/?srsltid=AfmBOoqaQUkw0jV3eByFracDOSreFMbfSYAhtIKFxABFAgEx1tf1cPGM");
		FileInputStream fis = new FileInputStream("C:\\Users\\vaishali\\Desktop\\Selenium_vaishali\\Selenium_vaishali\\Selenium_Files\\Blinkit.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet searchsheet = work.getSheet("Sheet1");
//		for(int i=1;i<=3;i++)
//		{
			XSSFRow row = searchsheet.getRow(1);
			XSSFCell search = row.getCell(0);
			w.findElement(By.name("select-locality")).sendKeys(search.toString(),Keys.ENTER);
			Thread.sleep(2000);
			
			w.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/header/div[2]/div[2]/div/div/div[2]/div/div/div[1]")).click();
			Thread.sleep(2000);
			
			XSSFRow colm = searchsheet.getRow(2);
			XSSFCell search1 = row.getCell(1);
			w.findElement(By.cssSelector
					("SearchBar__AnimationWrapper-sc-16lps2d-1.iJnYYS")).click();
			
			
			Thread.sleep(2000);
		
			//}
		w.close();
	}
}
