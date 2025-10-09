package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;


public class LoginPage extends TestBase {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Login")
	WebElement loginLink;
	
	@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Enter your password']")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='server-err']")
	WebElement errorMessage;
	
	
	public HomePage login(String un,String pass) {
		loginLink.click();
		username.sendKeys(un);
		password.sendKeys(pass);
		loginButton.click();
		return new HomePage();
	
	}
	
	public String loginErrorValidation() {

		return errorMessage.getText();
	}
	

}
