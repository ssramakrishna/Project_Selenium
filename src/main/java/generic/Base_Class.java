package generic;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class extends Utility_Methods {

	@BeforeSuite
	public void beforeSuit() {
		report = new ExtentReports(REPORTS_PATH + name() + ".html");
		test = report.startTest(TEST_NAME);
	}

	@BeforeClass
	public void browserSetup() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

//		System.out.println("Enter browser name: chrome or firefox");
//		Scanner sc = new Scanner(System.in);
//		String browser = sc.nextLine();
//
//		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			test.log(LogStatus.INFO, "Browser is launched");
//			
//			/*
//			 * System.setProperty(CHROME_KEY,CHROME_PATH); driver=new ChromeDriver();
//			 * Reporter.log("Successfully Launched Chrome Browser",true);
//			 */
//		} else if (browser.equalsIgnoreCase("firefox")) {
//
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			test.log(LogStatus.INFO, "Browser is launched");
//
//			/*
//			 * System.setProperty(FIREFOX_KEY,FIREFOX_PATH); driver=new FirefoxDriver();
//			 * Reporter.log("Successfully Launched Firefox Browser",true);
//			 */
//		} else {
//			Reporter.log("Enter valid Browser name");
//		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		URL = getValueProperty("URL");
		Name = getValueProperty("Name");
		Email = getValueProperty("Email");
		Message = getValueProperty("Message");

		driver.get(URL);
		initObjects();
	}

	@AfterClass
	public void CloseApp() {
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		report.endTest(test);
		report.flush();
	}
}
