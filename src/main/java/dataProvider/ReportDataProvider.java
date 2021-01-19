package dataProvider;

import java.util.Date;
import java.util.Properties;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import factory.DataProviderFactory;

public class ReportDataProvider
{

	private static ExtentSparkReporter reporter;
	private static ExtentReports extent;
	ExtentTest test;

	public static ExtentReports createInstance()
	{
		String fileName = getReportName();
		reporter = new ExtentSparkReporter(DataProviderFactory.getConfig().getReportPath());
		reporter.config().setEncoding("utf-8");
		reporter.config().setDocumentTitle("eShipper Doc Title");
		reporter.config().setReportName("eShipper Test Results");
		reporter.config().setTheme(Theme.DARK);
		//reporter.config().setTestViewChartLocation(ChartLocation.TOP);

		extent = new ExtentReports();
		extent.setSystemInfo("Organization","ALTRAN");
		extent.setSystemInfo("Machine","Windows 10");
		extent.attachReporter(reporter);

		return extent;
	}

	public static String getReportName()
	{
		Date d = new Date();
		String fileName = "AutomationReport_"+d.toString().replace(":","_")+".html";
		return fileName;
	}

	public ExtentTest startReport(String TCName, String TCDescription)
	{
		test = extent.createTest(TCName,TCDescription);
		return test;
	}

	public static void endReport()
	{

		extent.flush();
	}

}





	/*Properties pro;
    static ExtentReports report;
    static ExtentTest logger;

    //Constructor
        public ReportDataProvider()
        {

            report = new ExtentReports(DataProviderFactory.getConfig().getReportPath(),true);
        }

        public ExtentTest startReport(String TCName, String TCDescription)
        {
            logger = report.startTest(TCName,TCDescription);
            return logger;
        }

        public static void endReport()
        {
            report.endTest(logger);
            report.flush();
        }
    */