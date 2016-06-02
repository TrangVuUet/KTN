package pageObjects;

import org.openqa.selenium.By;

public class pageLibrary {
	//library
	public static By image_library = By.cssSelector(".attachment-post-thumbnail.size-post-thumbnail.wp-post-image");
	//icon
	public static By icon = By.cssSelector(".chp-page-title-icon");
	//search box
	public static By search_box = By.cssSelector("#s");
	//right bar
	public static By right_bar = By.xpath("html/body/div[3]/div[4]/div[2]");
	//nxb_infor
	public static By nxb_infor = By.cssSelector(".one.whole.double-gap-bottom>p"); //nxb, nam xb
	//type book
	public static By book_type = By.cssSelector(".entry-subtitle.ch-border-title");
	
}
