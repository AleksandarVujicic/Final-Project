package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Meal_Page extends Basic_Page {

	public Meal_Page(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);

	}

	public WebElement getMealsButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'navs--main')]//li[1]/a"));
	}

	public WebElement getProduct() {
		return driver.findElement(By.xpath("//div[@class='product-list']/div"));
	}

	public WebElement getQuantity() {
		return driver.findElement(By.xpath("//input[@class='select-small js-current-product-qty']"));
	}

	public void setQuantity(String quantity) {
		this.getQuantity().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		this.getQuantity().sendKeys(quantity);
	}

	public WebElement getAddToFavorites() {
		return driver.findElement(By.id("item_153"));
	}

	public void addToCart(String quantity) {
		getMealsButton().click();
		getProduct().click();
		setQuantity(quantity);
		getAddToFavorites().click();
	}
}
