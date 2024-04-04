package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ElementsUtility;
import utility.WaitUtility;

public class ProjectPage {
	WebDriver driver;
	WaitUtility uwait;
	ElementsUtility eutility;
	
	@FindBy(xpath="//span[text()='Projects']")
	WebElement projectsmenu;
	
    @FindBy(xpath="//span[text()='All Projects']")
    WebElement allprojectsmenu;
    
    @FindBy(xpath="//a[@class='btn btn-default' and @title='Add project']")
    WebElement addprojectbutton;
    
    @FindBy(xpath="//input[@id='title']")
    WebElement titlefield;
    
    @FindBy(xpath="//textarea[@id='description']")
    WebElement descriptionfield;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement savebutton;
    
    @FindBy(xpath="//span[@class='fa fa-close']")
    WebElement closebutton;
    
    @FindBy(xpath="//input[@type='search']")
    WebElement searchfield;
    
    @FindBy(xpath="//table[@id='project-table']/tbody[1]/tr[1]/td[2]/a[1]")
    WebElement verifyproject;
    
    @FindBy(xpath="//table[@id='project-table']/tbody[1]/tr[1]/td[9]/a[1]")
    WebElement editprojectmenu;
    
    @FindBy(xpath="//input[@id='title']")
    WebElement editprojecttitle;
    
    @FindBy(xpath="//textarea[@id='description']")
    WebElement editprojectdescription;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement editprojectsavebutton;
    
    @FindBy(xpath="(//button[@class='btn btn-default'])[1]")
    WebElement editclosebutton;
    
    @FindBy(xpath="//table[@id='project-table']/tbody[1]/tr[1]/td[9]/a[2]")
    WebElement deleteprojectmenu;
    
    @FindBy(xpath="//button[@id='confirmDeleteButton']")
    WebElement projectdeletebutton;
    
    @FindBy(xpath="//div[contains(@class,'app-alert alert')]")
    WebElement dltprojectalertmessage;
    
    @FindBy(xpath="//td[text()='No record found.']")
    WebElement norecordsfoundtext;
    
        public ProjectPage(WebDriver driver) {
        	this.driver = driver;
    		PageFactory.initElements(driver, this);
    		uwait = new WaitUtility(driver);
    		eutility = new ElementsUtility(driver);
    
        }
        
    	public void doCreateProject(String title, String description)throws Exception {
    		uwait.waitForElementClick(projectsmenu);
    		projectsmenu.click();
    		uwait.waitForElementClick(allprojectsmenu);
    		allprojectsmenu.click();
    		uwait.waitForElementClick(addprojectbutton);
    		addprojectbutton.click();
			uwait.waitForVisibility(titlefield);
			titlefield.sendKeys(title);
			uwait.waitForVisibility(descriptionfield);
			descriptionfield.click();
			uwait.waitForElementClick(savebutton);
			savebutton.click();
			uwait.waitForElementClick(closebutton);
			closebutton.click();
			
    	}
    	
    	public void doSearchProject(String searchvalue) {
    		uwait.waitForVisibility(searchfield);
    		searchfield.clear();
    		uwait.waitForVisibility(searchfield);
    		searchfield.sendKeys(searchvalue);	
    	}
    	
    	
    	public void doEditproject(String editproject) {
    	    uwait.waitForElementClick(editprojectmenu);
    	    editprojectmenu.click();
    	    uwait.waitForVisibility(editprojecttitle);
    	    editprojecttitle.clear();
    	    uwait.waitForVisibility(editprojecttitle);
    	    editprojecttitle.sendKeys();
    	    uwait.waitForVisibility(editprojectdescription);
    	    editprojectdescription.sendKeys();
    	    uwait.waitForElementClick(editprojectsavebutton);
    	    editprojectsavebutton.click();
    	    
    	}
    	
			public void doDeleteProject(String deleteproject) {		
			uwait.waitForElementClick(deleteprojectmenu);
			deleteprojectmenu.click();
			uwait.waitForElementClick(projectdeletebutton);
			projectdeletebutton.click();
			String deletemessage = dltprojectalertmessage.getText();
			System.out.println(deletemessage);
			String norecordstext = norecordsfoundtext.getText();
			System.out.println(norecordstext);
			

			
			
    	}
}
		
