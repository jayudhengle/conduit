package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ConduitTestBase {
	private static ConduitTestBase testBase;
	private static WebDriver driver;

	private ConduitTestBase() {
		String strBowser = "chrome";

		if (strBowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (strBowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
	}

	public static void initDriver() {
		if (testBase == null) {
			testBase = new ConduitTestBase();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void openURL(String url) {
		driver.get(url);
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		testBase = null;
	}
}
