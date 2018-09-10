package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class NewDealPage extends TestBase {
	
	By titleId = By.id("title");
	By amountId =  By.id("amount");
	By probabilityId = By.id("probability");
	By commissionId = By.id("commission");
	By savePath = By.xpath("//input[@type='submit'and @value='Save']");
	
	public NewDealPage(WebDriver driver){
		super.setDriver(driver);
	}

	public void newDeal(String dealTitle, String dealAmount, String dealProbability, String dealCommission){
		
		
		getDriver().findElement(titleId).sendKeys(dealTitle);
		getDriver().findElement(amountId).sendKeys(dealAmount);
		getDriver().findElement(probabilityId).sendKeys(dealProbability);
		getDriver().findElement(commissionId).sendKeys(dealCommission);
		getDriver().findElement(savePath).click();
		
		
		getDriver().switchTo().frame("mainpanel");
		
		By deal		= By.xpath("//*[contains(text(),'Deals')]"); 
		By newdeal 	= By.xpath("//*[contains(text(),'New Deal')]");
		Actions action1 = new Actions(getDriver());
		action1.moveToElement(getDriver().findElement(deal)).build().perform();
		getDriver().findElement(newdeal).click();
		

	}
	
	
}
