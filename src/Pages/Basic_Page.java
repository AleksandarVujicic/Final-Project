package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Basic_Page {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;

	public Basic_Page(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		this.driver = driver;
		this.js = js;
		this.wait = wait;
	}
	
}
