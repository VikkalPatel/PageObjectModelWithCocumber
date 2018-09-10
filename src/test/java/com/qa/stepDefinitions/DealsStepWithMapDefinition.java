package com.qa.stepDefinitions;

//import org.testng.AssertJUnit;
import junit.framework.Assert;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewDealPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DealsStepWithMapDefinition 
{	
	
	private static final String String = null;
	WebDriver driver;
	LoginPage lp = new LoginPage();
	HomePage hp;
	NewDealPage NewDeal;
	
	//public Properties CONFIG = null;
	
	@Given("^user launch an application$")
	public void user_already_on_login_page() 
	{
		System.out.println("I am in initialization");
		lp.initialization();
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_free_CRM()
	{
		System.out.println("I am inside title class");
		String sr = lp.validateLoginPageTitle();
		System.out.println(lp.validateLoginPageTitle());
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", sr);
	}


	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) throws Throwable 
	{
		//Now we are calling LogingPage for Entering User Id and Password.
		lp.UserEnterIDandPassword(username, password);	
	}

	
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable 
	{
		//Now we are calling LoginPage for clicking on login button.
		 hp = lp.LoginClick();
		 System.out.println("User has clicked on login button");
	}
	
	
	@Then("^user is on home page$")
	public void user_is_on_hopme_page()
	{
		//String title = driver.getTitle();
		String title = hp.getHomePageTitle();
		System.out.println("Home Page title ::" + title);
		Assert.assertEquals("CRMPRO", title);
	}

	@Then("^user moves to new deal page$")
	public void user_moves_to_new_deals_page()
	{
		NewDeal = hp.NavigateToNewDeal();
		
	}
	
	@Then("^user enters deal details$")
	public void user_enters_contacts_details(DataTable dealData) {

		for (Map<String, String> data : dealData.asMaps(String.class, String.class)) {

			
			NewDeal.newDeal(data.get("title"),data.get("amount"), data.get("probability"), data.get("commission"));
			//hp.NavigateToNewDeal();


			
			
		//	
			
	//		move to new deal page:
		/*	Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("a[contains(text(),'Deals')]"))).build().perform();
			driver.findElement(By.xpath("a[contains(text(),'New Deal')]")).click();
*/
		}

		
	}
/*
	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

*/
	
}
