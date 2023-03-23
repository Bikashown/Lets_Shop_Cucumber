package Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
public class ReportEngine {
	static ExtentReports report;
	public static ExtentReports  getTestReport()
	{
		String path=System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("DemoReport");
		reporter.config().setDocumentTitle("Build Report");
		
		report=new ExtentReports();
		report.attachReporter(reporter);
		return report;
		
	}

}


