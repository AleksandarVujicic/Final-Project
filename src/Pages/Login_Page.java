package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page extends Basic_Page {

	public Login_Page(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);

	}

	public void openLoginPage() {
		driver.navigate().to("http://demo.yo-meals.com/guest-user/login-form");
	}
	
	public WebElement getUserName() {
		return driver.findElement(By.xpath("//*[@name='username']"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.xpath("//*[@name='password']"));
	}

	public WebElement getRememberMe() {
		return driver.findElement(By.xpath("//*[@class='checkbox']"));
	}

	public WebElement getLoginPage() {
		return driver.findElement(By.xpath("//div[contains(@class, 'accounts-link accounts-popup')]/ul/li[2]"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//input[contains(@name, 'btn_submit')]"));
	}

	public void userLogin(String userName, String password) {
		
		getLoginPage().click();
		getUserName().clear();
		getPassword().clear();
		getUserName().sendKeys(userName);
		getPassword().sendKeys(password);
		getLoginButton().click();
	}
}
