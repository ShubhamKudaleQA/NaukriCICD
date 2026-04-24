package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Shubham\\JAVA\\Naukri\\Properties\\TestData");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void intilization() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
	}

	public String getScreenshot(String testName, WebDriver driver) throws Exception {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//report//" + testName + ".png";
		File destination = new File(path);
		Files.copy(source, destination);
		return path;
	}

}
