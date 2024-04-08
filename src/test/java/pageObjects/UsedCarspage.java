package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsedCarspage extends BasePage {
	//WebDriver driver;
	public  UsedCarspage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='gsc_thin_scroll']//li//label")
    List<WebElement> popularCarModles;
	
	@FindBy(xpath = "//div[@class='zm-cmn-colorBlack ml-30 mob-nonclick div-h3 mt-20 mb-10']")
    WebElement scroll;
	
	
	//Actions

	public List<WebElement> ListOfPopularcars(){
		explicitWait(scroll);
		
		scrollToElement(scroll);
		return popularCarModles;
	}


}
