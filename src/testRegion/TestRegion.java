package testRegion;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.pageLogin;
import utils.Untils;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;

public class TestRegion {

	Eyes eyes;

	@Test 
	public void test_region() {
		try {

			// open the lesson screen
			Untils.driver.get("https://www.sachmem.vn/books/1/exercises/1086");

			pageLogin.login("trangvuuet@gmail.com", "Trang1912");

			// set the Baseline image
			eyes.setBaselineName("Region English3-SHS-Tap1");

			Untils.driver = eyes.open(Untils.driver, "Sachmem", "Region");
			//Untils.driver.findElement(By.cssSelector(".suggestion-wrapper.ng-scope"));
			eyes.checkRegion(By.cssSelector(".suggestion-wrapper.ng-scope"));
			eyes.setMatchLevel(MatchLevel.STRICT);

			eyes.close();

		} catch (Exception e) {

		} finally {
			eyes.abortIfNotClosed();
			Untils.driver.quit();
		}
	}

	@BeforeMethod
	public void beforeTest() {

		Untils.driver = new FirefoxDriver();

		Untils.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Untils.driver.manage().window().maximize();

		eyes = new Eyes(); // create a control object
		eyes.setApiKey("R75xl6coBNGw2vcdLk100RpYPt1064PYwIHUejYrXiO5vC0110");
	}

	@AfterMethod
	public void afterTest() {
		eyes.abortIfNotClosed();
	}

}
