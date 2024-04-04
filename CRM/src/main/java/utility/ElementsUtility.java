package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



import constants.Constants;

    public class ElementsUtility {
	WebDriver driver;
	public ElementsUtility (WebDriver driver) {
	this.driver=driver;
	}
	
	   public static String getPropertyValue(String key) 
	  {

		File src=new File(Constants.propertyConfig_File);
		Properties pro=new Properties();
		try {
			FileInputStream fis = new FileInputStream (src);
			
			pro.load(fis);//load the properties from the configure file
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		String value=pro.get(key).toString();//get the value when key is passed
		return value;
		
	}
	   public int getTableDataRowCount(List<WebElement> tableRowData ,String expectedValue)
	 		{
	 			
	 		        int counter=0;
	 			for(int i=0;i<tableRowData.size();i++)
	 			{
	 				String value=tableRowData.get(i).getText();
	 				if(expectedValue.equalsIgnoreCase(value))
	 				{
	 					counter=i+1;
	 					break;
	 				}
	 				
	 			}
	 			return counter;
	 		}
	   
      public void scrollToElement(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
      public void selectDropdown(WebElement element,String type,String value) {


	    Select sel=new Select(element);

	  if (type.equalsIgnoreCase("index"))
		sel.selectByIndex(Integer.parseInt(value));
	
	  else if  (type.equalsIgnoreCase("visibletext")) {
	
		sel.selectByVisibleText(value);
	}
		else if  (type.equalsIgnoreCase("byvalue")){

		sel.selectByValue(value);
		}
	  
	
		
	}
	  
      public void clearAndsendKeys(WebElement element,String value) {

      	element.clear();
	    element.sendKeys(value);
}

}
