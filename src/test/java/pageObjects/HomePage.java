package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	//WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	
	//Locators
	//List of WebElements in toggle.
	
	@FindBy (xpath = "//a[@class='zw i-b mt-10 pt-2 zw-srch-logo']")
	WebElement zigWheelsLogo;
	
	@FindBy(xpath = "//div[@class='col-lg-12 pl-0']/ul/li")
	List<WebElement> toggles;
	

	@FindBy(xpath = "//div[@class='col-lg-12 pl-0']/ul/li[3]/ul/li")
	List<WebElement> newBikestoggle;
	
	@FindBy(xpath="//div[@class='h-dd-r']//li/span")
	List<WebElement> cities;
	
	@FindBy(id="forum_login_wrap_lg")
	WebElement login;
	
	@FindBy(xpath="//span[@class='lgn-sp s ggle']")
	WebElement google;
	
	
	
	//Actions
	//Click on NewBikes option from Toggle 
	public void moveToNewBikes() {
		
		 for(WebElement x:toggles)
	      {
	    	  if(x.getText().equals("New Bikes")) {
	    		  hoverOnElement(x);
	    		  break;
	    	  }
	      }
	}
	
	
	//click on Upcoming bikes from the options available in NewBikes
	public String clickOnUpcomingBikes() {
	 for(WebElement x:newBikestoggle)
     {
   	if(x.getText().equalsIgnoreCase("Upcoming Bikes")) {
   		x.click();
   		break;
   	}		
   }
	 return driver.getTitle();
	}
	
	public void moveToUsedCars() {
		
		 for(WebElement x:toggles)
	      {
	    	  if(x.getText().equals("Used Cars")) {
	    		 hoverOnElement(x);
	    		  break;
	    	  }
	      }
	}
	
	
	public String selectCity() {

		 for(WebElement x:cities)
	      {
	    	  if(x.getText().equals("Chennai")) {
	    		x.click();
	    		  break;
	    	  }
	      }
		 return driver.getTitle();
	}
	
	public boolean clickLogin() {	
		login.click();
		return login.isDisplayed();
	}
	
	public void clickGoogle() {
		explicitWait(google);
		google.click();
	}
	
	public void clickLogo() {
		scrollToElement(zigWheelsLogo,zigWheelsLogo);
	}
	
}
