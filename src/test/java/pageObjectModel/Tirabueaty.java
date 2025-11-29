package pageObjectModel;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tirabueaty {
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver w = new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.tirabeauty.com/");
	
		Tirabueatyrepo repo = new Tirabueatyrepo(w);
		repo.searchEnter("Toner");
		Thread.sleep(2000);
		repo.searchclear();
		repo.productclick();
		String main = w.getWindowHandle();
		Set<String> multi = w.getWindowHandles();
		for(String m:multi)
		{
			if(!m.equals(main))
			{
				w.switchTo().window(m);
				Thread.sleep(2000);
				repo.addToBag();
				Thread.sleep(2000);
				repo.Viewcart();
			}
			w.close();
		}
	}
}
