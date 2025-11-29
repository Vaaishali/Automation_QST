package pageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Swiggyrepo 
{

	public Swiggyrepo(WebDriver w) 
	{
		PageFactory.initElements(w, this);
	}
	//Element
	@FindBy(id = "location")
    WebElement locationInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[1]/div/form/div")
    WebElement searchBox;
	
    //Action
    public void enterLocation(String loc)
    {
    	locationInput.sendKeys(Keys.ENTER);
    }
    public void searchFood(String food)
    {
    	searchBox.sendKeys(Keys.ENTER);
    }
}
