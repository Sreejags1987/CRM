package page;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementsUtility;
import utility.WaitUtility;

public class ClientPage {
	WebDriver driver;
	ElementsUtility eutility;
	WaitUtility uwait;
	WebDriverWait wait;


    @FindBy(xpath="//span[text()='Clients']")
    WebElement clientsmenu;
    
    @FindBy(xpath="//a[@title='Add client']")
    WebElement addclientbutton;
    
    @FindBy(xpath="//input[@name='company_name']")
    WebElement companynamefield;
    
    @FindBy(xpath="//textarea[@name='address']")
    WebElement addressfield;
    
    @FindBy(xpath="//input[@name='city']")
    WebElement cityfield;
    
    @FindBy(xpath="//input[@name='state']")
    WebElement statefield;
    
    @FindBy(xpath="//input[@name='zip']")
    WebElement zipfield;
    
    @FindBy(xpath="//input[@name='country']")
    WebElement countryfield;
    
    @FindBy(xpath="//input[@name='phone']")
    WebElement phonefield;
    
    @FindBy(xpath="//input[@name='website']")
    WebElement websitefield;
    
    @FindBy(xpath="//input[@name='vat_number']")
    WebElement vatnumberfield;
    
    @FindBy(xpath="//span[@id='select2-chosen-7']")
    WebElement currencyfield;
    
    @FindBy(xpath="//input[@name='currency_symbol']")
    WebElement currencysymbolfield;
    
    @FindBy(xpath="//input[@name='disable_online_payment']")
    WebElement disableonlinepaymentfield;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement clientsavebutton;
    
    @FindBy(xpath="//span[@class='fa fa-close']")
    WebElement clientclosebutton;
    
    @FindBy(xpath="//input[@type='search']")
    WebElement searchcompany;
    
    @FindBy(xpath="//table[@id='client-table']/tbody[1]/tr[1]/td[2]/a[1]")
    WebElement searchtext;
    
    public ClientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		eutility = new ElementsUtility(driver);
		uwait = new WaitUtility(driver);
		
	}
	
	public void clickOnClientsLink() {
		WebElement clientPage = driver.findElement(By.xpath("//a[contains(text(),'Clients')]"));
		WebElement clickOnClients = clientPage;
		uwait.waitForVisibility(clientPage);
		clientPage.click();
		
	}
	
	public void clickOnAddClients() {
		uwait.waitForVisibility(addclientbutton);
		addclientbutton.click();
		
	}
	public String enterClientDetails(String companyname, String address,String city, String state, String zipcode, String country, String phone, String website, String VAT, String currency, String currencysymbol) {
		uwait.waitForVisibility(companynamefield);
		companynamefield.sendKeys(companyname);
		uwait.waitForVisibility(addressfield);
		addressfield.sendKeys(address);
		uwait.waitForVisibility(cityfield);
		cityfield.sendKeys(city);
		uwait.waitForVisibility(statefield);
		eutility.scrollToElement(statefield);
		statefield.sendKeys(state);
		uwait.waitForVisibility(zipfield);
		zipfield.sendKeys(zipcode);
		uwait.waitForVisibility(countryfield);
		countryfield.sendKeys(country);
		uwait.waitForVisibility(phonefield);
		phonefield.sendKeys(phone);
		uwait.waitForVisibility(websitefield);
		websitefield.sendKeys(website);
		uwait.waitForVisibility(vatnumberfield);
		eutility.scrollToElement(vatnumberfield);
		vatnumberfield.sendKeys(VAT);
		uwait.waitForElementClick(currencyfield);
		currencyfield.click();
		uwait.waitForVisibility(currencysymbolfield);
		currencysymbolfield.sendKeys(currency);
		currencysymbolfield.click();
		uwait.waitForVisibility(disableonlinepaymentfield);
		disableonlinepaymentfield.click();
		clientsavebutton.click();
		clientclosebutton.click();
		eutility.clearAndsendKeys(searchcompany, companyname);
		String actual=searchtext.getText();
		return actual;
		
	}
	public String searchClient(String searchvalue){
		eutility.clearAndsendKeys(searchcompany, searchvalue);
		By verifynotes=By.xpath("//table[@id='client-table']//tbody//tr//td//a[contains(text(),'"+searchvalue+"')]");
		uwait.waitForVisibility(verifynotes);
		List<WebElement> clienttable=driver.findElements(By.xpath("//table[@id='client-table']//tbody//tr//td//a[contains(text(),'"+searchvalue+"')]"));
		uwait.waitForVisibility(clienttable);
		int row=eutility.getTableDataRowCount(clienttable, searchvalue);
		String message="";
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='client-table']//tbody//tr["+row+"]//td[2]"));
			message=tableRow.getText();
			System.out.println(message);
			
		}
		return message;
	}
	
}

    
    
    
