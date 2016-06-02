package testLnW_raw;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.pageCommon;
import pageObjects.pageLnWEnglish3;
import pageObjects.pageLogin;
import utils.Untils;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;

import data.getExcelData;

public class LnWEnglish3 {

	Eyes eyes;

	@Test (dataProvider = "data") //String url, String desc. Tao baseline
	public void test_sachmem() {
		try {

			// open the lesson screen
			Untils.driver.get("https://www.sachmem.vn/books/1/exercises/404");

			pageLogin.login("trangvuuet@gmail.com", "Trang1912");

			// set the Baseline image
			eyes.setBaselineName("LnW English3 -01");

			Untils.driver = eyes.open(Untils.driver, "Sachmem", "Look n Write");

			eyes.setForceFullPageScreenshot(true);
			eyes.setMatchTimeout(15);

			// baseline neu chay lan dau
			eyes.checkWindow("LnW 01");
			eyes.setMatchLevel(MatchLevel.STRICT);

			eyes.close();

			// check if image center and blank inside, icons, menu display
			Assert.assertTrue(Untils.driver.findElement(
					pageLnWEnglish3.center_img).isDisplayed());
			Assert.assertTrue(Untils.driver
					.findElement(pageCommon.add_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageLnWEnglish3.play_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageCommon.check_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageCommon.glossary_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageCommon.previous_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageCommon.next_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageCommon.unit_menu).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageLnWEnglish3.index_line).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageLnWEnglish3.exist_text).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageCommon.lesson_name).isDisplayed());

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

	@DataProvider(name = "data")
	public Object[][] testData() throws Exception {
		return getExcelData.getDataFromExcel(Untils.FILE_PATH_LnW,
				Untils.SHEET_NAME, Untils.TABLE_NAME);
	}

}
