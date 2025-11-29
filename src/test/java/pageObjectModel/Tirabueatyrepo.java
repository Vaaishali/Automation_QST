//POM model with page factory..

package pageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tirabueatyrepo {

	public Tirabueatyrepo(WebDriver w)
	{
		PageFactory.initElements(w, this);
	}
	//Element
	@FindBy(css = "Input[id=\"search\"]" )
	private WebElement search;
	@FindBy(css = "a[class=\"product-wrap\"]")
	private WebElement product;
	@FindBy(css = "button[class=\"custom-btn primary lg no-tap-highlight\"]")
	private WebElement addToBag;
	@FindBy(css = "a[class=\"wishlist-icon\"]")
	private WebElement Viewcart;
	@FindBy(css = "button[class=\"custom-btn secondary lg no-tap-highlight\"]")
	private WebElement Wishlist;
	
	//set of Action
	public void searchEnter(String search)
	{
		this.search.sendKeys(search,Keys.ENTER);
	}
	public void searchclear()
	{
		search.clear();
	}
	public void productclick() 
	{
		product.click();
	}
	public void addToBag() 
	{
		addToBag.click();
	}
	public void Viewcart()
	{
		Viewcart.click();
	}
	public void Wishlist() 
	{
		Wishlist.click();
	}
}
