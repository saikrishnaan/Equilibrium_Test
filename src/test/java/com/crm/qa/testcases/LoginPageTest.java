package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		homePage = new HomePage();
	}
	
	
	@Test(priority=1)
	public void ValidLoginTest() throws InterruptedException{
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Products')]")));
		String Verifyuser = homePage.VerifyValiduser();
		
		System.out.println("Verifyuser: " +Verifyuser);
		Assert.assertEquals(Verifyuser, "Valid User","its not an valid user");
		
		
	}
	
	@Test(priority=2)
	public void ProblematicLoginTest() throws InterruptedException{
		
		loginPage.login(prop.getProperty("problem_user"), prop.getProperty("password"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Products')]")));
		String Verifyuser = homePage.VerifyValiduser();
		
		System.out.println("Verifyuser: " +Verifyuser);
		Assert.assertEquals(Verifyuser, "Problem User","its a valid user");
		
		
	}
	
	@Test(priority=3)
	public void ValidateLockedoutUser() throws InterruptedException{
		
		loginPage.login(prop.getProperty("locked_user"), prop.getProperty("password"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test=\"error\"]")));
		boolean	userlocked	= homePage.LockedoutUser();
		System.out.println("user is locked: " +userlocked);
		
		
		
	}
	
	@Test(priority=4)
	public void Invaliduser(){
		
		try {
			loginPage.login(prop.getProperty("invalid_username"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test=\"error\"]")));
		boolean	userlocked	= homePage.InvalidLogin();
		System.out.println("Login details are invalid: Username: " +prop.getProperty("invalid_username")+", Password: " +prop.getProperty("password"));
		
		
		
	}
	
	@Test(priority=5)
	public void BlankUsername(){
		
		try {
			loginPage.login(prop.getProperty("blankusername"), prop.getProperty("blankpassword"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test=\"error\"]")));
		boolean	userlocked	= homePage.BlankUsername();
		System.out.println("Login details are invalid: Username: " +prop.getProperty("blankusername")+", Password: " +prop.getProperty("blankpassword"));
		
		
		
	}
	
	/*
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=4)
	public void loginTest_LockedUser(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=3)
	public void loginTest_ProblemUser(){
		homePage = loginPage.login(prop.getProperty("problem_user"), prop.getProperty("password"));
	}
	
	
	@Test(priority=3)
	public void loginTest_InvalidUser(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	*/
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
