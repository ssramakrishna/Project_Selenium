package pom_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Utility_Methods;

public class AddCart_POM extends BasePage {

	public AddCart_POM(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//a[@href='/25-virtual-gift-card'])[4]")
	WebElement mainPageProduct;

	public String mainPageProductName() {
		return actionReturnText(mainPageProduct);
	}

	@FindBy(xpath = "(//input[@class='button-2 product-box-add-to-cart-button'])[1]")
	WebElement addButton1;

	public void addButton() {
		clickAction(addButton1);
	}

	@FindBy(id = "giftcard_2_RecipientName")
	WebElement recipientName1;
	

	public void recipientName() {
		enter_value(recipientName1, Name);
	}
	
	
	@FindBy(xpath = "//input[@class='recipient-email']")
	WebElement recipientEmail1;

	public void recipientEmail() {
		enter_value(recipientEmail1, Email);
	}
	
	
	@FindBy(xpath = "//textarea[@class='message']")
	WebElement messageToRecipent1;

	public void messageToRecipent() {
		enter_value(messageToRecipent1, Message);
	}
	
	
	@FindBy(xpath = "//input[@id='add-to-cart-button-2']")
	WebElement button21;

	public void button2() {
		clickAction(button21);
	}
	
	
	
	@FindBy(xpath = "(//a[@class='ico-cart'])[2]")
	WebElement cart21;

	public void cart2() {
		clickAction(cart21);
	}
	
	
	@FindBy(xpath = "//a[@class='product-name']")
	WebElement addedProductName1;
	
	public String addedProductName() {
		return actionReturnText(addedProductName1);
	}
	
	
	
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logout1;

	public void logout() {
		clickAction(logout1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
