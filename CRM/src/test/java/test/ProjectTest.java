package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.LoginPage;
import page.ProjectPage;

public class ProjectTest extends BaseTest{

	@Test(priority=1,groups = { "smoke", "regression" })
	public void verifyCreateProject()throws Exception{
		SoftAssert sa= new SoftAssert();
		LoginPage lg=new LoginPage(driver);
		lg.doLogin("admin@admin.com", "12345678");


		ProjectPage pp=new ProjectPage(driver);
		pp.clickProject();
		pp.doCreateProject("Sreejas CRM Project","Description of CRM Project");
		String actual = pp.doSearchProject("Sreejas CRM Project");
		String expected = "Sreejas CRM Project";
		sa.assertEquals(actual, expected);
		System.out.println("Test 6: The project is created after login");
		sa.assertAll();
	}



	@Test(priority=2, groups = { "regression" })
	public void verifySearchProject()throws Exception{
		SoftAssert sa = new SoftAssert();
		LoginPage lg=new LoginPage(driver);
		lg.doLogin("admin@admin.com", "12345678");
		ProjectPage pp=new ProjectPage(driver);
		pp.clickProject();
		String actual = pp.doSearchProject("Sreejas CRM Project");
		String expected = "Sreejas CRM Project";
		sa.assertEquals(actual, expected);
		sa.assertAll();


	}














}
