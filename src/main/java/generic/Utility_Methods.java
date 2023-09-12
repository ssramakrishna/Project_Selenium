package generic;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Utility_Methods implements FrameworkConstants {
	public static WebDriver driver;
	public static WebDriverWait explicitWait;
	public static String URL;
	public static JavascriptExecutor js;
	public static Actions action;
	public static ExtentTest test;
	public static ExtentReports report;
	public static String Name;
	public static String Email;
	public static String Message;
	public static String browserName;

	public String getValueProperty(String key) throws Throwable {
		FileInputStream file = new FileInputStream(PROPERTIES_PATH);
		Properties properties = new Properties();
		properties.load(file);
		return properties.getProperty(key);
	}

	public void initObjects() {
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	public static String name() {
		LocalDateTime sysdate = LocalDateTime.now();
		String name = sysdate.toString().replace(":", "-");
		return name;
	}

	public void clickAction(WebElement element_To_Click) {
		element_To_Click.click();
	}

	public void enter_value(WebElement TextField, String value) {
		TextField.sendKeys(value);
	}

	public String actionReturnText(WebElement mainPageProduct) {
		return mainPageProduct.getText();
	}
}
