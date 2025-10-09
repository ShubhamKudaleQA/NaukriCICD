package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=\"nI-gNb-header__wrapper\"]/a/img")
	WebElement naukriImg;
	
	@FindBy(partialLinkText = "profile")
	WebElement viewProfileLink;
	
	public boolean naukriImgVerify() {
		return naukriImg.isDisplayed();
	}
	
	public ViewProfilePage viewProfile() {
		wait.until(ExpectedConditions.visibilityOf(viewProfileLink));
		viewProfileLink.click();
		return new ViewProfilePage();
	}
	

}
