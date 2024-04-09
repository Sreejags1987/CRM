package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ElementsUtility;
import utility.WaitUtility;

public class LoginPage {
	WebDriver driver;
	WaitUtility uwait;
	ElementsUtility eutility;


	@FindBy(name="email")
	WebElement emailfield;

	@FindBy(name="password")
	WebElement passwordfield;

	@FindBy(xpath="//button[@type='submit']")
	WebElement Signin;

	@FindBy(xpath="//span[text()='Dashboard']")
	WebElement dashboardpage;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);//Initialize elements declared using @FindBy
		uwait = new WaitUtility(driver);
		eutility = new ElementsUtility(driver);
	}

	public String doLogin(String email, String password)throws Exception{
		uwait.waitForVisibility(emailfield);
		emailfield.sendKeys(email);
		uwait.waitForVisibility(passwordfield);
		passwordfield.sendKeys(password);
		uwait.waitForElementClick(Signin);
		Signin.click();
		String actualtext=dashboardpage.getText();	
		return actualtext;




	}



}
