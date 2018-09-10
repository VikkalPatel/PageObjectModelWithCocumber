 package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	By uname = By.name("username");
	By pword = By.name("password");
	By login = By.xpath("//input[@type='submit']");
	By crmLogo = By.xpath("/img[contails(@class,'img-responsive')]");
	
	public String validateLoginPageTitle()
		{
			System.out.println("inside getPageTitle");
			return getDriver().getTitle();

		}
	
	public void UserEnterIDandPassword(String username,String password){
		 	System.out.println("I am in Login Page and calling input method in page class");
			input(uname, username);
			input(pword,password);
		}
	
	public HomePage LoginClick(){
			//This Login button click is not working by simple click so we have to use JavascriptExecutor.
			WebElement loginBtn = getDriver().findElement(login);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].click();", loginBtn);
			HomePage hp = new HomePage(getDriver());
			return hp;
	}
	
	public boolean validateCRMImage(){
		//check is logo present 
		return ((WebElement) crmLogo).isDisplayed();
	}
	
	
	
}
