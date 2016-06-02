package pageObjects;

import org.openqa.selenium.By;

import utils.Untils;

public class pageLogin {
	public static By email = By.cssSelector("#user_email");
	public static By passwrd = By.cssSelector("#user_password");
	public static By confirm_btn = By.cssSelector(".btn.btn-primary");
	
	public static void login( String name, String pass) throws InterruptedException {
		Untils.driver.findElement(pageLogin.email).sendKeys(
				"trangvuuet@gmail.com");
		Untils.driver.findElement(pageLogin.passwrd).sendKeys("Trang1912");
		Untils.driver.findElement(pageLogin.confirm_btn).click();
		Thread.sleep(5000);
	}
}
