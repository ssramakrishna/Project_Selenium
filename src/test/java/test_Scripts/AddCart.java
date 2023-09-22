package test_Scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.Base_Class;
import generic.Read_Excel;
import pom_Scripts.AddCart_POM;
import pom_Scripts.LoginPage;
import pom_Scripts.WelcomePage;

public class AddCart extends Base_Class {

	@Test(dataProvider = "testdata")
	public void addCartMethod(String email, String pwd) throws IOException, InterruptedException {

		WelcomePage Wp = new WelcomePage(driver);
		Wp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		lp.enterValueInEmail(email);
		lp.enterValueInPwd(pwd);
		
		lp.clickLoginButton();

		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		int y = driver.findElement(By.xpath("(//a[@href='/25-virtual-gift-card'])[4]")).getLocation().getY();
		j.executeScript("window.scrollBy(0," + y + ")");

		AddCart_POM c = new AddCart_POM(driver);
		
		String mainPageProduct = c.mainPageProductName();
		System.out.println("mainPageProductName: " + mainPageProduct);

		c.addButton();
		c.recipientName();
		c.recipientEmail();
		c.messageToRecipent();
		
//		// JavascriptExecutor k = (JavascriptExecutor) driver;
//		// int x =
//		// driver.findElement(By.xpath("//input[@id='addtocart_2_EnteredQuantity']]")).getLocation().getY();
//		// k.executeScript("window.scrollBy(0,"+x+")");
//		//
//		// driver.findElement(By.xpath("//input[@id='addtocart_2_EnteredQuantity']]")).clear();
//		// driver.findElement(By.xpath("//input[@class='qty-input
//		// valid']")).sendKeys("2");
//
		c.button2();
		System.out.println("Added to cart");
		c.cart2();

		String addedProduct = c.addedProductName();
		System.out.println("Added product name:  " + addedProduct);

		if (mainPageProduct.equals(addedProduct)) {
			System.out.println("mainPageProductName" + "and" + "addedProductName" + "are SAME");

		} else {
			System.out.println("NOT SAME");
		}
		System.out.println("Done");

		System.out.println("LOGGING OUT WITHIN 2 SEC");
		
		System.out.println("Ram");

	}

	@DataProvider(name = "testdata")
	public Object[][] getTestData() throws IOException {
		Object[][] testdata = Read_Excel.getMultipleData("Sheet1");
		return testdata;
	}
}
