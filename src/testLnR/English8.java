package testLnR;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.pageLogin;
import utils.Untils;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;

import data.getExcelData;

public class English8 {

	Eyes eyes;
	static BatchInfo batchRnC;

	@BeforeClass
	public static void setBatch() {
		batchRnC = new BatchInfo("Listen and Read");
	}
	
	
	@Test(dataProvider = "data")
	public void test_sachmem(String url, String desc) {
		try {

			Untils.driver.get(url);
			pageLogin.login("trangvuuet@gmail.com", "Trang1912");
			eyes.setBaselineName("RnW 01");

			Untils.driver = eyes.open(Untils.driver, "Sachmem", "Read and Write");

			eyes.setForceFullPageScreenshot(true);
			eyes.setMatchTimeout(15);

			// baseline neu chay lan dau
			eyes.checkWindow("RnW 1");
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
		//Untils.driver.manage().window().maximize();
		Untils.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
		return getExcelData.getDataFromExcel(Untils.FILE_PATH_RnW,
				Untils.SHEET_NAME, Untils.TABLE_NAME);
	}

}
