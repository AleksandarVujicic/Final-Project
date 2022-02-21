package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Meal_Item_Test extends Basic_Test {

	@Test(priority = 1)
	public void addMealTest() throws InterruptedException {

		locationPopupPage.getCloseButton().click();
		mealPage.addToCart("2");
		Assert.assertTrue(notificationSystemPage.getNotificationErrorMessage().contains("Errors"),
				"[ERROR] 'Please select location' message did not appear.");

		notificationSystemPage.waitForMessageToDisappear();
		locationPopupPage.openPopUpWindow();
		locationPopupPage.setLocation("Helderberg - Albany");
		mealPage.addToCart("3");
		Assert.assertTrue(notificationSystemPage.getNotificationMessage().contains("Meal Added"),
				"[ERROR] 'Meal added to cart' message did not appear.");
	}

	@Test(priority = 2)
	public void addMealToFavoritesTest() {

		locationPopupPage.getCloseButton().click();
		mealPage.getMealsButton().click();
		mealPage.addToFavourite();

		Assert.assertTrue(notificationSystemPage.getNotificationErrorMessage().contains("Please"),
				"[ERROR] Login error message did not appear.");

		loginPage.getLoginButton().click();
		loginPage.userLogin(super.username, super.password);
		driver.navigate().to(baseURL);
		mealPage.getFirstProduct();
		mealPage.addToFavourite();
		Assert.assertTrue(notificationSystemPage.getNotificationMessage().contains("added"),
				"[ERROR] 'Added to favourites' message did not appear.");

	}
//	@Test(priority = 3)
//	public void clearCartTest() throws InterruptedException, IOException {
//		
//		File file = new File("./data/Data.xlsx");
//		FileInputStream fis = new FileInputStream(file);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheet("Meals");
//		DataFormatter formatter = new DataFormatter();
//		
//		mealPage.getMealsButton().click();
//		locationPopupPage.setLocation("City Center - Albany");
//		
//		for (int i = 1; i < 5; i++) {
//			String url = formatter.formatCellValue(sheet.getRow(1).getCell(0));
//			driver.navigate().to(url);
//			mealPage.addToCart("i");
//			softAssert.assertTrue(notificationSystemPage.getNotificationMessage().contains("Added"),
//					"[ERROR] Added to cart message did not appear.");
//		}
//
//		softAssert.assertAll();
//
//		cartSummaryPage.clearCart();
//		Assert.assertTrue(notificationSystemPage.getNotificationMessage().contains("removed"),
//				"[ERROR] Meals removed from the cart message did not appear.");
//
//	}
}
