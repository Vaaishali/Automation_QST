package BlinkitDDF;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PractiseBlinkit {

	public static void main(String[] args) throws Exception
	{
		WebDriver w= new FirefoxDriver();
		Thread.sleep(2000);
		w.get("https://blinkit.com/?srsltid=AfmBOoqaQUkw0jV3eByFracDOSreFMbfSYAhtIKFxABFAgEx1tf1cPGM");
		FileInputStream fis = new FileInputStream("C:\\Users\\vaishali\\Desktop\\Selenium_vaishali\\Selenium_vaishali\\Selenium_Files\\Blinkit.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet searchsheet = work.getSheet("Sheet1");
		for(int i=1;i<=3;i++)
		{
			XSSFRow row = searchsheet.getRow(i);
			XSSFCell search = row.getCell(0);
			w.findElement(By.name("select-locality")).sendKeys(search.toString(),Keys.ENTER);
			Thread.sleep(2000);
			w.findElement(By.name("select-locality")).sendKeys(Keys.CONTROL,Keys.BACK_SPACE);
			Thread.sleep(2000);
		}
		
		w.close();
		
	}

}
