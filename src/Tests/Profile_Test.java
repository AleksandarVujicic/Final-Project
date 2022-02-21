package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Profile_Test extends Basic_Test {

	@Test(priority = 1)
	public void editProfileTest() throws InterruptedException {

		loginPage.openLoginPage();
		locationPopupPage.getCloseButton().click();
		loginPage.userLogin("customer@dummyid.com", "12345678a");
		Assert.assertTrue(notificationSystemPage.getNotificationMessage().contains("Login Successfull"),
				"[ERROR] Login message not visible.");
		driver.navigate().to(super.baseURL + "/member/profile");
		profilePage.editProfile1("Aleksandar", "Vujicic", "0695199309", "Njegoseva 11", "34220", "United States", "Alo",
				"Poi");
		authPage.logout();
		Assert.assertTrue(notificationSystemPage.getNotificationMessage().contains("Logout Successfull!"),
				"[ERROR] Logout message not visible.");

	}
	@Test(priority = 2)
	public void changeProfileImageTest() throws InterruptedException {
		
		loginPage.openLoginPage();
		locationPopupPage.getCloseButton().click();
		loginPage.userLogin("customer@dummyid.com", "12345678a");
		Assert.assertTrue(notificationSystemPage.getNotificationMessage().contains("Login Successfull"),
				"[ERROR] Login message not visible.");
		driver.navigate().to(super.baseURL + "/member/profile");
		profilePage.uploadPhoto("img/pexels-pixabay-38289.jpg");
		Assert.assertTrue(notificationSystemPage.getNotificationMessage().contains("Profile Image Uploaded Successfully"),
				"[ERROR] Upload message not visible.");
		notificationSystemPage.waitForMessageToDisappear();
		profilePage.deleteProfilePicture();
		Assert.assertTrue(notificationSystemPage.getNotificationMessage().contains("Profile Image Deleted Successfully"),
				"[ERROR] 'Profile Image Deleted' message not visible.");
		authPage.logout();
		Assert.assertTrue(notificationSystemPage.getNotificationMessage().contains("Logout Successfull!"),
				"[ERROR] Logout message not visible.");
	}
}
