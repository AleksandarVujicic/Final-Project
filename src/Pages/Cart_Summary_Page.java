package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart_Summary_Page extends Basic_Page {

	public Cart_Summary_Page(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);

	}

	public WebElement getClearAll() {
		return driver.findElement(By.xpath("//div[@class='cart-head']/a[2]"));
	}

	public void clearCart() {
		getClearAll().click();
	}
}
