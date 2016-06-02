package testLibrary;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.pageLibrary;
import utils.Untils;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;

import data.getExcelData;

public class TestSHS {

	Eyes eyes;
	static BatchInfo batchRnC;
	
	@BeforeClass
	public static void setBatch() {
		batchRnC = new BatchInfo("Book's covers SHS");
	}

	@Test(dataProvider = "data")
	//public void test_sachmem(String url, String desc) {
	public void books_covers(String url, String desc) {
		try {

			// open book screen
			Untils.driver.get(url);
			
			eyes.setBaselineName("SHS Baseline 01");
			Untils.driver = eyes.open(Untils.driver, "Sachmem", "SHS Book's cover");
			
			eyes.setForceFullPageScreenshot(true);

			eyes.setMatchTimeout(15);

			eyes.checkWindow("SHS TiengAnh6 Tap2");
			eyes.setMatchLevel(MatchLevel.STRICT);
			Thread.sleep(3000);
			eyes.close();

			// Verify icons if display
			Assert.assertTrue(Untils.driver.findElement(pageLibrary.image_library)
					.isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(pageLibrary.icon)
					.isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(pageLibrary.right_bar)
					.isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(pageLibrary.book_type)
					.isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(pageLibrary.nxb_infor)
					.isDisplayed());

			

		} catch (Exception e) {

		} finally {
			eyes.abortIfNotClosed();
			Untils.driver.quit();
		}
	}

	@DataProvider(name = "data")
	public Object[][] testData() throws Exception {
		return getExcelData.getDataFromExcel(Untils.FILE_PATH_SHS,
				Untils.SHEET_NAME, Untils.TABLE_NAME);
	}

	@BeforeMethod
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", Untils.CHROME_PATH);
		Untils.driver = new ChromeDriver();
		Untils.driver.manage().window().maximize();
		Untils.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		eyes = new Eyes();
		// User your own api key, make sure you use it in all your tests
		eyes.setApiKey("R75xl6coBNGw2vcdLk100RpYPt1064PYwIHUejYrXiO5vC0110");
		eyes.setBatch(batchRnC);
	}

	@AfterMethod
	public void afterTest() {
		eyes.abortIfNotClosed();
	}

}
