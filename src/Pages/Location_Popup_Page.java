package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Location_Popup_Page extends Basic_Page {

	public Location_Popup_Page(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);

	}

	public WebElement getSelectLocation() {
		return driver.findElement(By.xpath("//div[@class='location-selector']/a"));
	}

	public WebElement getCloseButton() {
		return driver.findElement(By.xpath("//a[@class='close-btn close-btn-white']"));
	}

	public WebElement getKeyWord() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));

	}

	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	public void openPopUpWindow() {
		getSelectLocation().click();
	}

	public void setLocation(String locationName) throws InterruptedException {

		js = (JavascriptExecutor) driver;
		getKeyWord().click();
		Thread.sleep(1000);
		String location = getLocationItem(locationName).getAttribute("data-value");
		Thread.sleep(1000);
		js.executeScript("arguments[0].value=arguments[1]", getLocationInput(), location);
		js.executeScript("arguments[0].click();", getSubmit());
		Thread.sleep(1500);

	}
}
