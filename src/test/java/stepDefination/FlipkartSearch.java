package stepDefination;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Hybrid.Repoofflipkart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartSearch {
	
	static WebDriver w;
	Repoofflipkart repo;
	
	
	@Given("Launch an chrome browser.")
	public void launch_an_chrome_browser() {
	    w = new ChromeDriver();
	}

	@Given("navigate to flipkart site.")
	public void navigate_to_flipkart_site() {
	    w.get("https://www.flipkart.com/");
	    repo = new Repoofflipkart(w);
	}

	@When("search {string} in search field.")
	public void search_in_search_field(String search) {
	    repo.EnterSearch(search);
	}

	@When("submit the data.")
	public void submit_the_data() {
	    repo.submit();
	}
	
	@Then("Validated mobile has been searched by checking page title")
	public void Validated_mobile_has_been_searched_by_checking_page_title() {
		Assert.assertEquals(w.getTitle(),"mobile - buy products");
	}
	
	@Then("close chrome browser.")
	public void close_chrome_browser() {
	    w.quit();
	}
	
	@When("click on first product.")
	public void click_on_first_product() {
	    repo.Product();
	}

	@Then("Validated add to cart button in product title.")
	public void validated_add_to_cart_button_in_product_title() {
	    repo.windowHandle();
	    Assert.assertEquals(repo.addToCartText(),"ADD TO CART");
	}
}
