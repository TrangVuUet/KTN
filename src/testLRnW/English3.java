package testLRnW;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.pageCommon;
import pageObjects.pageLRnW;
import pageObjects.pageLogin;
import utils.Untils;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;

import data.getExcelData;

public class English3 {

	Eyes eyes;
	static BatchInfo batchRnC;

	@BeforeClass
	public static void setBatch() {
		batchRnC = new BatchInfo("Look, Read and Write");
	}


	@Test(dataProvider = "data")
	public void test_sachmem(String url, String desc) {
		try {

			// open the lesson screen
			Untils.driver.get(url);

			pageLogin.login("trangvuuet@gmail.com", "Trang1912");

			// set the Baseline image
			eyes.setBaselineName("LRnW 01");

			Untils.driver = eyes.open(Untils.driver, "Sachmem", "Look Read n Write");

			eyes.setForceFullPageScreenshot(true);
			eyes.setMatchTimeout(15);

			// baseline neu chay lan dau
			eyes.checkWindow("LRnW 1");
			eyes.setMatchLevel(MatchLevel.STRICT);

			eyes.close();

			/* check if image is missing */
			List<WebElement> list_img = new ArrayList<WebElement>();
			list_img = Untils.driver.findElements(pageLRnW.all_img);
			for (int index = 0; index < list_img.size(); index++) {
				Assert.assertTrue(list_img.get(index).isDisplayed());
			}

			/* check if text is missing */
			List<WebElement> list_txtDesc = new ArrayList<WebElement>();
			list_img = Untils.driver.findElements(pageLRnW.all_txtDesc);
			for (int index = 0; index < list_txtDesc.size(); index++) {
				Assert.assertTrue(list_txtDesc.get(index).isDisplayed());
			}

			// check icons if display
			Assert.assertTrue(Untils.driver.findElement(pageCommon.add_btn)
					.isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(pageCommon.check_btn)
					.isDisplayed());
			Assert.assertTrue(Untils.driver
					.findElement(pageCommon.glossary_btn).isDisplayed());
			Assert.assertTrue(Untils.driver
					.findElement(pageCommon.previous_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(pageCommon.next_btn)
					.isDisplayed());

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
		// driver.manage().window().maximize();

		eyes = new Eyes(); // create a control object
		eyes.setApiKey("R75xl6coBNGw2vcdLk100RpYPt1064PYwIHUejYrXiO5vC0110");
		eyes.setBatch(batchRnC);
	}

	@AfterMethod
	public void afterTest() {
		eyes.abortIfNotClosed();
	}

	@DataProvider(name = "data")
	public Object[][] testData() throws Exception {
		return getExcelData.getDataFromExcel(Untils.FILE_PATH_LRnW,
				Untils.SHEET_NAME, Untils.TABLE_NAME);
	}

}
