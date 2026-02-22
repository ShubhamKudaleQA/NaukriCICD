package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		loginPage = new LoginPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test (priority = 1)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority = 2)
	public void loginInvalidTest() {
		loginPage.login("Sai", "Sai@121");
		
		String msg = loginPage.loginErrorValidation().split("If")[0].trim();
		//assertEquals("Error Message",msg);
		System.out.println(msg);
	}
	
}
