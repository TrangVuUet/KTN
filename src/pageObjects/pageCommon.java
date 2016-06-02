package pageObjects;

import org.openqa.selenium.By;

public class pageCommon {
	
		// add btn
		public static By add_btn = By.cssSelector("#addition_button");
		// glossary btn
		public static By glossary_btn = By.cssSelector("#tool-bar-glossary>a>img");
		//check btn
		public static By check_btn = By.cssSelector("#lets_check>img");
		// previous_btn
		public static By previous_btn = By.cssSelector("#tool-bar-back>a>img");
		//next_btn
		public static By next_btn = By.cssSelector("#tool-bar-forward>a>img");
		// unit menu
		public static By unit_menu = By.cssSelector("#units-menu>img");
		//lesson name
		public static By lesson_name = By.cssSelector(".lessons-name>p");
}
