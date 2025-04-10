package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ConduitTestBase;
import pages.EditArticePage;
import pages.LoginPage;
import pages.NewArticelTest;

public class ConduitTest {
	LoginPage loginPage;
	WebDriver driver;
	NewArticelTest newArticle;
	EditArticePage editArticle;


	public ConduitTest() {
		ConduitTestBase.initDriver();
		driver = ConduitTestBase.getDriver();
		loginPage = new LoginPage(driver);
		newArticle = new NewArticelTest(driver);
		editArticle = new EditArticePage(driver);
	}

	@BeforeTest
	public void setUp() {
		ConduitTestBase.openURL("https://conduit-realworld-example-app.fly.dev/#/login");
		loginPage.logIntoTheApp("TestUser@gmail.com", "Test@123");
	}

	@Test(priority = 1)
	public void newArticleTest() {
		newArticle.publishArticle("2Test", "Test3", "Test4", "Test5");
	}
	
	@Test(priority = 2)
	public void editArticleTest() {
		editArticle.editArticle("Test31", "Test41", "Test51");
	}



	@AfterTest
	public void tearDown() {
		ConduitTestBase.tearDown();
	}
}
