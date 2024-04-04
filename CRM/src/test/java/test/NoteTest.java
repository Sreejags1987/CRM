package test;

import org.testng.annotations.Test;
import page.LoginPage;
import page.NotePage;
import utility.FakerUtility;
import org.testng.Assert;
public class NoteTest extends BaseTest{
	
  @Test(priority = 1, retryAnalyzer = generaltests.Retry.class, groups = { "smoke", "regression" })
  public void verifyCreateNote()throws Exception{
	  
	  LoginPage lg=new LoginPage(driver);
	  String actual=lg.doLogin("admin@admin.com", "12345678");
	  String expected = "Dashboard";
	  Assert.assertEquals(actual, expected);
	  NotePage np=new NotePage(driver);
	  np.clickOnNote();
	  np.doCreateNote("SreejaTest",FakerUtility.emailID());
	  String expectednote = "SreejaTest";
	  np.clickOnNote();
	  String actualnote=np.doSearchNote("SreejaTest");
	  Assert.assertEquals(actualnote, expectednote);
  }
  @Test(priority = 2, groups = { "regression" })
  public void verifySearchNote()throws Exception{
	  LoginPage lg = new LoginPage(driver);
	  lg.doLogin("admin@admin.com", "12345678");
	  NotePage np = new NotePage(driver);
	  np.clickOnNote();
	  String actual2 = np.doSearchNote("SreejaTest");
	  String expected2 = "SreejaTest";
	  Assert.assertEquals(actual2, expected2);
	  System.out.println("Test 3 = Searched the entered note");
	  
  }
  @Test(priority = 2, groups = { "smoke", "regression" })
  public void verifyEditNote()throws Exception{
	  LoginPage lg = new LoginPage(driver);
	  lg.doLogin("admin@admin.com", "12345678");
	  NotePage np = new NotePage(driver);
	  np.clickOnNote();
	  np.doSearchNote("SreejaTest");
      np.doEditNote("Sreejas Edited Text");
	  np.clickOnNote();
	  String actual = np.doSearchNote("Sreejas Edited Text");
	  String expected = "Sreejas Edited Text";
	  Assert.assertEquals(actual, expected);
	  System.out.println("Test 4 = Edited the entered note to a new note ");
	  
  }
  @Test(priority = 2, groups = { "smoke", "regression" })
  public void verifyDeleteNote()throws Exception{
	  LoginPage lg = new LoginPage(driver);
	  lg.doLogin("admin@admin.com", "12345678");
	  NotePage np = new NotePage(driver);
	  np.clickOnNote();
	  np.doSearchNote("Sreejas Edited Text");
	  np.doDeleteNote();
	  
	  
	  
  }
  
	  
	  
	  	
	  
  }
  
  
  


