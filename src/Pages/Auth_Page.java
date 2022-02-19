package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auth_Page extends Basic_Page {

	public Auth_Page(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);

	}

	public WebElement getAccountPopup() {
		return driver.findElement(By.xpath("//div[@class='accounts-link accounts-popup']"));
	}

	public WebElement getMyAccount() {
		return driver.findElement(By.xpath("//div[@class='my-account-dropdown']/ul/li"));
	}

	public WebElement getLogout() {
		return driver.findElement(By.xpath("//div[@class='my-account-dropdown']/ul/li[2]"));
	}

	public void logout() throws InterruptedException {
		getAccountPopup().click();
		Thread.sleep(1500);
		getLogout().click();
	}
}
