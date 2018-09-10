
package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	By uname	= By.name("username");
	By pwd		= By.name("password");
	By deal		= By.xpath("//*[contains(text(),'Deals')]"); 
	By newdeal 	= By.xpath("//*[contains(text(),'New Deal')]");
	
	
	public HomePage(WebDriver driver)
		{
			super.setDriver(driver);
		}

	public String getHomePageTitle()
	{
		System.out.println("inside getPageTitle");
		return getDriver().getTitle();

	}
	
	public NewDealPage NavigateToNewDeal()
	{
		getDriver().switchTo().frame("mainpanel");
		//getDriver().findElement(deal).click();
		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(deal)).build().perform();
		getDriver().findElement(newdeal).click();
		NewDealPage NewDeal = new NewDealPage(getDriver());
		return NewDeal;
	}
	
	public String abc()
		{
			//modify this function.
			System.out.println("inside abc");
			String title = getDriver().getTitle();
			return title;
		}
}