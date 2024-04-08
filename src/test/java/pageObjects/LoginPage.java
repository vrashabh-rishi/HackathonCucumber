package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	//Locating elements
	
	@FindBy(xpath="//div[text()='Use another account']")
	WebElement anotherAcc;
	
	@FindBy(id="identifierId")
	WebElement emailInput;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement emailNext;
	
	@FindBy(xpath="//div[@class='Ekjuhf Jj6Lae']")
	WebElement errorMessage;
	
	//Action Methods
	
	public void clickAnotherAcc() {
		anotherAcc.click();		
	}
	
	public void setEmail(String email) {
		explicitWait(emailInput);
		
		if(emailInput.getAttribute("data-initial-value")!=null) {
			emailInput.clear();
		}		
		emailInput.sendKeys(email);
		System.out.println(emailInput.getAttribute("data-initial-value"));
	}
	
	public void clickNext() {
		scrollToElement(emailNext,emailNext);
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	

}
