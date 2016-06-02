package testRnM;

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
import pageObjects.pageLogin;
import pageObjects.pageRnM;
import utils.Untils;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;

import data.getExcelData;

public class RnMsbt {

	Eyes eyes;
	static BatchInfo batchRnC;

	@BeforeClass
	public static void setBatch() {
		batchRnC = new BatchInfo("Read and Match");
	}

	@Test(dataProvider = "data") //String url, String desc. Tao baseline
	public void test_sachmem(String url, String desc) {
		try {

			// open the lesson screen
			Untils.driver.get(url);

			pageLogin.login("trangvuuet@gmail.com", "Trang1912");

			// set the Baseline image
			eyes.setBaselineName("RnM English3,4 SBT - 02");

			Untils.driver = eyes.open(Untils.driver, "Sachmem", "Read and Match 3,4 02");

			eyes.setForceFullPageScreenshot(true);
			eyes.setMatchTimeout(15);

			// baseline neu chay lan dau
			eyes.checkWindow("RnM 02");
			eyes.setMatchLevel(MatchLevel.STRICT);

			eyes.close();

			// check icons if display
			Assert.assertTrue(Untils.driver
					.findElement(pageCommon.add_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageCommon.check_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageCommon.glossary_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageCommon.previous_btn).isDisplayed());
			Assert.assertTrue(Untils.driver.findElement(
					pageCommon.next_btn).isDisplayed());
			
			/* check space box and text box and text line if they areequals and they display */
			List<WebElement> list_space_box = new ArrayList<WebElement>();
			List<WebElement> list_answer_box = new ArrayList<WebElement>();
			List<WebElement> list_index_line = new ArrayList<WebElement>();
			List<WebElement> list_text_line = new ArrayList<WebElement>();
			
			// compare number of space boxes and anwser boxes
			Assert.assertTrue(list_answer_box.size() == list_space_box.size());
			Assert.assertTrue(list_index_line.size() == list_text_line.size());
			
			// check list space box if display
			list_space_box = Untils.driver.findElements(pageRnM.space_box);
			for (int index =0; index <list_space_box.size(); index++) {
				Assert.assertTrue(list_space_box.get(index).isDisplayed());
			}
			
			// check list of answer box if display
			list_answer_box = Untils.driver.findElements(pageRnM.anwser_box);
			for (int index =0; index <list_answer_box.size(); index++) {
				Assert.assertTrue(list_answer_box.get(index).isDisplayed());
			}
			
			// check list of index line if display
			list_index_line = Untils.driver.findElements(pageRnM.index_line);
			for (int index =0; index <list_index_line.size(); index++) {
				Assert.assertTrue(list_index_line.get(index).isDisplayed());
			}
			
			// check list of text line if display
			list_text_line = Untils.driver.findElements(pageRnM.anwser_box);
			for (int index =0; index <list_text_line.size(); index++) {
				Assert.assertTrue(list_text_line.get(index).isDisplayed());
			}

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
		eyes.setBatch(batchRnC);
	}

	@AfterMethod
	public void afterTest() {
		eyes.abortIfNotClosed();
	}

	@DataProvider(name = "data")
	public Object[][] testData() throws Exception {
		return getExcelData.getDataFromExcel(Untils.FILE_PATH_RnM,
				Untils.SHEET_NAME, Untils.TABLE_NAME);
	}

}
