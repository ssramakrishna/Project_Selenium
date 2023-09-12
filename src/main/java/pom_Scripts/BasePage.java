package pom_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.Utility_Methods;

public class BasePage extends Utility_Methods{
	
	public BasePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

}
