package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ConduitTestBase;
import pages.LoginPage;

public class ConduitTest {
	LoginPage loginPage;
	WebDriver driver;
//	ProductListPage productList;
//	CartPage cartPage;
//	CheckoutPage checkoutPage;

	public ConduitTest() {
		ConduitTestBase.initDriver();
		driver = ConduitTestBase.getDriver();
		loginPage = new LoginPage(driver);
//		productList = new ProductListPage(driver);
//		cartPage = new CartPage(driver);
//		checkoutPage = new CheckoutPage(driver);
	}

	@BeforeTest
	public void setUp() {
		ConduitTestBase.openURL("https://conduit-realworld-example-app.fly.dev/#/login");
		loginPage.logIntoTheApp("TestUser@gmail.com", "Test@123");
	}

	@Test(priority = 1)
	public void porductTest() {
		System.out.println("Helo");
	}

//	@Test(priority = 2)
//	public void verfyItemsTest() {
//		cartPage.verifyItems();
//	}
//
//	@Test(priority = 3)
//	public void checkoutItemsTest() {
//		cartPage.clickCheckoutBtn();
//	}
//
//	@Test(priority = 4)
//	public void checkoutFormTest() {
//		checkoutPage.enterCustomerDetails("abc", "pqr", "11011");
//	}

	@AfterTest
	public void tearDown() {
		ConduitTestBase.tearDown();
	}
}
