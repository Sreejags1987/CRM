package test;

import org.testng.annotations.Test;

import constants.Constants;

import page.LoginPage;
import utility.ExcelUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTest extends BaseTest{
	
  @Test(priority = 1,dataProvider = "userData")
  
  public void verifyLogin(String email, String password) throws Exception{
	  
	  LoginPage lg = new LoginPage(driver);
	  String actual=lg.doLogin(email, password);
	  String expectedtext="Dashboard";
	  Assert.assertEquals(actual, expectedtext);
	  System.out.println("Test 1= CRM dashboard is seen visible");
	  
	  
  }
  @DataProvider
  public Object[][] userData() throws Exception {

		Object[][] data = ExcelUtility.getDataFromExcel(Constants.crmtestdata, "Sheet1");

		return data;
	}

}
