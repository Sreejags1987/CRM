package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.ClientPage;
import page.LoginPage;
import utility.FakerUtility;

public class ClientTest extends BaseTest{
	@Test(priority=1)
	public void verifyAddClients() throws Exception{

		LoginPage lg=new LoginPage(driver);
		String actual=lg.doLogin("admin@admin.com", "12345678");
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected);
		ClientPage cp = new ClientPage(driver);
		cp.clickOnClientsLink();
		cp.clickOnAddClients();
		String actual1=cp.enterClientDetails("TechSolutions", "Technopark,Trivandrum", "Trivandrum", "Kerala","695582", "India", FakerUtility.phoneNumber(), "www.techsolutions.com", "GB123456789", "USD", "$");
		String expected1="TechSolutions";
		Assert.assertEquals(actual, expected1);
		System.out.println("Test 9 : The client is newly created and added in the page");
	}
	@Test(priority=2)
	public void searchCreatedClient() throws Exception{

		LoginPage lp = new LoginPage(driver);
		lp.doLogin("admin@admin.com", "12345678");

		ClientPage cp = new ClientPage(driver);
		cp.clickOnClientsLink();
		String actual=cp.searchClient("TechSolutions");
		String expected="TechSolutions";
		Assert.assertEquals(actual, expected);
		System.out.println("Test 10 : The created client is searched and verified in the page");
	}
}





