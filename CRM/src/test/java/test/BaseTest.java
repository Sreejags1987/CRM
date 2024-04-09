package test;

import org.testng.annotations.Test;

import constants.Constants;
import utility.ElementsUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.apache.commons.io.FileUtils;

public class BaseTest {
	WebDriver driver;
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(@Optional("chrome") String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();//maximize the window
		driver.get(ElementsUtility.getPropertyValue("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));


	}
	@AfterMethod
	public void aftermethod(ITestResult iTestResult) throws IOException {//iTestResult is an interface
		if (iTestResult.getStatus() == ITestResult.FAILURE) {//getStatus method gives whether the TestCase is pass or fail
			takeScreenShotOnFailure(iTestResult.getName());//getName method gives the name of the @Test

		}
		driver.quit();
	}

	public void takeScreenShotOnFailure(String name) throws IOException {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());//datetime stamp,//to set the date format for each screenshot taken
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//takes screenshot
		String destination =Constants.screenShot_path + name + dateName + ".png";//class.variablename plus name of the test case retrived from iTestResult + dateformat
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);


	}
}

