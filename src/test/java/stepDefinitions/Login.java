package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import Utilities.ExcelReader;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Login {
	
	WebDriver driver=BaseClass.getDriver();
	HomePage homepage;
	LoginPage loginpage;
	Set<String> windowIds;
	List<String> windowIdsList;	
	SoftAssert sa=new SoftAssert();
	

	@Given("the user navigates to home page")
	public void the_user_navigates_to_home_page() {
		
		homepage=new HomePage(BaseClass.getDriver());
		homepage.clickLogo();	 
		BaseClass.getLogger().info("Navigated to Home Page");
	}

	@When("clicking on Login button And clicking on google")
	public void clicking_on_login_button_and_clicking_on_google() {
	    
		BaseClass.getLogger().info("Trying to login in google");
		homepage=new HomePage(BaseClass.getDriver());
		boolean a=homepage.clickLogin();
		sa.assertEquals(a, true);
		homepage.clickGoogle();
		
	}

	@Then("entering the invalid email {string}")
	public void entering_the_invalid_email(String row) throws IOException {
		
		BaseClass.getLogger().info("Entering invalid credentials");
		
		ExcelReader excel=new ExcelReader();
		
		loginpage=new LoginPage(BaseClass.getDriver());	    
		windowIds=driver.getWindowHandles();
		windowIdsList=new ArrayList<>(windowIds);			
		
		driver.switchTo().window(windowIdsList.get(1));	
		
		System.out.println(driver.getTitle());
		sa.assertEquals(driver.getTitle().equals("Sign in - Google Accounts"), true);
		
		try {
		loginpage.clickAnotherAcc();
		}catch(Exception e) {}
		
		//Getting email from excel file
		String email=excel.data(row);		
		loginpage.setEmail(email);
		
		loginpage.clickNext();
		
		String errormsg=loginpage.getErrorMessage();
		System.out.println(errormsg);
	}

	
}
