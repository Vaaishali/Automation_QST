package Hybrid;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Keyworddriven.Repoofscreener;


public class FlipkartHybrid {
		public static void main(String[] args) throws Exception {
	        FileInputStream fis = new FileInputStream("C:\\Users\\vaishali\\Desktop\\Selenium_vaishali\\Selenium_vaishali\\Selenium_Files\\Flipkart.xlsx");
	        XSSFWorkbook work = new XSSFWorkbook(fis);
	        XSSFSheet sheet = work.getSheet("Sheet2");

	        for (int i = 1; i <= 6; i++) {
	            XSSFRow row = sheet.getRow(i);
	            String[] testdata = new String[1];
	            testdata[0] = "";
	            try {
	                XSSFCell testDatas = row.getCell(2);
	                if (testDatas != null) {
	                    testdata = testDatas.toString().split(",");
	                }
	            } catch (Exception e) {}

	            int j = 0;
	            do {
	                String td = testdata[j];

	                XSSFCell testSteps = row.getCell(1);
	                String[] teststep = testSteps.toString().split("[0-9]");

	                WebDriver w = null;
	                Repoofflipkart r = null;

	                for (String ts : teststep) {
	                    if (ts.trim().equalsIgnoreCase("launch an browser")) {
	                        w = new ChromeDriver();
	                        r = new Repoofflipkart(w);
	                    }
	                    else if (ts.trim().equalsIgnoreCase("navigate to flipkart.com")) {
	                        r.get("https://www.flipkart.com/");
	                    } else if (ts.trim().equalsIgnoreCase("submit data to search")) {
	                        r.EnterSearch(td);
	                    } else if (ts.trim().equalsIgnoreCase("click the first product")) {
	                        r.Product();
	                        r.windowHandle();
	                    } else if (ts.trim().equalsIgnoreCase("submit 'AC' to search field")) {
	                        r.EnterSearch("AC");
	                    } else if (ts.trim().equalsIgnoreCase("enter a pincode")) {
	                        Thread.sleep(2000);
	                        r.pincode(td);
	                    } else if (ts.trim().equalsIgnoreCase("click on check button")) {
	                        Thread.sleep(2000);
	                        r.check();
	                    }else if (ts.trim().equalsIgnoreCase("click on buy now button")) {
	                        Thread.sleep(2000);
	                        r.buyNow();
	                    } else if (ts.trim().equalsIgnoreCase("click on Add to cart button")) {
	                        Thread.sleep(2000);
	                        r.addToCart();
	                    } else if (ts.trim().equalsIgnoreCase("click on view cart logo")) {
	                        r.viewCart();
	                    } else if (ts.trim().equalsIgnoreCase("close the browser")) {
	                        Thread.sleep(2000);
	                        r.quit();
	                    }
	                    else {
	                    	System.out.println(ts);
	                    }

	                    j++;
	                } 
	                }while (j < testdata.length);
	            }
}			
}
	    