package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpcomingBikesPage extends BasePage {
	//WebDriver driver;
	public UpcomingBikesPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath ="//select[@id='makeId']")
	WebElement manufacturer;
	
	@FindBy(xpath ="//span[@class='zw-cmn-loadMore']")
	WebElement viewMore;

	@FindBy(xpath ="//ul[@id='modelList']//li//div/a")
	List<WebElement> modelName;
	
	@FindBy(xpath ="//ul[@id='modelList']//li//div/a/following-sibling::div[1]")
	List<WebElement> price;
	
	@FindBy(xpath ="//ul[@id='modelList']//li//div/a/following-sibling::div[2]")
	List<WebElement> expectedDate;
	
	
	
	
	//Actions
	
	
	public String selectManufacturer() {
		 try{
	    	
	      Select manu=new Select(manufacturer);
	     manu.selectByVisibleText("Honda");
	     return driver.getTitle();}
	     catch(Exception e) {}
		return null;
	}
	
	
	public void clickViewMore() {	

		scrollToElement(viewMore, viewMore);
	       
	}
	public  List<WebElement> listOfModels(){
		return modelName;
	}
	
	public  List<WebElement> priceOfModels(){
		return price;
	}
	
	public  List<WebElement> expectedDateOfRelease(){
		return expectedDate;
	}
}
