package Keyworddriven;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Repoofscreener extends Maincodeforscreener
{
	public Repoofscreener(WebDriver w) 
	{
		super(w);
		PageFactory.initElements(w,this);
		
	}
	@FindBy(css = "input[aria-label=\"Search for a company\"]")
	List<WebElement> search;
	
	@FindBy(xpath ="//*[@class=\"button-primary \"]")
	WebElement follow;

	public void EnterSearchData(String SearchData) 
	{
		for(WebElement s : search)
		{
			try {
				s.sendKeys(SearchData);
				Thread.sleep(500);
				s.sendKeys(Keys.ENTER);
			}catch(Exception e)
			{
				
			}
		}
	}
	public void follow()
	{
		follow.click();
	}
}
