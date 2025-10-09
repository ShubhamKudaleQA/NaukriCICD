package Pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBase.TestBase;

public class ViewProfilePage extends TestBase {

	public ViewProfilePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//em[contains(@class,'edit')]")
	WebElement editButton;

	@FindBy(xpath = "//div[contains(@class,'notice-period-container')]/span")
	List<WebElement> noticePeriod;

	@FindBy(id = "saveBasicDetailsBtn")
	WebElement saveButton;
	
	@FindBy(xpath = "//p[@class='msg']")
	WebElement CVUpdateSuccessMsg;

	@FindBy(xpath = "//input[contains(@class,'dummyUpload')]")
	WebElement inputFile;

	public void updateNoticePeriod() {
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		editButton.click();

		String noticeLess15 = prop.getProperty("noticePeriod");

		for (WebElement a : noticePeriod) {
			if (a.getText().equalsIgnoreCase(noticeLess15)) {
				a.click();
				System.out.println("Notice Period 15 Days or less click succssfully!!!");
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();

	}
	

	public void updateResume(String filePath) {
		wait.until(ExpectedConditions.elementToBeClickable(inputFile));
		inputFile.click();

		try {

			Robot rb = new Robot();
			rb.delay(2000);

			StringSelection ss = new StringSelection(filePath);

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			
			wait.until(ExpectedConditions.visibilityOf(CVUpdateSuccessMsg));
			
			String ResumeUploadedSuccessMsg = CVUpdateSuccessMsg.getText();
			
			assertEquals(ResumeUploadedSuccessMsg,"Resume has been successfully uploaded.");

			System.out.println("File Uploaded");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public String Title() {
		return driver.getTitle();
	}

}
