package Hybrid;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Keyworddriven.Maincodeforscreener;

public class Repoofflipkart extends UtilitycodeFlipkart {
	private WebDriver w;
	public Repoofflipkart(WebDriver w) {
		super(w);
		this.w=w;
	}
	Actions act;
	
	private By search = By.name("q");
    private By product1Design = By.className("CGtC98");
    private By product2Design = By.className("V3OarP");
    private By addToCart = By.cssSelector("button[class=\"QqFHMw vslbG+ In9uk2\"]");
    private By placeOrder = By.cssSelector("button[class=\"QqFHMw zA2EfJ _7Pd1Fp\"]");
    private By addToCartIcon = By.cssSelector("button[class=\"QqFHMw vslbG+ In9uk2\"]");
    private By viewcart = By.cssSelector("a[title='Cart']");
    private By buynow = By.cssSelector("button[class=\"QqFHMw vslbG+ _3Yl67G _7Pd1Fp\"]");
    private By pincode = By.id("pincodeInputId");
    private By check = By.cssSelector("span[class=\"i40dM4\"]");
    
  // Action --> perform
    public void clearSearch() {
        w.findElement(search).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
    }

    public void EnterSearch(String search) {
        w.findElement(this.search).sendKeys(search, Keys.ENTER);
    }

    public void Product() {
        try {
            w.findElement(product1Design).click();
        } catch (Exception e) {
            try {
            	w.findElement(product2Design).click();
            }
            catch (Exception e2) 
            {
            	
            }
        }
    }
    public void addToCart() {
        try {
            act = new Actions(w);
            WebElement addtocart = w.findElement(addToCart);
            act.moveToElement(addtocart).click().perform();
        } catch (Exception e) {
            w.findElement(addToCartIcon).click();
        }
    }

    public void placeOrder() {
        act = new Actions(w);
        WebElement placeorder = w.findElement(placeOrder);
        act.moveToElement(placeorder).click().perform();
    }

    public void viewCart() {
        w.findElement(viewcart).click();
    }

    public void buyNow() {
        act = new Actions(w);
        WebElement buynow = w.findElement(this.buynow);
        act.moveToElement(buynow).click().perform();
    }
    public void pincode(String pincode) {
        w.findElement(this.pincode).sendKeys(pincode);
    }
    public void check() {
        w.findElement(check).click();
    }
    public void submit() {
    	w.findElement(this.search).submit();
    }
    public String addToCartText() {
    	return w.findElement(addToCart).getText();
    }
}
