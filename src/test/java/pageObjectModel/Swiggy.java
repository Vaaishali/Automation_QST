package pageObjectModel;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Swiggy 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver w = new ChromeDriver();
        w.manage().window().maximize();
        w.get("https://www.swiggy.com");
        Swiggyrepo swiggy = new Swiggyrepo(w);
        Thread.sleep(2000);
        swiggy.enterLocation("Mumbai");
        Thread.sleep(2000);
        swiggy.searchFood("Pizza");
        Thread.sleep(2000);
        String main = w.getWindowHandle();
		Set<String> multi = w.getWindowHandles();
		for(String m:multi)
		{
			if(!m.equals(main))
			{
				w.switchTo().window(m);
				Thread.sleep(2000);
				swiggy.enterLocation(m);
				Thread.sleep(2000);
				swiggy.searchFood(main);
			}
			w.close();
		}
	}
}
