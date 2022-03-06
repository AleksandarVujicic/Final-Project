package Tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import Pages.Auth_Page;
import Pages.Basic_Page;
import Pages.Cart_Summary_Page;
import Pages.Location_Popup_Page;
import Pages.Login_Page;
import Pages.Meal_Page;
import Pages.Notification_System_Page;
import Pages.Profile_Page;
import Pages.Search_Result_Page;

public abstract class Basic_Test {

	protected WebDriver driver;
	protected SoftAssert softAssert;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected Auth_Page authPage;
	protected Basic_Page basicPage;
	protected Cart_Summary_Page cartSummaryPage;
	protected Location_Popup_Page locationPopupPage;
	protected Login_Page loginPage;
	protected Meal_Page mealPage;
	protected Notification_System_Page notificationSystemPage;
	protected Profile_Page profilePage;
	protected Search_Result_Page searchResultPage;
	protected String baseURL = "http://demo.yo-meals.com/";
	protected String username = "customer@dummyid.com";
	protected String password = "12345678a";

	@SuppressWarnings("deprecation")
	@BeforeMethod

	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().to(baseURL);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		softAssert = new SoftAssert();

		authPage = new Auth_Page(driver, js, wait);
		cartSummaryPage = new Cart_Summary_Page(driver, js, wait);
		locationPopupPage = new Location_Popup_Page(driver, js, wait);
		loginPage = new Login_Page(driver, js, wait);
		mealPage = new Meal_Page(driver, js, wait);
		notificationSystemPage = new Notification_System_Page(driver, js, wait);
		profilePage = new Profile_Page(driver, js, wait);
		searchResultPage = new Search_Result_Page(driver, js, wait);
	}

	@AfterMethod

	public void afterMethod(ITestResult result) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		String dateFormatted = sdf.format(date);

		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
				File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(sourceFile, new File("./screenshots/" + dateFormatted + ".png"));
				System.out.println("Screenshot taken!");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage() + "!");
			}
		}

		driver.quit();
	}

}
