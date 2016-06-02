package temp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.pageLogin;
import utils.Untils;

public class Test {
	public static void main(String args[]) throws InterruptedException {

		Untils.driver = new FirefoxDriver();
		Untils.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Untils.driver.get("https://www.sachmem.vn/books/5/exercises/1110");
		pageLogin.login("trangvuuet@gmail.com", "Trang1912");

		WebElement txt = Untils.driver.findElement(By
				.xpath(".//*[@id='drag_drop_container']/div[2]/div[3]/div"));
		String textWidth = txt.getCssValue("font-size");
		System.out.println(textWidth);
		
		System.out
		.println(Untils.driver
				.findElement(
						By.xpath(".//*[@id='drag_drop_container']/div[2]/div[1]/div"))
				.getText());

		System.out
				.println(Untils.driver
						.findElement(
								By.xpath(".//*[@id='drag_drop_container']/div[2]/div[1]/div"))
						.getText().length());

	}
}
