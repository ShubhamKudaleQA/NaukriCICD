package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ViewProfilePage;
import TestBase.TestBase;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ViewProfilePage viewProfile;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test (priority =1)
	public void verifyNaukriImgTest() {
		homePage.naukriImgVerify();
		System.out.println("Naukri Image is displayed!!!!");
	}
	
	@Test (priority =2)
	public void navigateToViewProfile() {
		viewProfile=homePage.viewProfile();
	}
	

}
