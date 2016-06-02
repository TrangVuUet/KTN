package pageObjects;

import org.openqa.selenium.By;

public class pageLnWEnglish3 {
	
	// Type of lesson: Look and Write - English 3
	
	// center image
	public static By center_img = By.xpath(".//*[@id='exercise-content']/div[1]/div/div/div");
	// play _btn
	public static By play_btn = By.cssSelector("#play>img");
	// index of text line + blank space
	public static By index_line = By.xpath(".//*[@id='exercise-content']/div[1]/div/div/div/div//span[1]");
	//text exist
	public static 	By exist_text = By.xpath(".//*[@id='exercise-content']/div[1]/div/div/div/div//span[2]");
	
}
