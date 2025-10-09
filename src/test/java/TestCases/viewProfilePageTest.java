package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ViewProfilePage;
import TestBase.TestBase;

public class viewProfilePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ViewProfilePage viewProfile;
	
	public viewProfilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		viewProfile = new ViewProfilePage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		viewProfile=homePage.viewProfile();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test (priority =1)
	public void verifyNoticePeriod() {
		viewProfile.updateNoticePeriod();
	}
	
	@Test (priority =2)
	public void verifyResumeUpload() {
		viewProfile.updateResume(prop.getProperty("resumeFilePath"));
	}
	
	@Test (priority =3)
	public void verifyTitle() {
		String title =viewProfile.Title();
		assertEquals(title, "XYZ");
	}

	

}
