package test_Scripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Class;
import generic.Read_Excel;
import pom_Scripts.LoginPage;
import pom_Scripts.WelcomePage;

public class TestScript_1 extends Base_Class {

	@Test(dataProvider = "testdata")
	public void testScript1(String email, String pwd) throws IOException, InterruptedException {

		WelcomePage Wp = new WelcomePage(driver);
		Wp.clickLogin();
		Thread.sleep(2000);

		LoginPage lp = new LoginPage(driver);
		lp.enterValueInEmail(email);
		lp.enterValueInPwd(pwd);

//		test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));
//		s
		lp.clickLoginButton();
//		
		test.log(LogStatus.INFO, "User is logged in");
	}

	@DataProvider(name = "testdata")
	public Object[][] getTestData() throws IOException {
		Object[][] testdata = Read_Excel.getMultipleData("Sheet1");
		return testdata;
	}
}
