package Keyworddriven;

import org.openqa.selenium.WebDriver;

public class Maincodeforscreener {
WebDriver w;
	 public Maincodeforscreener(WebDriver w) {
		 this.w=w;
	 }
	 public void navgateURL(String url) {
		w.get(url);
	}
	 public void maximizewindow() {
		w.manage().window().maximize();
	}
	 public void close() {
		w.quit();
	}
}
