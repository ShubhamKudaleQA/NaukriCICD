package TestComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	
	public static ExtentReports getReporterObject() {
		
		String path=System.getProperty("user.dir")+"\\report\\report.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Result");
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project Name", "Naukri Web Automation");
		extent.setSystemInfo("Tester", "Shubham K");
		
		return extent;
	}
	

}
