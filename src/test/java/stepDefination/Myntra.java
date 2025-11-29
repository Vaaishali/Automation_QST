package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Myntra {

	@Given("user navigate to myntra site.")
	public void user_navigate_to_myntra_site() {
	    FlipkartSearch.w.get("https://www.myntra.com/");
	}

	@When("user Enter {string} data in search box and submit it.")
	public void user_enter_data_in_search_box_and_submit_it(String search) {
		FlipkartSearch.w.findElement(By.className("desktop-searchBar")).sendKeys(search,Keys.ENTER);
	}

	@Then("user check page title based on search result {string}")
	public void user_check_page_title_based_on_search_result(String ExpTitle) {
		String actTitle = FlipkartSearch.w.getTitle();
		boolean search = actTitle.contains(ExpTitle);
		
		try {
			Assert.assertEquals(true, search);
		} finally 
		{
			if(search!=true)
			{
				System.out.println("Actual title is"+actTitle +"is not match" +ExpTitle);
			}
		}
	}	
}
