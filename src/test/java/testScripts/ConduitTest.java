package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ConduitTestBase;
import pages.*;
import pages.EditArticlePage;

import java.time.Duration;

public class ConduitTest {
	LoginPage loginPage;
	WebDriver driver;
	NewArticelTest newArticle;
	EditArticlePage editArticle;
	DeleteArticlesPage deleteArticle;
	WebDriverWait wait;

	public ConduitTest() {
		ConduitTestBase.initDriver();
		driver = ConduitTestBase.getDriver();
		loginPage = new LoginPage(driver);
		newArticle = new NewArticelTest(driver);
		editArticle = new EditArticlePage(driver);
		deleteArticle = new DeleteArticlesPage(driver);
	}

	@BeforeTest
	public void setUp() {
		ConduitTestBase.openURL("https://conduit-realworld-example-app.fly.dev/#/login");
		loginPage.logIntoTheApp("TestUser@gmail.com", "Test@123");
	}

	@Test(priority = 1)
	public void newArticleTest() throws InterruptedException {
		newArticle.publishArticle("7331Test", "Test3", "Test4", "Test5");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//h1")));
		WebElement title = driver.findElement(By.xpath("//div//h1"));
		Assert.assertEquals(title.getText(), "7331Test");
	}
	
	@Test(priority = 2)
	public void editArticleTest() throws InterruptedException {
		editArticle.editArticle("721Test", "Test41", "Test51", "Test51");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//h1")));
		WebElement title = driver.findElement(By.xpath("//div//h1"));
		Assert.assertEquals(title.getText(), "721Test");
	}

	@Test(priority = 3)
	public void deleteArticleTest() throws InterruptedException {
		deleteArticle.deleteArticle();
		try
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		catch (Exception e)
		{
			System.out.println("No alert Found!!");
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text() , 'Articles')]")));
		String message = driver.findElement(By.xpath("//div[contains(text() , 'Articles')]")).getText();
		Assert.assertEquals(message, "Articles not available.");
	}


	@AfterTest
	public void tearDown() {
		ConduitTestBase.tearDown();
	}
}
