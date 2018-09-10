package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

// Snehal - Add global properties here, like TimeOut, Poll_time


public class TestBase 
{

	public static Properties prop = null;
	private WebDriver driver;
	
	public TestBase() {
		
		try
		{
			prop = new Properties();
			FileInputStream fs =  new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//crm//qa//config//config.properties");
			prop.load(fs);
			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public WebDriver initialization (){
		if (prop.getProperty("browser").equalsIgnoreCase("Mozilla"))
		{
			driver = new FirefoxDriver();
			//Snehal - Handle firefox basic propuration and add also allow to point to specific Node on Selenium Hub
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("Chrome"))
		{												
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//java//com//crm//qa//driver//chromedriver");
			driver = new ChromeDriver();
			System.out.println("prop file has detected Chrome Driver");	
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
	//	driver.get("https:www.freecrm.com/index.html");
		System.out.println("Vikkal: I am getting url");
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		//Here we are waiting for 30 second, just to make sure that all element are loaded 
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		// Snehal - keep driver public and save driver instance to this.driver
		return driver;
	}
	
	//Click
	public void myclick(String xpath)
	{
		try
		{
			// Snehal - Always add explicite wait time when find any element
			driver.findElement(By.xpath(xpath)).click();
		}
		catch  (Exception e)
		{
			System.out.println("Getting an error in click xpath in Page.java");
		}
		
	}
	
	//input
	public void input (By locator , String text)
	{										//xpath	
		try
		{
			System.out.println("i am in input method under page class");
			driver.findElement((locator)).sendKeys(text);
			//driver.findElement(By.xpath(xpath)).sendKeys(text);
		}
		catch (Exception e)
		{
			System.out.println("Getting an error in input xpath in Page.java");
		}
	}

	public  WebDriver getDriver() {
		return driver;
	}

	public  void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	//select
	
	
	//verification
	
	
}
