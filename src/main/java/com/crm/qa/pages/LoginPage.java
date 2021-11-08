package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	@FindBy(xpath="//img[contains(@class,'login_logo')]")
	WebElement Logo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		//PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLogoImage(){
		return Logo.isDisplayed();
	}
	
	public void login(String un, String pwd) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
		WebElement username = driver.findElement(By.name("user-name"));
		WebElement Password = driver.findElement(By.name("password"));
		username.sendKeys(un);
		Password.sendKeys(pwd);
		WebElement LoginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		//LoginButton.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", LoginButton);
		   Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Products')]"))); 	
		
	}
	
}
