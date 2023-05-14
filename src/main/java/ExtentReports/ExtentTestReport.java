package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Constants.Constants;

public class ExtentTestReport extends Constants {

	

	ExtentReports extent;


public void ConfigReport() {
	
	String Path = Constants.EXTENTREPORTPATH;
	ExtentSparkReporter reporter = new ExtentSparkReporter(Path);
	reporter.config().setTheme(Theme.DARK);
	reporter.config().setReportName("Pizzahut Application Automation Reports");
	reporter.config().setDocumentTitle("Test Results");
	
	extent=new ExtentReports();
	
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Raju Sharma");
}

	public void CreateTest() {
		
		 extent.createTest("Test Execution");
		
	}
	
	public void FlushTest() {
		extent.flush();
	}


}
