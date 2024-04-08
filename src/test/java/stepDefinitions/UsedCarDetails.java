package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import Utilities.ExcelWriter;
import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.UsedCarspage;


public class UsedCarDetails {
	WebDriver driver;
	HomePage hp;
	UsedCarspage ucp;
	SoftAssert sa=new SoftAssert();
		
		@When("user hovers to Used cars toggle")
		public void user_hovers_to_used_cars_toggle() {
			BaseClass.getLogger().info("Move to Used car toggle");
		 hp=new HomePage(BaseClass.getDriver());
		 hp.moveToUsedCars();
		}
		
		@When("user clicks on Chennai as preferd location")
		public void user_clicks_on_chennai_as_preferd_location() {
			 hp=new HomePage(BaseClass.getDriver());
			 String a=hp.selectCity();
			 BaseClass.getLogger().info("Select Chennai as city");
			 sa.assertEquals(a.equals("Used Cars in Chennai - 1957 Second Hand Cars for Sale in Chennai "), true);
		}
		
		@Then("All the popular car modles list will be diplayed")
		public void all_the_popular_car_modles_list_will_be_diplayed() throws IOException {
		  ucp =new UsedCarspage(BaseClass.getDriver());
		  List<WebElement>popularCars=ucp.ListOfPopularcars();
		  List<String> cars=new ArrayList<>();
		  BaseClass.getLogger().info("Displaying popular cars");
		  for(WebElement x:popularCars) {
			  System.out.println(x.getText());
			  cars.add(x.getText());
		  }
		  sa.assertEquals(popularCars.size()>0, true);
		  ExcelWriter.enterCarDetails(cars,"PopularCars");
		}

}
