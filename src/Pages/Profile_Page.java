package Pages;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile_Page extends Basic_Page {

	public Profile_Page(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);

	}

	public WebElement getFirstName() {
		return driver.findElement(By.xpath("//*[@name='user_first_name']"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.xpath("//*[@name='user_last_name']"));
	}

	public WebElement getAddress() {
		return driver.findElement(By.xpath("//*[@name='user_address']"));
	}

	public WebElement getPhoneNumber() {
		return driver.findElement(By.xpath("//*[@name='user_phone']"));
	}

	public WebElement getZipCode() {
		return driver.findElement(By.xpath("//*[@name='user_zip']"));
	}

	public WebElement getCountry() {
		return driver.findElement(By.id("user_country_id"));
	}

	public void setCountry(String selectCountry) {
		getCountry().click();
		Select country = new Select(getCountry());
		country.selectByVisibleText(selectCountry);
	}

	public WebElement getState() {
		return driver.findElement(By.id("user_state_id"));
	}

	public void setState(String selectState) {
		getCountry().click();
		Select country = new Select(getState());
		country.selectByVisibleText(selectState);
	}

	public WebElement getCity() {
		return driver.findElement(By.id("user_city"));
	}

	public void setCity(String selectCity) {
		getCity().click();
		Select country = new Select(getCity());
		country.selectByVisibleText(selectCity);
	}

	public WebElement getSaveInformation() {
		return driver.findElement(
				By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-lg-12 align--right']/fieldset/input"));
	}

	public void scrollIntoViewSave1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView;", getSaveInformation());

	}

	public void editProfile1(String firstName, String lastName, String phoneNumber, String address, String zipCode,
			String selectCountry, String selectState, String selectCity) throws InterruptedException {
//		scrollIntoViewSave1();
		getFirstName().clear();
		getFirstName().sendKeys(firstName);
		getLastName().clear();
		getLastName().sendKeys(lastName);
		getPhoneNumber().clear();
		getPhoneNumber().sendKeys(phoneNumber);
		getAddress().clear();
		getAddress().sendKeys(address);
		getZipCode().clear();
		getZipCode().sendKeys(zipCode);
		setCountry(selectCountry);
		setState(selectState);
		Thread.sleep(500);
		setCity(selectCity);
		Thread.sleep(1000);
		getSaveInformation().click();
	}

	public WebElement getCurrentPassword() {
		return driver.findElement(By.xpath("//*[@name='current_password']"));
	}

	public WebElement getNewPassword() {
		return driver.findElement(By.xpath("//*[@name='new_password']"));
	}

	public WebElement getConfirmPassword() {
		return driver.findElement(By.xpath("//*[@name='conf_new_password']"));
	}

	public WebElement getSavePassword() {
		return driver.findElement(
				By.xpath("//div[@class='col-lg-3 col-md-3 col-sm-3 col-lg-12  align--right']/fieldset/input"));
	}

	public void editPassword(String currentPassword, String newPassword, String confirmNewPassword) {
		getCurrentPassword().clear();
		getCurrentPassword().sendKeys(currentPassword);
		getNewPassword().clear();
		getNewPassword().sendKeys(newPassword);
		getConfirmPassword().clear();
		getConfirmPassword().sendKeys(confirmNewPassword);
		getSavePassword().click();
	}

	public WebElement getUploadIcon() {
		return driver.findElement(By.xpath("//*[contains(@class, 'upload uploadFile-Js')]"));
	}

	public WebElement getRemoveIcon() {
		return driver.findElement(By.xpath("//*[contains(@class, 'remove')]"));
	}

	public void deleteProfilePicture() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getRemoveIcon());
	}

	public void uploadPhoto(String pathToThePicture) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		File profilePhoto = new File(pathToThePicture);
		js.executeScript("arguments[0].click();", getUploadIcon());
		WebElement profilePhotoUpload = driver.findElement(By.name("file"));
		profilePhotoUpload.sendKeys(profilePhoto.getAbsolutePath());
		Thread.sleep(3000);
	}
}
