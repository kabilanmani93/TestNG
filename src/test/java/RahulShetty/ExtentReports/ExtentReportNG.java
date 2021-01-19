package RahulShetty.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.util.Date;

public class ExtentReportNG {

    //if a method is made static all its variables should also be static.
    // if static we can call the methods directly without instantiating
    static ExtentReports extent;
    public static ExtentReports extentReportsGenerator()
    {
        String fileName = getReportName();
        System.out.println(fileName);
        String directory = System.getProperty("user.dir")+"\\ExtentReport\\";
        //new File(directory).mkdirs();
        String path2 = directory +fileName;
        System.out.println(path2);
        //ExtentReports ExtentSparkReporter
        String path = System.getProperty("user.dir")+"\\ExtentReport\\index2323.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("eShipper Web Automation");
        reporter.config().setDocumentTitle("eShipper Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Kabilan Mani");

        return extent;

    }

    public static String getReportName(){
        Date d = new Date();
        String fileName = "AutomationReport" + d.toString().replace(":","_").replace(" ","_")+".html";
        return fileName;
    }

}
