package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Notification_System_Page extends Basic_Page {

	public Notification_System_Page(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);

	}

	public WebElement getSystemMessage() {
		return driver
				.findElement(By.xpath("//div[contains(@class,'system_message')][contains(@style,'display: block')]"));
	}

	public String getNotificationMessage() {

		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]")).getText();
	}

	public String getNotificationErrorMessage() {

		return driver.findElement(By.xpath("//*[contains(@class, 'alert--danger')]")).getText();
	}

	public void waitForMessageToDisappear() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.attributeToBe(By.xpath(" //*[contains(@class, 'system_message')]"), "style",
				"display: none;"));
	}
}
