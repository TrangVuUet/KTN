package pageObjects;

import org.openqa.selenium.By;

public class pageRnM {
	
	//title content
	public static By title_content = By.cssSelector("#title_content");
	//skill icon
	public static By skill_icon = By.cssSelector("#skills_icon>img"); // 2 phan tu
	//space box
	public static By space_box = By.cssSelector(".drop.ui-droppable");
	//answer box
	public static By anwser_box = By.cssSelector(".drag.ng-scope.ui-draggable.ui-draggable-handle.ui-droppable"); 
	//index line
	public static By index_line = By.cssSelector(".index-number.width-xs-5.ng-binding");
	//text line
	public static By text_line = By.cssSelector(".width-xs-95.ng-binding");
}
