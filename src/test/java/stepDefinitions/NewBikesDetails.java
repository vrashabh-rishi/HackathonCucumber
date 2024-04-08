package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import Utilities.ExcelWriter;
import pageObjects.HomePage;
import pageObjects.UpcomingBikesPage;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewBikesDetails {
	WebDriver driver;
	HomePage hm;
	UpcomingBikesPage ubp;
	SoftAssert sa=new SoftAssert();
	
		
		@Given("user navigates to ZigWheels page")
		public void user_navigates_to_zig_wheels_page() {
			BaseClass.getLogger().info("Navigated to ZigWheels");
			hm=new HomePage(BaseClass.getDriver());
			
		   
		}
		
		@When("user hovers to Newbikes toggle")
		public void user_hovers_to_newbikes_toggle() {
			BaseClass.getLogger().info("Navigated to NewBikes");
			hm=new HomePage(BaseClass.getDriver());
			hm.moveToNewBikes();
		
		}
		
		@When("user clicks on Upcoming bikes")
		public void user_clicks_on_upcoming_bikes() {
			hm=new HomePage(BaseClass.getDriver());
			String a=hm.clickOnUpcomingBikes();
			sa.assertEquals(a.equals("Upcoming Bikes in India - Check Price, Launch Date, Images and Latest News"), true);
			BaseClass.getLogger().info("Clicked on Upcoming bikes");
		}
		
		@When("chooses manufacturer as Honda")
		public void chooses_manufacturer_as_honda() {
		 ubp= new UpcomingBikesPage(BaseClass.getDriver());
		 String a=ubp.selectManufacturer();
		 sa.assertEquals(a.equals("Honda Upcoming Bikes in India - Check Price, Launch Date, Images and Latest News"), true);
		 BaseClass.getLogger().info("Honda as manufacturer is selected ");
		}
		
		@Then("All the upcomings bikes of Honda manufacturer are displayed")
		public void all_the_upcomings_of_honda_manufacturer_are_displayed() throws IOException {
			 ubp= new UpcomingBikesPage(BaseClass.getDriver());
			 ubp.clickViewMore();
			List<WebElement> modelName= ubp.listOfModels();
			List<WebElement> price= ubp.priceOfModels();
			List<WebElement> expectedDate= ubp.expectedDateOfRelease();

			List<String> mName=new  ArrayList<String>();
			List<String> pr=new  ArrayList<String>();
			List<String> eDate=new ArrayList<>();
			BaseClass.getLogger().info("Displaying New Upcoming bikes of Honda");
			 for(int i=0;i<modelName.size();i++) {
				 
				   String temp=price.get(i).getText();
				   if(!temp.contains("Lakh"))
				   {
					   mName.add(modelName.get(i).getText());
					   pr.add(price.get(i).getText());
					   eDate.add(expectedDate.get(i).getText());

					   System.out.println(modelName.get(i).getText()+"    "+price.get(i).getText()+"   "+expectedDate.get(i).getText());
				   }
				   else if(temp.contains("Lakh"))	 
				   {
					   double p=Double.parseDouble(temp.substring(temp.indexOf("Rs")+4,temp.indexOf("Lakh")-1));
				    	if(p<=4.00) {
				    		 mName.add(modelName.get(i).getText());
							   pr.add(price.get(i).getText());
							   eDate.add(expectedDate.get(i).getText());
				    		System.out.println(modelName.get(i).getText()+"    "+price.get(i).getText()+"   "+expectedDate.get(i).getText());
				    		     }
				   	}
			 }
			 sa.assertEquals(modelName.size()>0, true);
			 ExcelWriter.enterBikeDetails(mName, pr, eDate,"NewBikes");
		}


}
