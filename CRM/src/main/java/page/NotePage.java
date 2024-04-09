package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ElementsUtility;
import utility.WaitUtility;


public class NotePage {
	WebDriver driver;
	WaitUtility uwait;
	ElementsUtility eutility;

	@FindBy(name="email")
	WebElement emailfield;

	@FindBy(name="password")
	WebElement passwordfield;

	@FindBy(xpath="//button[@type='submit']")
	WebElement Signin;

	@FindBy(xpath="//span[text()='Notes']")
	WebElement notesmenu;

	@FindBy(xpath="//a[@class='btn btn-default' and @title='Add note']")
	WebElement addnotebutton;

	@FindBy(xpath="//input[@id='title']")
	WebElement titlefield;

	@FindBy(xpath="//textarea[@id='description']")
	WebElement descriptionfield;

	@FindBy(xpath="//button[@type='submit']")
	WebElement savebutton;

	@FindBy(xpath="//span[@class='fa fa-close']")
	WebElement closebutton;

	@FindBy(xpath="//input[@type='search']")
	WebElement searchbutton;

	@FindBy(xpath="//*[@id='note-table']/tbody/tr[1]/td[4]/a[1]")
	WebElement editnote;

	@FindBy(xpath="//input[@id='title']")
	WebElement editnotetitle;

	@FindBy(xpath="//span[@class='fa fa-check-circle']")
	WebElement savebutton2;

	@FindBy(xpath="//span[@class='fa fa-close']")
	WebElement closebutton2;

	@FindBy(xpath="//table[@id='note-table']/tbody[1]/tr[1]/td[4]/a[2]")
	WebElement deletenote;

	@FindBy(xpath="//a[@class='delete' and @data-id='1']")
	WebElement deletenotebutton;

	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement confirmdeletebutton;

	@FindBy(xpath="//div[contains(@class,'app-alert alert')]")
	WebElement delnotealertmessage;

	@FindBy(xpath="//div[@id='js-init-chat-icon']")
	WebElement noresultsicon;



	public NotePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		uwait = new WaitUtility(driver);
		eutility = new ElementsUtility(driver);
	}
	public void clickOnNote() {

		uwait.waitForElementClick(notesmenu);
		notesmenu.click();
	}

	public void doCreateNote(String title, String description) throws Exception {
		uwait.waitForElementClick(addnotebutton);
		addnotebutton.click();
		uwait.waitForVisibility(titlefield);
		titlefield.sendKeys(title);
		uwait.waitForVisibility(descriptionfield);
		descriptionfield.sendKeys(description);
		uwait.waitForElementClick(savebutton);
		savebutton.click();
		uwait.waitForElementClick(closebutton);
		closebutton.click();

	}

	public String doSearchNote(String title) {

		uwait.waitForElementClick(searchbutton);
		searchbutton.clear();
		uwait.waitForElementClick(searchbutton);
		searchbutton.sendKeys(title);
		By locator=By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+title+"')]");
		uwait.waitForVisibility(locator);
		List<WebElement> notetable=driver.findElements(By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+title+"')]"));
		uwait.waitForVisibility(notetable);
		int row=eutility.getTableDataRowCount(notetable, title);
		String message="";
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='note-table']//tbody//tr["+row+"]//td[2]"));
			message=tableRow.getText();
			System.out.println(message);

		}
		return message;
	}



	public void doEditNote(String edittitle) {
		uwait.waitForElementClick(editnote);
		editnote.click();	
		uwait.waitForVisibility(editnotetitle);
		editnotetitle.clear();
		editnotetitle.sendKeys(edittitle);
		uwait.waitForElementClick(savebutton2);
		savebutton2.click();
		uwait.waitForElementClick(closebutton2);
		closebutton2.click();	
	}

	public void doDeleteNote() {
		uwait.waitForElementClick(deletenotebutton);
		deletenotebutton.click();
		uwait.waitForElementClick(confirmdeletebutton);
		confirmdeletebutton.click();
		String message = delnotealertmessage.getText();
		System.out.println(message);
		//uwait.waitForVisibility(norecordsmessage);
		//String message3 = norecordsmessage.getText();
		//return message3;
	}



}

