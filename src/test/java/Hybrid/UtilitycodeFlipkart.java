package Hybrid;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class UtilitycodeFlipkart {
	private WebDriver w;
    private String main;

    public UtilitycodeFlipkart(WebDriver w) {
        this.w = w;
    }

    public void windowHandle() {
        String main = w.getWindowHandle();
        this.main = main;
        Set<String> multi = w.getWindowHandles();
        for (String m : multi) {
            if (!m.equals(main)) {
                w.switchTo().window(m);
            }
        }
    }
    public void parentWindow() {
        w.switchTo().window(main);
    }

    public void get(String url) {
        w.get(url);
    }

    public void close() {
        w.close();
    }

    public void quit() {
        w.quit();
    }

    public void maximize() {
        w.manage().window().maximize();
    }

    public void globalWait(int second) {
        w.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }
}

