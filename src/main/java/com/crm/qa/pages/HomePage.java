package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

			public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public String VerifyValiduser()
	{
		String User = null;
		
		WebElement backpackitem = driver.findElement(By.xpath("//img[@alt=\"Sauce Labs Backpack\"]"));
		WebElement bikelight = driver.findElement(By.xpath("//img[@alt=\"Sauce Labs Bike Light\"]"));
		backpackitem.isDisplayed();
		bikelight.isDisplayed();
		
		String backpackattribute = backpackitem.getAttribute("src"); 
		String bikelightattribute = bikelight.getAttribute("src");
		
		if(backpackattribute.contains("backpack") && bikelightattribute.contains("bike-light"))
		{
			User = "Valid User";
			
		}
		else {
			
			User = "Problem User";
		}
		
		return User;
	}
	
	public boolean LockedoutUser()
	{
		String User = null;
		
		WebElement LockederrorMessage = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		
		LockederrorMessage.isDisplayed();
		
		String errormessage = LockederrorMessage.getText().toString();
		
		Assert.assertEquals(errormessage, "Epic sadface: Sorry, this user has been locked out.","Unable to verify locked error Message");
		
		return true;
		
	}
	
	public boolean InvalidLogin()
	{
		String User = null;
		
		WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		
		errorMessage.isDisplayed();
		
		String errormessage = errorMessage.getText().toString();
		
		Assert.assertEquals(errormessage, "Epic sadface: Username and password do not match any user in this service");
		
		return true;
		
	}
	
	public boolean BlankUsername()
	{
		String User = null;
		
		WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		
		errorMessage.isDisplayed();
		
		String errormessage = errorMessage.getText().toString();
		
		Assert.assertEquals(errormessage, "Epic sadface: Username is required");
		
		return true;
		
	}
	

}
